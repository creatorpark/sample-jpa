package creatorpark.jpa.app.entity.associations.o_n.insert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import creatorpark.jpa.app.entity.associations.o_n.bi.PlayerBi;
import creatorpark.jpa.app.entity.associations.o_n.bi.TeamBi;
import creatorpark.jpa.app.entity.associations.o_n.bi.TeamBiRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToManyBiInsertTests {


	@Autowired
	TeamBiRepository repository;
	
	@Test
	public void insert() {
		log.info("INSERT - 1:N team_bi");
		
		TeamBi team = TeamBi.createTeam("HANWHA");
		team.addPlayer( PlayerBi.createPlayer("N1", "1"));
		team.addPlayer( PlayerBi.createPlayer("N2", "2"));
		repository.save(team);
	}
}

