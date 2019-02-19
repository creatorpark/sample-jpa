package creatorpark.jpa.app.entity.associations.m_n;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import creatorpark.jpa.app.entity.associations.o_o.pk.uni.AddressPkUni;
import creatorpark.jpa.app.entity.associations.o_o.pk.uni.UserPkUni;
import lombok.extern.java.Log;


@Log
@Component
public class ManyToManyRunner implements ApplicationRunner {
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		
		persist();

	}
	

	private void persist() {
		log.info("PERSIST - M:N post");
		
		Post post = Post.createPost("HAHAHA");
		post.addTag(Tag.createTag("N!"));
		post.addTag(Tag.createTag("N2!"));
		post.addTag(Tag.createTag("N3!"));
		
		em.persist(post);
	}

}

