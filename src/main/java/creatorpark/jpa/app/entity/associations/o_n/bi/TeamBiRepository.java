package creatorpark.jpa.app.entity.associations.o_n.bi;

import java.util.List;

import org.springframework.stereotype.Repository;

import creatorpark.jpa.infra.app.GenericRepository;

@Repository
public interface TeamBiRepository extends GenericRepository<TeamBi, Long> {

	List<TeamBi> findByPlayers_uniformNumber(String uniformNumber);

}
 