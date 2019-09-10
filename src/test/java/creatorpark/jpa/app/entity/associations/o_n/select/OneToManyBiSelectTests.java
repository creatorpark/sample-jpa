package creatorpark.jpa.app.entity.associations.o_n.select;

import static org.hamcrest.CoreMatchers.is;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

import creatorpark.jpa.app.entity.associations.o_n.bi.PlayerBi;
import creatorpark.jpa.app.entity.associations.o_n.bi.QPlayerBi;
import creatorpark.jpa.app.entity.associations.o_n.bi.QTeamBi;
import creatorpark.jpa.app.entity.associations.o_n.bi.TeamBi;
import creatorpark.jpa.app.entity.associations.o_n.bi.TeamBiRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToManyBiSelectTests {
	
	@Autowired
	JPAQueryFactory jpaQueryFactory;
	
	@Autowired
	TeamBiRepository repository;


	@Test
	@Transactional
	public void selectSpringDataWithInnerJoinFiltering() {
		TeamBi result = repository.findByIdAndPlayers_uniformNumber( 2L, "99");
		System.out.println(result.getPlayers().size());
		Assert.assertThat( result.getPlayers().size(), is(1) );
	}
	
//	@Test
	@Transactional
	public void selectWithInnerJoinFiltering() {
		QTeamBi team = QTeamBi.teamBi;
		QPlayerBi player = QPlayerBi.playerBi;
		TeamBi result = jpaQueryFactory
							.selectFrom(team)
								.innerJoin(team.players, player).fetchJoin() // fetchJoin() : Join과 동시 child 객체 Fetch도 같이 하도록. 
								.where(team.id.eq(1L)
								.and(player.uniformNumber.eq("99")))
								.fetchOne();
		Assert.assertThat( result.getPlayers().size(), is(1) );
	}

	private void joinWithPaging() {
		QTeamBi teamBi = QTeamBi.teamBi;
		QPlayerBi player = QPlayerBi.playerBi;

		// Join with paging
		// https://stackoverflow.com/questions/47701172/how-to-join-multiple-querydsl-tables
	    Predicate predicate = new BooleanBuilder();
	}
	
	private void insertData() {
		TeamBi team = TeamBi.createTeam("HANWHA");
		team.addPlayer( PlayerBi.createPlayer("IEE", "1"));
		team.addPlayer( PlayerBi.createPlayer("KEE", "2"));
		team.addPlayer( PlayerBi.createPlayer("JEE", "3"));
		team.addPlayer( PlayerBi.createPlayer("REE", "4"));
		team.addPlayer( PlayerBi.createPlayer("RYU", "99"));
		repository.saveAndFlush(team);
	}

}
