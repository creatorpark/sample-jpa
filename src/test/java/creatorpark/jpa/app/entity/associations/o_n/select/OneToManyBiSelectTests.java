package creatorpark.jpa.app.entity.associations.o_n.select;

import java.util.List;

import javax.transaction.Transactional;

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
public class OneToManyBiSelectTests {
	
	@Autowired
	TeamBiRepository repository;

	@Test
	@Transactional
	public void select() {
		
//		TeamBi team = TeamBi.createTeam("HANWHA");
//		team.addPlayer( PlayerBi.createPlayer("NAME1", "1"));
//		team.addPlayer( PlayerBi.createPlayer("NAME2", "2"));
//		team.addPlayer( PlayerBi.createPlayer("NAME3", "3"));
//		team.addPlayer( PlayerBi.createPlayer("NAME4", "4"));
//		team.addPlayer( PlayerBi.createPlayer("NAME5", "99"));
//		
//		repository.save(team);
//		
//		List<PlayerBi> result = repository.findRyu(2L, "99");
//		System.out.println(result.size());
//		System.out.println(result.get(0));
		
		List<TeamBi> result2 = repository.findRyuTeam(2L, "99");
		System.out.println(result2.size());
		System.out.println(result2.get(0));
	}
}
