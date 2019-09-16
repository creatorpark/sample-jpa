package creatorpark.jpa.app.entity.associations.o_n.recursive;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import creatorpark.jpa.app.entity.associations.recursive.CommonCode;
import creatorpark.jpa.app.entity.associations.recursive.CommonCodeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToManyRecursiveInsertTests {
// https://stackoverflow.com/questions/3393515/jpa-how-to-have-one-to-many-relation-of-the-same-entity-type
// N+1 문제 발생하는거 NameEntityGraph로 해결
	
	@Autowired
	CommonCodeRepository repository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void insert() {
		log.info("INSERT - Recursive 1:N");
		
		CommonCode parent = new CommonCode();
		parent.setCode(1);


		CommonCode child = new CommonCode();
		child.setCode(10);
		child.setParent(parent);
		parent.addChild(child);
		
		repository.save(parent);
		repository.save(child);

		CommonCode commonCode = repository.findByCode(10);
		
		log.info(commonCode.toString());
		
		CommonCode pCommonCode = repository.findByCode(1);
		log.info(pCommonCode.toString());
	}
}

