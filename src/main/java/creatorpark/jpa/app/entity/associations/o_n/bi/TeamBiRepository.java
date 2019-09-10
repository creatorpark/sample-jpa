package creatorpark.jpa.app.entity.associations.o_n.bi;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import creatorpark.jpa.infra.app.GenericRepository;

@Repository
public interface TeamBiRepository extends GenericRepository<TeamBi, Long> {


	@EntityGraph(value = "graph.players", type = EntityGraphType.LOAD)
	TeamBi findByIdAndPlayers_uniformNumber(Long id, String uniformNumber);

	@Query("SELECT t, p "
	    + "   FROM TeamBi t JOIN PlayerBi p on t.id = p.team "
		+ "  WHERE t.id=:id "
		+ "    AND p.uniformNumber = :uniformNumber ")
	@EntityGraph(value = "graph.players", type = EntityGraphType.LOAD)
	TeamBi findByRyuTeam(@Param("id") Long id,@Param("uniformNumber")String uniformNumber);
}
 