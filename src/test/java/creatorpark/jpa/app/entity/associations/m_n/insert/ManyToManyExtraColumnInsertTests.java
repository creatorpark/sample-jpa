package creatorpark.jpa.app.entity.associations.m_n.insert;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import creatorpark.jpa.app.entity.associations.m_n.extra.Book;
import creatorpark.jpa.app.entity.associations.m_n.extra.BookRepository;
import creatorpark.jpa.app.entity.associations.m_n.extra.Publisher;
import creatorpark.jpa.app.entity.associations.m_n.extra.PublisherRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyExtraColumnInsertTests {


	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void insert() {
		log.info("INSERT - M:N with Extra Column");
		
		Publisher p1 = new Publisher("한빛미디어");
		Publisher p2 = new Publisher("에어콘");
		Publisher p3 = new Publisher("두리뭉실");
		publisherRepository.saveAll( Arrays.asList(p1, p2, p3) );
		
		Book b1 = new Book("JPA");
		b1.addPublisher(p1);
		bookRepository.save( b1);
		
	}
}

