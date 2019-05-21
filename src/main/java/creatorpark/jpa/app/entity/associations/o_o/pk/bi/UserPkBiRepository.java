package creatorpark.jpa.app.entity.associations.o_o.pk.bi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPkBiRepository extends JpaRepository<UserPkBi,Long> {

}
