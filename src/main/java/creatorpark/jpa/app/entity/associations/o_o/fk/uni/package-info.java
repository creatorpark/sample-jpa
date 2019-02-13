package creatorpark.jpa.app.entity.associations.o_o.fk.uni;

/* 
 * 단방향에서 Target Entity는 Source Entity의 존재를 모른다. 
 * Source -> Target 으로만 접근
 * 
 * Source Entity PK가 Target Entity의 FK로 참조 되는 경우
 *  
 * Source Entity 설정
 * @OneToOne( cascade=CascadeType.ALL)
 * @JoinColumn(name = "ADDRESS_ID")    // Own에서 매핑되는 FK명 - 생략가능
 */
