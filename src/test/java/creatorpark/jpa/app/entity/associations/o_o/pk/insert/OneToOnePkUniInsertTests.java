package creatorpark.jpa.app.entity.associations.o_o.pk.insert;

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
import creatorpark.jpa.app.entity.associations.o_o.pk.uni.AddressPkUni;
import creatorpark.jpa.app.entity.associations.o_o.pk.uni.UserPkUni;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToOnePkUniInsertTests {

	@PersistenceContext
	EntityManager em;
	
	/* 
	 * 단방향에서 Target Entity는 Source Entity의 존재를 모른다. Source -> Target으로만 접근
	 * 그래서 user를 먼저 저장한 다음에 여기서 생긴 PK를 갖고 수작업으로 address에 저장한 다음에 저장해야 한다.
	 * 고로 @OneToOne 단방향은 추천하지 않는다.
	 */
	@Test
	public void insert() {
		log.info("INSERT 1 - user_pk");
		UserPkUni user = UserPkUni.createUser("JH");
		em.persist(user);
		
		log.info("INSERT 2 - address_pk");
		AddressPkUni address = AddressPkUni.createAddress(user, "SEODAEMUN", "SEOUL");
		em.persist( address );
		
		em.flush();
	}

}

