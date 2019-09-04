package creatorpark.jpa.app.entity.associations.o_n.bi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamBiRepository extends JpaRepository<TeamBi,Long>, QuerydslPredicateExecutor<TeamBi> {

//	List<TeamBi> findByPlayers_uniformNumber(String uniformNumber);
	
	@Query("SELECT t,p "
		+ "   FROM TeamBi t INNER JOIN PlayerBi p on t.id = p.team"
		+ "  WHERE t.id=:id"
		+ "    AND p.uniformNumber = :uniformNumber ") 
	TeamBi findRyu(@Param("id") Long id,@Param("uniformNumber")String uniformNumber);
}
