package creatorpark.jpa.app.entity.associations.o_o.fk.uni;

/* 
 * Source Entity (Own : FK를 소유하는(own))
 * Target Entity (Non-Own)
 * 이 둘은 DB에서 JOIN할 때 누가 FK키를 소유하고 있는지를 나타낸다.
 * 
 * One2One UniDirection FK 설정 
 * - Source Entity에 다음을 추가한다.
 * - @OneToOne( cascade=CascadeType.ALL)
 * - @JoinColumn(name = "ADDRESS_ID")    // Own에서 매핑되는 FK명 - 생략가능
 */
