package creatorpark.jpa.app.entity.associations.o_n.uni;

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

import creatorpark.jpa.app.entity.associations.o_n.bi.TeamBi;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(callSuper=false, exclude= {"players"})
@Entity
public class TeamUni implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PlayerUni> players = new HashSet<>();

	public static TeamUni createTeam(String name) {
		TeamUni team = new TeamUni();
		team.setName(name);
		return team;
	}
	
}
