package creatorpark.jpa.app.entity.associations.o_o.pk.bi;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity(name="user_pk") // Target Entity, Parent
public class UserPkBi implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String password;

	@OneToOne(mappedBy="user", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
	private AddressPkBi address;

	public void setAddress(AddressPkBi address) {
		this.address = address;
		this.address.setUser( this );
	}
	
	public static UserPkBi createUser(String name, AddressPkBi address ) {
		UserPkBi user = new UserPkBi();
		user.setPassword("HELLO");
		user.setName(name);
		user.setAddress( address );
		return user;
	}

}
