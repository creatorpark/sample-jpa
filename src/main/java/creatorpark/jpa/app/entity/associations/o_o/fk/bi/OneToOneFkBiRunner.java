package creatorpark.jpa.app.entity.associations.o_o.fk.bi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import creatorpark.jpa.app.entity.associations.o_o.pk.uni.AddressPkUni;
import creatorpark.jpa.app.entity.associations.o_o.pk.uni.UserPkUni;
import lombok.extern.java.Log;

@Component
@Log
public class OneToOneFkBiRunner implements ApplicationRunner {
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		
		persist();

	}
	
	/*  
	 * 양방향은 Source Entity에서도 Target Entity의 참조를 갖게 된다.
	 * Source Entity <-> Target Entity 서로 참조되도록<양방향> 한다는 뜻.
	 *  
	 * Source Entity PK와 Target Entity의 PK가 같은 경우 (Shared Primary Key)
	 */
	private void persist() {
		log.info("PERSIST - user_fk_bi");
		UserFkBi user = UserFkBi.createUser("NOLLER", AddressFkBi.createAddress("NOLLGU", "HAVEN"));
		em.persist( user );
	}

}

