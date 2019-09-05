package creatorpark.jpa.infra.app;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListResDto<DTO> implements Serializable {

	private static final long serialVersionUID = 1L;

	private int totalPages; 
	private int currentPage; 
	private long totalRecords; 
	
	private List<DTO> data; 
	
	public ListResDto(int currentPage, int totalPages, long totalRecords, List<DTO> data) {
		this.currentPage = currentPage + 1; 
		this.totalPages = totalPages; 
		this.totalRecords = totalRecords; 
		this.data = data; 
	}

	@Override
	public String toString() {
		return "ListDto [totalPages=" + totalPages + ", currentPage=" + currentPage + ", totalRecords=" + totalRecords
				+ ", data=" + data + "]";
	}
	
}
