package creatorpark.jpa.app.entity.associations.o_o;

/* 
 * @OneToOne 관계에서
 * 
 * 1. Source Entity (owning : FK를 칼럼에 저장해야하는 쪽 )
 * - @JoinColumn( name=FK 칼럼을 적는다.)
 * - FK필드를 저장하고 관리하는 주체를 말한다.
 * 
 * 2. Target Entity (non-owning)
 * - mappedBy 속성을 적는다.
 * - 단방향일때는 세팅하지 않는다.
 * 
 * 3. 1:1 Article
 * https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/
 * 1:1 관계에서 동일 PK를 사용하는 것은 SELECT에서 INDEX를 한쪽만 타도 되기 때문에 50%의 성능향상이 있다.
 * 
 * CASCADE
 * https://vladmihalcea.com/a-beginners-guide-to-jpa-and-hibernate-cascade-types/
 * 
 * LAZY
 * https://vladmihalcea.com/initialize-lazy-proxies-collections-jpa-hibernate/
 * 
 * 1:1 다른사람 정리
 * https://mycup.tistory.com/223?category=665711
 * 
 */
