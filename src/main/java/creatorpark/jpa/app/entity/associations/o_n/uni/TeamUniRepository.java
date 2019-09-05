package creatorpark.jpa.app.entity.associations.o_n.uni;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamUniRepository extends JpaRepository<TeamUni,Long>, QuerydslPredicateExecutor<TeamUni> {

}
