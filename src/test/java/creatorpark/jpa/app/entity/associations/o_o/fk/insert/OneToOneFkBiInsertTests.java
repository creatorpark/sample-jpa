package creatorpark.jpa.app.entity.associations.o_o.fk.insert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import creatorpark.jpa.app.entity.associations.o_o.fk.bi.AddressFkBi;
import creatorpark.jpa.app.entity.associations.o_o.fk.bi.UserFkBi;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToOneFkBiInsertTests {

	@PersistenceContext
	EntityManager em;
	
	@Test
	public void insert() {
		log.info("INSERT - user_fk_bi");
		UserFkBi user = UserFkBi.createUser("NOLLER", AddressFkBi.createAddress("NOLLGU", "HAVEN"));
		em.persist( user );
	}

}

