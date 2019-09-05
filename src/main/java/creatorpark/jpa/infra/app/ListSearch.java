package creatorpark.jpa.infra.app;

import java.io.Serializable;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListSearch implements Serializable {

	private static final long serialVersionUID = 1L;

	private int page = 1; 
	private int rows = 10; 
	private Direction sord = Direction.DESC;
	private String sidx = "id"; 
	
	public ListSearch() {}
	
	public PageRequest pageRequest() {
		PageRequest pageRequest = PageRequest.of(page-1, rows); 
		return pageRequest; 
	}
	
	public PageRequest boPageRequest() {
		Sort sort = new Sort(sord, sidx); 
		return PageRequest.of(page-1, rows, sort); 
	}
	
	public PageRequest pageRequest(Sort.Direction direction, String orderBy) {
		Sort sort = new Sort(direction, orderBy);
		return PageRequest.of(page-1, rows, sort); 
	}
	
	public PageRequest pageRequest(Sort sort) {
		return PageRequest.of(page-1,  rows, sort); 
	}
	
	public void setSord(String sord) {
		this.sord = Direction.fromString(sord); 
	}
}
