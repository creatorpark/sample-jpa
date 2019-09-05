package creatorpark.jpa.app.entity.associations.o_n.uni;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(of= {"id"})
@Entity
public class TeamUni implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PlayerUni> players = new ArrayList<>();

	public static TeamUni createTeam(String name) {
		TeamUni team = new TeamUni();
		team.setName(name);
		return team;
	}
	
}
