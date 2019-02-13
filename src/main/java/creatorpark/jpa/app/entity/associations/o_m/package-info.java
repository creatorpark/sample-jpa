package creatorpark.jpa.app.entity.associations.o_m;

/* 
 * @OneToMany 관계에서
 * 
 * Source Entity (owning : FK를 소유하는(own))
 * - @JoinColumn( name=FK 칼럼을 적는다.)
 * - FK필드를 소유하고 관리하는 주체를 말한다.
 * 
 * Target Entity (non-owning)
 * - mappedBy 속성을 적는다.
 * - FK를 변경하지 못하고 읽기만 가능하다.
 * 
 */

/*  
 *  단방향 @OneToMany는 성능 이슈 때문에 양방향 @OneToMany만 사용하는게 좋다.
 *  (참고 : https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/ )
 *
 *  이 샘플은 단방향 @OneToMany연관의 성능저하(INSERT,INSERT,UPDATE문발생)가 일어나는 
 *  것을 설펴보는 용도이지 사용하기 위한 샘플은 아니다.
 *
 *  Source Entity 설정
 *  @OneToMany(cascade=CascadeType.ALL) 
 *  
 *  http://ojc.asia/bbs/board.php?bo_table=LecJpa&wr_id=205
 */
