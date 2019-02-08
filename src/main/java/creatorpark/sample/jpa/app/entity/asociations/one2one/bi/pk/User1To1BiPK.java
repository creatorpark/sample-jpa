package creatorpark.sample.jpa.app.entity.asociations.one2one.bi.pk;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity // Source Entity (own)
public class User1To1BiPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String password;

	@OneToOne(cascade= CascadeType.ALL)
	private Address1To1BiPK address;
}
