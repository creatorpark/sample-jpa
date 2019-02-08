package creatorpark.sample.jpa.app.entity.asociations.one2one.uni.fk;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Entity // Source Entity (Own : FK를 소유하는)
public class User1To1UniFK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String password;
	
	@OneToOne( cascade= CascadeType.ALL)
	//@JoinColumn( name = "ADDRESS_ID") 생략가능, 위치는 Own
	private Address1To1UniFK address;
}
