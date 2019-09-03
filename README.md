# Sample Project for Spring Data Jpa

## application.properties
[application.propertes](https://creatorpark-tech-stack.tistory.com/2?category=812808)

## Table of Contents

* Concepts


* Relation
    * [@OneToOne](#@OneToOne)
    * [@OneToMany](#@OneToMany)
    * [@OneToOne](#@OneToOne)

## Concepts
### Source/Target Entity
Source Entity (owning : FK필드를 저장)
- FK필드를 저장하고 관리하는 주체를 말한다.
- @JoinColumn(name=FK칼럼을 적는다.)
Target Entity (non-owning)
- mappedBy 속성을 적는다.
- 단방향일때는 세팅하지 않는다.

### CASCASE
[참고자료](https://vladmihalcea.com/a-beginners-guide-to-jpa-and-hibernate-cascade-types/)
  
### LAZY
[참고자료](https://vladmihalcea.com/initialize-lazy-proxies-collections-jpa-hibernate/)

## Relation
### @OneToOne


1:1 관계에서 동일 PK를 사용하는 것은 SELECT에서 INDEX를 한쪽만 타도 되기 때문에 50%의 성능향상이 있다.
[참고자료](https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/)
  
  

  
  1:1 다른사람 정리
  https://mycup.tistory.com/223?category=665711



### @OneToMany
Source Entity (owning : FK를 칼럼에 저장해야하는 쪽 )
- @JoinColumn( name=FK 칼럼을 적는다.)
- FK필드를 저장하고 관리하는 주체를 말한다.
- 항상 Many쪽이 Source Entity이다.

Target Entity (non-owning)
- mappedBy 속성을 적는다.
- 항상 One쪽이 Target Entity이다.

이슈 : 1:N 단방향의 성능 저하 현상 
- [참고자료](https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/)
