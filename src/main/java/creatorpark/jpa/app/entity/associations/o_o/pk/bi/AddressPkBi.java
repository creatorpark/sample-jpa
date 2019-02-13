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

import creatorpark.jpa.vo.YesNo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Entity // Target Entity
public class AddressPkBi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@MapsId
	@JoinColumn(name="ID")
	@OneToOne(mappedBy="address") //own에서 만든 target entity의 객체명
	private UserPkBi user;
	  
	private String zipCode;
	private String state;
	private String city;
	private String addressLine1;
	private String addressLine2;
	
}
