package creatorpark.jpa.app.entity.associations.o_o.fk.uni;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import creatorpark.jpa.app.entity.associations.o_o.pk.uni.AddressPkUni;
import creatorpark.jpa.app.entity.associations.o_o.pk.uni.UserPkUni;
import creatorpark.jpa.vo.YesNo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Entity(name="address_fk")  // Source Entity
public class AddressFkUni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String state;
	private String city;
	
	@OneToOne( cascade= CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserFkUni user;
	
	public static AddressFkUni createAddress(UserFkUni user, String state, String city) {
		AddressFkUni address = new AddressFkUni();
		address.setState( state );
		address.setCity( city );
		address.setUser( user );
		return address;
	}
	
	public void setUser(UserFkUni user) {
		// 2번 세팅해준다. 별로네 양방향 mapsId가 좋다.
		this.user = user;
	}
	
}
