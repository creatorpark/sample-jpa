package creatorpark.jpa.infra.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericListController<T, ID extends Serializable, RES_DTO, REPO extends GenericRepository<T, ID> > {

	protected Class<RES_DTO> resDtoClass; 
	
	@Autowired 
	protected REPO repository; 
	
	protected GenericListController() {}
	
	protected GenericListController(Class<RES_DTO> resDtoClass) {
		this.resDtoClass = resDtoClass; 
	}
	

	protected ResponseEntity<ListResDto<RES_DTO>> listProcess(Predicate predicate, Pageable pageable) {
		ListResDto<RES_DTO> resList = getListDto(predicate, pageable); 
		return new ResponseEntity<ListResDto<RES_DTO>>(resList, HttpStatus.OK); 
	}
	
	protected ListResDto<RES_DTO> getListDto(Predicate predicate, Pageable pageable) {
		Page<T> list = repository.findAll(predicate, pageable);
		int currentPage = list.getNumber();
		int totalPages = list.getTotalPages(); 
		long totalRecords = list.getTotalElements();
		ListResDto<RES_DTO> resList = new ListResDto<RES_DTO>(currentPage, totalPages, totalRecords, convertDtoList(list)); 
		return resList; 
	}
	
	protected List<RES_DTO> convertDtoList(Page<T> page) {
		List<T> convert = Lists.newArrayList(page.iterator());
		List<RES_DTO> targetList = new ArrayList<RES_DTO>();
		
		RES_DTO resDto = null; 
		
		for(T item : convert) {
			
			try {
				resDto = resDtoClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				log.error("t.newInstance() " + e.getMessage()); 
			}			
			
			BeanUtils.copyProperties(item, resDto);
			targetList.add(resDto);
		}
		return targetList; 
	}
}
