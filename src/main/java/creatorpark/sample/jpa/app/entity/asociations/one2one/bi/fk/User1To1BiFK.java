package creatorpark.sample.jpa.app.entity.asociations.one2one.bi.fk;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Entity // Source Entity (Oown)
public class User1To1BiFK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String password;

	@OneToOne( cascade= CascadeType.ALL, mappedBy="user" ) // user는 non-own entity에서 만든 own entity의 객체명
	private Addressl1To1BiFK address;
}
