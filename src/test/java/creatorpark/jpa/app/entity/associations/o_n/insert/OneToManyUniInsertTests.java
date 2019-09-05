package creatorpark.jpa.app.entity.associations.o_n.insert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import creatorpark.jpa.app.entity.associations.o_n.uni.PlayerUni;
import creatorpark.jpa.app.entity.associations.o_n.uni.TeamUni;
import creatorpark.jpa.app.entity.associations.o_n.uni.TeamUniRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToManyUniInsertTests {

	@Autowired
	TeamUniRepository repository;

	@Test
	public void insert() {
		log.info("INSERT - 1:N team_uni");
		TeamUni team = TeamUni.createTeam("HANWHA");
		team.getPlayers().add( PlayerUni.createPlayer("N1", "1"));
		team.getPlayers().add( PlayerUni.createPlayer("N2", "99"));
		repository.save( team );
	}
}

