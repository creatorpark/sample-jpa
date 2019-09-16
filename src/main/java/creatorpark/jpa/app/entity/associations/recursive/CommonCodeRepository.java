package creatorpark.jpa.app.entity.associations.recursive;

import org.springframework.stereotype.Repository;

import creatorpark.jpa.infra.app.GenericRepository;

@Repository
public interface CommonCodeRepository extends GenericRepository<CommonCode, Long> {


	public CommonCode findByCode(Integer code);
}
 