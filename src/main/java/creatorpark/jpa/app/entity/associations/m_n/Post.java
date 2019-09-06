package creatorpark.jpa.app.entity.associations.m_n;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import creatorpark.jpa.app.entity.associations.o_n.bi.TeamBi;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of= {"id"})
@Entity // Parent, Source Entity
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "post_tag_details", 
		joinColumns = @JoinColumn(name = "post_id"), 
		inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tags = new HashSet<>();
	
	public void addTag(Tag tag) {
		tag.getPosts().add( this );
		tags.add(tag);
	}
	
	public void removeTag(Tag tag) {
		tag.getPosts().remove( this );
		tags.remove( tag );
	}
	
	public static Post createPost(String title) {
		Post post = new Post();
		post.setTitle(title);
		return post;
	}

}
