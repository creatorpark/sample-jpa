package creatorpark.jpa.app.entity.associations.o_o.pk.uni;

/* 
 * Source Entity (Own : FK를 소유하는(own))
 * Target Entity (Non-Own)
 * 이 둘은 DB에서 JOIN할 때 누가 FK키를 소유하고 있는지를 나타낸다.
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
