package creatorpark.jpa.infra.audit;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditCreateBy {
  
  @CreatedBy
  @Column(name = "CREATED_BY", insertable=true, updatable=false)
  protected String createdBy;
    
  @CreatedDate
  @Column(name = "CREATED_DATE", insertable=true, updatable=false)
  protected LocalDateTime createdDate; 


  public AuditCreateBy() {

  }

}
