package creatorpark.jpa.app.entity.associations.o_n.bi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(of= {"id"})
@Entity
@NamedEntityGraph(
  name = "graph.players",
  attributeNodes = {
    @NamedAttributeNode("players")
  }
)
public class TeamBi implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="team")
	private List<PlayerBi> players = new ArrayList<PlayerBi>();
	
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for( PlayerBi plyerbi : players) {
			sb.append( plyerbi.toString() );
		}
		return "TeamBi [id=" + id + ", name=" + name + ",\nplayers=" + sb.toString() + "\n]";
	}
	
}
