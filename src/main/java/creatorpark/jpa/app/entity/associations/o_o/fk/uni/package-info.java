package creatorpark.jpa.app.entity.associations.o_o.fk.uni;

/* 
 * 단방향에서 Target Entity는 Source Entity의 존재를 모른다. 
 * Source -> Target으로만 접근
 * 
 * @OneToOne FK UniDirection FK 설정 
 * - Source Entity에 다음을 추가한다.
 * - @OneToOne( cascade=CascadeType.ALL)
 * - @JoinColumn(name = "ADDRESS_ID")    // Own에서 매핑되는 FK명 - 생략가능
 */
