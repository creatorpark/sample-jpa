package creatorpark.jpa.app.entity.associations.o_o.pk.bi;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of={"id"}, callSuper=false)
@Entity (name="address_pk")
// Source Entity, Child
public class AddressPkBi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@JsonIgnore
	@MapsId
	@JoinColumn(name="id")
	@OneToOne( fetch = FetchType.LAZY, optional = false)
	private UserPkBi user;

    
	private String state;
	private String city;
	
	public static AddressPkBi createAddress(String state, String city ) {
		AddressPkBi address = new AddressPkBi();
		address.setState( state );
		address.setCity( city );
		return address;
	}

	@Override
	public String toString() {
		return "AddressPkBi [id=" + id + ", state=" + state + ", city=" + city + "]";
	}
}
