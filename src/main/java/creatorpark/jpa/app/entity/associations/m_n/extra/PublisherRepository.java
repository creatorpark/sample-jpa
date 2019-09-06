package creatorpark.jpa.app.entity.associations.m_n.extra;

import org.springframework.stereotype.Repository;

import creatorpark.jpa.infra.app.GenericRepository;

@Repository
public interface PublisherRepository extends GenericRepository<Publisher, Long> {

}
