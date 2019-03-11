package creatorpark.jpa.app.entity.associations.o_n;

/* 
 * @OneToMany 관계에서
 * 
 * 1. Source Entity (owning : FK를 칼럼에 저장해야하는 쪽 )
 * - @JoinColumn( name=FK 칼럼을 적는다.)
 * - FK필드를 저장하고 관리하는 주체를 말한다.
 * - 항상 Many쪽이 Source Entity이다.
 * 
 * 2. Target Entity (non-owning)
 * - mappedBy 속성을 적는다.
 * - 항상 One쪽이 Target Entity이다.
 * 
 * 3. 1:N 단방향의 성능 저하 현상
 * https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
 * 이 소스에서 단방향 @OneToMany연관은 
 * 성능저하(INSERT,INSERT,UPDATE문발생)가 발생하는 것을 학습하려는 목적이다.
 * 사용하기 위한 샘플은 아니다.
 */
