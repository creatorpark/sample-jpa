package creatorpark.jpa.app.entity.associations.o_o.pk;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import creatorpark.jpa.ApplicationTests;
import creatorpark.jpa.app.entity.associations.o_o.fk.uni.AddressFkUni;
import creatorpark.jpa.app.entity.associations.o_o.fk.uni.UserFkUni;
import creatorpark.jpa.app.entity.associations.o_o.pk.bi.AddressPkBi;
import creatorpark.jpa.app.entity.associations.o_o.pk.bi.UserPkBi;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToOnePkBiTests {

	@PersistenceContext
	EntityManager em;
	
	@Test
	public void persist() {
		UserPkBi user = UserPkBi.createUser("HELLO", AddressPkBi.createAddress("NOLLGU", "HAVEN"));
		em.persist( user );
	}

}

