package creatorpark.jpa.infra.audit;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.querydsl.core.annotations.QueryExclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@QueryExclude // QClass 생성시 제외
@MappedSuperclass
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
