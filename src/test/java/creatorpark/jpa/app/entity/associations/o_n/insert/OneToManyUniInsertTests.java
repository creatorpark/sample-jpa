package creatorpark.jpa.app.entity.associations.o_n.insert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import creatorpark.jpa.ApplicationTests;
import creatorpark.jpa.app.entity.associations.o_n.uni.PlayerUni;
import creatorpark.jpa.app.entity.associations.o_n.uni.TeamUni;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToManyUniInsertTests {


	@PersistenceContext
	EntityManager em;
	
	@Test
	public void insert() {
		log.info("INSERT - 1:N team_uni");
		TeamUni team = TeamUni.createTeam("NOLLS");
		team.getPlayers().add( PlayerUni.createPlayer("N1", "1"));
		team.getPlayers().add( PlayerUni.createPlayer("N2", "2"));
		em.persist( team );
	}
}

