package creatorpark.jpa.app.entity.associations.o_o.pk.bi;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import creatorpark.jpa.app.entity.associations.o_o.pk.uni.AddressPkUni;
import creatorpark.jpa.vo.YesNo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Entity(name="address_pk") // Source Entity, Child
public class AddressPkBi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@MapsId
	// TODO Join 칼럼, 옵셔널 조건에 따른 SELECT시 JOIN, LEFT JOIN 되는거 조사
	@JoinColumn(name="id")
	@OneToOne(fetch = FetchType.LAZY)
	private UserPkBi user;
	  
	private String state;
	private String city;
	
	public static AddressPkBi createAddress(String state, String city ) {
		AddressPkBi address = new AddressPkBi();
		address.setState( state );
		address.setCity( city );
		return address;
	}
}
