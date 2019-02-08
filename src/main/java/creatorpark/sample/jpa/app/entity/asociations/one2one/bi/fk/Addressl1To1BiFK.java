package creatorpark.sample.jpa.app.entity.asociations.one2one.bi.fk;

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
public class Addressl1To1BiFK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@MapsId
	@OneToOne( fetch = FetchType.LAZY)
	private User1To1BiFK user;
	  
	private String zipCode;
	private String state;
	private String city;
	private String addressLine1;
	private String addressLine2;
}
