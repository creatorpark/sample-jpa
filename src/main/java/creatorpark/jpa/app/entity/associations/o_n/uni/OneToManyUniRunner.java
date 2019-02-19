package creatorpark.jpa.app.entity.associations.o_n.uni;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import creatorpark.jpa.app.entity.associations.o_o.pk.uni.AddressPkUni;
import creatorpark.jpa.app.entity.associations.o_o.pk.uni.UserPkUni;
import lombok.extern.java.Log;

@Log
//@Component
public class OneToManyUniRunner implements ApplicationRunner {
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		
		persist();

	}
	

	private void persist() {
		log.info("PERSIST - 1:N team_uni");
		TeamUni team = TeamUni.createTeam("NOLLS");
		team.getPlayers().add( PlayerUni.createPlayer("N1", "1"));
		team.getPlayers().add( PlayerUni.createPlayer("N2", "2"));
		em.persist( team );
	}

}

