package creatorpark.jpa.app.entity.associations.o_o.pk.uni;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import creatorpark.jpa.vo.YesNo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Entity // Target Entity
public class AddressPkUni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String state;
	private String city;
	
}
