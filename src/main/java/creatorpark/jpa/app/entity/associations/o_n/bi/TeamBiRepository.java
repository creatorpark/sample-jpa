package creatorpark.jpa.app.entity.associations.o_n.bi;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import creatorpark.jpa.infra.app.GenericRepository;

@Repository
public interface TeamBiRepository extends GenericRepository<TeamBi, Long> {

	List<TeamBi> findByPlayers_uniformNumber(String uniformNumber);

	@Query("SELECT t, p "
	    + "   FROM TeamBi t JOIN FETCH PlayerBi p on t.id = p.team "
		+ "  WHERE t.id=:id "
		+ "    AND p.uniformNumber = :uniformNumber ")
	TeamBi findRyuTeam(@Param("id") Long id,@Param("uniformNumber")String uniformNumber);
}
 