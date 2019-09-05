package creatorpark.jpa.app.entity.associations.o_o.fk.insert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import creatorpark.jpa.app.entity.associations.o_o.fk.bi.AddressFkBi;
import creatorpark.jpa.app.entity.associations.o_o.fk.bi.UserFkBi;
import creatorpark.jpa.app.entity.associations.o_o.fk.bi.UserFkBiRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToOneFkBiInsertTests {

	@Autowired
	UserFkBiRepository repository;
	
	@Test
	public void insert() {
		log.info("INSERT - user_fk_bi");
		UserFkBi user = UserFkBi.createUser("NOLLER", AddressFkBi.createAddress("SEOUL", "SAEDAEMUN"));
		repository.save(user);
	}

}

