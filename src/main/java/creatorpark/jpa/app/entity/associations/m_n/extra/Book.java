package creatorpark.jpa.app.entity.associations.m_n.extra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of= {"id"})
@Entity // Parent, Source Entity
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	public Book(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy="book", cascade = CascadeType.ALL, orphanRemoval = true ) 
	private List<BookPublisher> bookPublisherList = new ArrayList<>();
	
	public void addPublisher(Publisher publisher) {
		BookPublisher bookPublisher = new BookPublisher(this, publisher);
		bookPublisherList.add(bookPublisher);
		publisher.getBookPublishers().add( bookPublisher );
	}
	
	public void removePublisher(Publisher publisher) {
		for (BookPublisher bookPublisher : bookPublisherList) {
			
			if ( bookPublisher.getBook().equals(this) && bookPublisher.getPublisher().equals(publisher) ) {
				bookPublisherList.remove(bookPublisher); // 내것
				bookPublisher.getPublisher().getBookPublishers().remove( bookPublisher ); // 반대편
				bookPublisher.setBook(null);
				bookPublisher.setPublisher(null);
			}
		}
	}
}
