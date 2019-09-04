package creatorpark.jpa.app.entity.associations.o_n.bi;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import creatorpark.jpa.vo.YesNo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of= {"id"})
@Entity
public class PlayerBi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String uniformNumber;
	
	@JoinColumn(name="team_bi_id")
	@ManyToOne
	private TeamBi team = new TeamBi();;
	
	public static PlayerBi createPlayer(String name, String uniformNumber) {
		PlayerBi player = new PlayerBi();
		player.setName( name );
		player.setUniformNumber( uniformNumber );
		return player;
	}

	@Override
	public String toString() {
		return "\nPlayer [id=" + id + ", uniformNumber=" + uniformNumber + "]";
	}
	  
}
