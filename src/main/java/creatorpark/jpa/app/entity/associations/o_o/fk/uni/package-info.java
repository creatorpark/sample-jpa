package creatorpark.jpa.app.entity.associations.o_o.fk.uni;

/* 
 * @OneToOne 관계에서
 * Source Entity (Own : FK를 소유하는(own))
 * Target Entity (Non-Own)
 * 
 * 
 * @OneToOne UniDirection FK 설정 
 * - Source Entity에 다음을 추가한다.
 * - @OneToOne( cascade=CascadeType.ALL)
 * - @JoinColumn(name = "ADDRESS_ID")    // Own에서 매핑되는 FK명 - 생략가능
 */
