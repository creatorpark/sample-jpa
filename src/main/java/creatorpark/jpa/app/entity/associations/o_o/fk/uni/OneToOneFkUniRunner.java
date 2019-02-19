package creatorpark.jpa.app.entity.associations.o_o.fk.uni;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.java.Log;

@Log
//@Component
public class OneToOneFkUniRunner implements ApplicationRunner {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		persist();
		//select 한번에 가져오는지 테스트
		
	}

	/* 
	 * 단방향에서 Target Entity는 Source Entity의 존재를 모른다. Source -> Target으로만 접근
	 * 그래서 user를 먼저 저장한 다음에 여기서 생긴 PK를 갖고 수작업으로 address에 저장한 다음에 저장해야 한다.
	 * 고로 @OneToOne 단방향은 추천하지 않는다.
	 */
	private void persist() {
		log.info("PERSIST 1 - user_fk");
		UserFkUni user = UserFkUni.createUser("JH");
		em.persist(user);
		
		log.info("PERSIST 2 - address_fk");
		AddressFkUni address = AddressFkUni.createAddress(user, "MAPOGU", "SEOUL");
		em.persist( address );
		
		em.flush();
	}
	

}

