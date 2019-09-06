package creatorpark.jpa.app.entity.associations.m_n.extra;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode( of= {"bookId", "publisherId"})
@Embeddable
public class BookPublisherId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="book_id")
	private Long bookId;
	
	@Column(name="publisher_id")
	private Long publisherId;
	
	
	
	
}
