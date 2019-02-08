package creatorpark.sample.jpa.app.entity.asociations.one2one.bi.fk;

/*
 *  양방향은 Target Entity에서 Source Entity(FK를 owning)로 접근하겠다는 것이다.
 *  
 *  Source Entity PK가 Target Entity의 FK로 참조 되는 경우
 *  
 *  Source Entity 설정
 *  @OneToOne(cascade= CascadeType.ALL) // 1:1 관계예서는 기본적으로 FetchType.EAGER로 읽어들인다. http://kwonnam.pe.kr/wiki/java/jpa/one-to-one 
 *  
 *  Target Entity 설정
 *  @OneToOne(mappedBy="address")
 */
