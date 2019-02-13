package creatorpark.jpa.app.entity.associations.o_o.pk.uni;

/* 
 * 단방향에서 Target Entity는 Source Entity의 존재를 모른다. 
 * Source -> Target으로만 접근
 * 
 * @OneToOne PK UniDirection 설정
 * - Source Entity에 다음 annotation을 추가한다.
 * 
 * @OneToOne(cascade= CascadeType.ALL)
 * @PrimaryKeyJoinColumn
 * private TargetEntity targetEntity;
 * 
 */
