package creatorpark.jpa.app.entity.associations.o_n.bi;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import creatorpark.jpa.app.entity.associations.o_n.uni.TeamUni;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(of= {"id"})
@Entity(name="team")
public class TeamBi implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="team", orphanRemoval = true)
	private Set<PlayerBi> players = new HashSet<>();
	
	public void addPlayer(PlayerBi player) {
		player.setTeam( this );
		players.add( player );
	}
	
	public void removePlayer(PlayerBi player) {
		player.setTeam( null );
		players.remove( player );
	}
	
	public static TeamBi createTeam(String name) {
		TeamBi team = new TeamBi();
		team.setName(name);
		return team;
	}
	
	
}
