package creatorpark.jpa.app.entity.associations.o_o.pk.uni;

/* 
 * @OneToOne 관계에서
 * Source Entity (Own : FK를 소유하는(own))
 * Target Entity (Non-Own)
 * 
 * Target Entity는 Source Entity의 존재를 모른다. 
 * 
 * 1:1 PK UniDirection 설정 (Source -> Target)
 * - Source Entity에 다음 annotation을 추가한다.
 * 
 * @OneToOne(cascade= CascadeType.ALL)
 * @PrimaryKeyJoinColumn
 * private TargetEntity targetEntity;
 */
