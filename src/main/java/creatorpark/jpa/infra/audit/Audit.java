package creatorpark.jpa.infra.audit;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

//Spring-Data에서 제공하는 Auditing 서비스.
@Getter
@Setter
@Embeddable
@EntityListeners(AuditingEntityListener.class)
public class Audit {
  
  @CreatedBy
  @Column(name = "CREATED_BY", insertable=true, updatable=false)
  protected String createdBy;
    
  @CreatedDate
  @Column(name = "CREATED_DATE", insertable=true, updatable=false)
  protected LocalDateTime createdDate; 
  
  @LastModifiedBy
  @Column(name = "LAST_MODIFIED_BY", insertable=true, updatable=true)
  protected String lastModifiedBy;
  
  @LastModifiedDate
  @Column(name = "LAST_MODIFIED_DATE", insertable=true, updatable=true)
  protected LocalDateTime lastModifiedDate; 
  
  public Audit() {

  }

}
