package creatorpark.jpa.app.entity.associations.o_o.fk.bi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToOneFkBiTest {
	
	@PersistenceContext
	EntityManager em;

	@Test
	@Transactional
	public void persist() { // 신규 생성
		UserFkBi user = UserFkBi.createUser("JH", AddressFkBi.createAddress("SUDEMUN", "SEOUL"));
		log.info("BEFORE PERSIST");
		em.persist(user);
		log.info("AFTER PERSIST");
		log.info("IS CONTAIN : " + em.contains( user ));
		em.flush();
	}
	
	@Test
	// 조회로 넘어온 데이터 다시 수정
	public void merge() {
		UserFkBi user = new UserFkBi(); 
	}
	
	
}

