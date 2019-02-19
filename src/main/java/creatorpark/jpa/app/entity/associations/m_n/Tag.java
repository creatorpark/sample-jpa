package creatorpark.jpa.app.entity.associations.m_n;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false, exclude= {"posts"})
@Entity // Target Entity
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy="tags")
	private Set<Post> posts = new HashSet<>();
	
	public static Tag createTag(String name) {
		Tag tag = new Tag();
		tag.setName(name);
		return tag;
	}
}
