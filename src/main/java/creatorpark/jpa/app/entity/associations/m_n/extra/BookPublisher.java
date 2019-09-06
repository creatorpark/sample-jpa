package creatorpark.jpa.app.entity.associations.m_n.extra;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of= {"id"})
@Entity
public class BookPublisher implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private BookPublisherId id;
	
	@ManyToOne( fetch = FetchType.LAZY)
	@MapsId("bookId")
	private Book book;

	@ManyToOne( fetch = FetchType.LAZY)
	@MapsId("publisherId")
	private Publisher publisher;

	private String contractDate;

	public BookPublisher(Book book, Publisher publisher) {
		this.book = book;
		this.publisher = publisher;
		this.id = new BookPublisherId(book.getId(), publisher.getId());
	}
	
	
	
}
