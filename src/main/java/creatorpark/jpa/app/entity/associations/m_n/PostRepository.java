package creatorpark.jpa.app.entity.associations.m_n;

import org.springframework.stereotype.Repository;

import creatorpark.jpa.infra.app.GenericRepository;

@Repository
public interface PostRepository extends GenericRepository<Post, Long> {

}
