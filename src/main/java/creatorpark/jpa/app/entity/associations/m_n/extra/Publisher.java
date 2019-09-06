package creatorpark.jpa.app.entity.associations.m_n.extra;

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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of= {"id"})
@Entity // Parent, Source Entity
public class Publisher implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	public Publisher(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy="publisher", cascade = CascadeType.ALL, orphanRemoval = true ) 
	private List<BookPublisher> bookPublishers = new ArrayList<>();
}
