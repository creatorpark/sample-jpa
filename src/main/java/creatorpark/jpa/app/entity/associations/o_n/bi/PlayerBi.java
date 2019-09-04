package creatorpark.jpa.app.entity.associations.o_n.bi;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="team_bi_id")
	@ManyToOne(optional = false)
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
