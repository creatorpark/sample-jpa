package creatorpark.jpa.app.entity.associations.o_n.select;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.jpa.impl.JPAQueryFactory;

import creatorpark.jpa.app.entity.associations.o_n.uni.QPlayerUni;
import creatorpark.jpa.app.entity.associations.o_n.uni.QTeamUni;
import creatorpark.jpa.app.entity.associations.o_n.uni.TeamUni;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToManyUniSelectTests2 {
	
	@Autowired
	JPAQueryFactory jpaQueryFactory;

	@Test
	@Transactional
	public void select() {

		
		QTeamUni teamUni = QTeamUni.teamUni;
		QPlayerUni player = QPlayerUni.playerUni;
		List<TeamUni> result = jpaQueryFactory.selectFrom(teamUni)
							.innerJoin(teamUni.players, player)
							.on(player.uniformNumber.eq("99"))
							.where(teamUni.id.eq(1L)).fetch();
							
	
		System.out.println(result.size());
		System.out.println(result.get(0));
	}
}
