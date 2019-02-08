package creatorpark.sample.jpa.app.entity.asociations.one2one.bi.pk;

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

import creatorpark.sample.jpa.vo.YesNo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Entity // Target Entity (non-own)
public class Address1To1BiPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@MapsId
	@JoinColumn(name="ID")
	@OneToOne(mappedBy="address") //own에서 만든 target entity의 객체명
	private User1To1BiPK user;
	  
	private String zipCode;
	private String state;
	private String city;
	private String addressLine1;
	private String addressLine2;
	
}
