package creatorpark.jpa.app.entity.associations.o_m.uni;

/*  
 *  단방향 @OneToMany은 성능 이슈 때문에 양방향 @OneToMany만 사용하는게 좋다.
 *  (참고 : https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/ )
 *
 *  이 샘플은 단방향 @OneToMany연관의 성능저하(INSERT,INSERT,UPDATE문발생)가 일어나는 걸 확인하는 용도이다.
 *  사용하는 용도는 아니다.
 *
 *  Source Entity 설정
 *  @OneToMany(cascade=CascadeType.ALL) 
 *  
 *  
 *  
 *  http://ojc.asia/bbs/board.php?bo_table=LecJpa&wr_id=205
 */
