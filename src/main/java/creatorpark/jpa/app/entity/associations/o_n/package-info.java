package creatorpark.jpa.app.entity.associations.o_n;

/* 
 * @OneToMany 관계에서
 * 
 * Source Entity (owning : FK를 소유하는(own))
 * - @JoinColumn( name=FK 칼럼을 적는다.)
 * - FK필드를 소유하고 관리하는 주체를 말한다.
 * - 항상 Many쪽이 Source Entity이다.
 * 
 * Target Entity (non-owning)
 * - mappedBy 속성을 적는다.
 * - FK를 변경하지 못하고 읽기만 가능하다.
 * - 항상 One쪽이 Target Entity이다.
 * 
 * 단방향 1:N관계는 성능 이슈 때문에 주로 Bi Direction만 사용된다.
 * https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
 */
