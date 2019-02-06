package sample.infra.audit;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

//Spring-Data에서 제공하는 Auditing 서비스.
@Getter
@Setter
@Embeddable
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
