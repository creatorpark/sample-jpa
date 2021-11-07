package creatorpark.jpa.app.entity.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

import creatorpark.jpa.infra.audit.Audit;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@EqualsAndHashCode(of="id", callSuper=false)
public class Account extends Audit implements Serializable {
	// https://stackoverflow.com/questions/2020904/when-and-why-jpa-entities-should-implement-serializable-interface
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Embedded // ValueObject를 만드는데 사용
	private Money amount;
	
	@ElementCollection // 전체를 DEL and INSERT 이기 때문에 설문지에서 다중선택 같은 경우에 사용하기 좋을 듯 
	@CollectionTable(name="INTERESTS", joinColumns = @JoinColumn(name="ID"))// @JoinColumn ID 는 Account의 Id값이다. 
	private Collection<Interest> interests = new ArrayList<>();
	
	@ElementCollection
//	@CollectionTable(name="ACCOUNT_ADDRESSES", joinColumns = @JoinColumn(name="ID")) //  이 어노테이션은 상세설정이다. 생략가능하다.
	@MapKeyColumn(name="ADDRESS_TITLE") // <엄마집, 주소> 이렇게 매핑해서 쓴다. ADDRESS_TITLE은 DB의 칼럼
	private Map<String, Address> addresses = new HashMap<>(); 
}
