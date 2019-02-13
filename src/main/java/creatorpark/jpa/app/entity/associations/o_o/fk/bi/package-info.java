package creatorpark.jpa.app.entity.associations.o_o.fk.bi;

/*
 * @OneToOne 관계에서
 * Source Entity (Own : FK를 소유하는(own))
 * Target Entity (Non-Own)
 * 
 * 양방향은 Target Entity에서 Source Entity의 참조를 갖고 접근하겠다는 것이다.
 *  
 * Source Entity PK가 Target Entity의 FK로 참조 되는 경우
 *  
 * Source Entity 설정
 * @OneToOne(cascade= CascadeType.ALL) // 1:1 관계예서는 기본적으로 FetchType.EAGER로 읽어들인다. http://kwonnam.pe.kr/wiki/java/jpa/one-to-one 
 *  
 * Target Entity 설정
 * @OneToOne(mappedBy="address")
 */
