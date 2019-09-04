# Sample Project for Spring Data Jpa

## application.properties
Jpa 설정 [application.propertes](https://creatorpark-tech-stack.tistory.com/2?category=812808)

## Concepts
### Source/Target Entity
Source Entity
- owning side : FK필드를 소유,저장 및 관리하는 Entity를 말한다.
- @JoinColumn(name=FK칼럼(DB)을 적는다.)

Target Entity
- non-owning side  
Source Entity가 FK관리 주체인데, 실제 설계할 때 개념상 Target Entity가 Main Entity가 된다.  
Source Entity와 그 의미가 헤깔리므로 주의한다.

### CASCASE
[참고](https://vladmihalcea.com/a-beginners-guide-to-jpa-and-hibernate-cascade-types/)
  
### LAZY
[참고](https://vladmihalcea.com/initialize-lazy-proxies-collections-jpa-hibernate/)

## Relation

### @OneToOne
Tips
- 1:1 Relation은 Fetch.Eager를 기본 전략으로 한다. [참고](https://kwonnam.pe.kr/wiki/java/jpa/one-to-one)

- 1:1 PK는 SELECT에서 INDEX를 한쪽만 타기 때문에 50%의 성능향상이 있다.[참고](https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/)

### @OneToMany
Tips
- 항상 Many쪽이 Source Entity, One쪽이 Target Entity이다. 
- 1:N 단방향의 성능 저하 현상 
[참고](https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/)

- TODO 1:N 에서 N객체 Select Sample 만들기


### @ManyToMany
@ManyToMany 관계에서는 두 Entity의 JOIN관계를 저장하는 Join Table이 사용된다.
  
Source Entity
- @JoinTable을 적고, joinColumns에 Join Table에서 참조하는 FK를 적는다.
- 반대편 객체는 다른 곳에서 사용될 수 있기 때문에 CascadeType이 ALL이 아닌 것에 주의한다. 

```java
@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
@JoinTable(name = "post_tag_details", 
        joinColumns = @JoinColumn(name = "post_id"), 
 inverseJoinColumns = @JoinColumn(name = "tag_id"))
private Set<Tag> tags = new HashSet<>();
```

Target Entity
- mappedBy 속성을 적는다.
- 참조만 가능하다.

```java
@ManyToMany(mappedBy="tags")
private Set<Post> posts = new HashSet<>();
```

