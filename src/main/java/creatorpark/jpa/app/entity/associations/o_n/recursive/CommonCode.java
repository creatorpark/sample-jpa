package creatorpark.jpa.app.entity.associations.o_n.recursive;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of= {"id"})
@Entity
public class CommonCode implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer code;

	@ManyToOne
	private CommonCode parent;
	
	@OneToMany(mappedBy="parent")
	private List<CommonCode> children = new ArrayList<CommonCode>();
	
	public void addChild(CommonCode child) {
		child.setParent( this );
		children.add(child);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (CommonCode commonCode : children) {
			sb.append(" " + commonCode.getCode() );
		}
		
		return "CommonCode [id=" + id + ", code=" + code
				+ ", parentCode=" + parent.getCode()
				+ ", " + children.toString()  + "]";
	}
	
}
