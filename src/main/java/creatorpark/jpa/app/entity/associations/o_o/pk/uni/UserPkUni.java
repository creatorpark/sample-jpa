package creatorpark.jpa.app.entity.associations.o_o.pk.uni;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import creatorpark.jpa.app.entity.associations.o_o.fk.bi.AddressFkBi;
import creatorpark.jpa.app.entity.associations.o_o.fk.bi.UserFkBi;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Entity(name="user_pk") // Target Entity
public class UserPkUni implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String password;
	
	public static UserPkUni createUser(String name ) {
		UserPkUni user = new UserPkUni();
		user.setPassword("PK_HELLO");
		user.setName(name);
		return user;
	}
}
