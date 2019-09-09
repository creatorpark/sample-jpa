package creatorpark.jpa.app.entity.associations.o_o.pk.insert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import creatorpark.jpa.app.entity.associations.o_o.pk.bi.AddressPkBi;
import creatorpark.jpa.app.entity.associations.o_o.pk.bi.UserPkBi;
import creatorpark.jpa.app.entity.associations.o_o.pk.bi.UserPkBiRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToOnePkBiInsertTests {

	@Autowired
	UserPkBiRepository repository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void insert() {
		UserPkBi user = UserPkBi.createUser("HELLO", AddressPkBi.createAddress("놀구", "있네"));
		System.out.println(user);
		repository.save(user);
		System.out.println(user);
	}

}

