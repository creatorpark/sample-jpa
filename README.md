# Sample Project for Spring Data Jpa

## application.properties
[참고](https://creatorpark-tech-stack.tistory.com/2?category=812808)

## Concepts
### Source/Target Entity
![Source,Target Entity](./docs/images/sourcetarge.png)  
Source Entity
- (FK) owning side (Child)  
- FK필드를 소유,저장 및 관리하는 Entity를 말한다.  
- @JoinColumn(name=FK(DB의칼럼명)를 적는다.)

```java
	@JoinColumn(name="team_bi_id")
	@ManyToOne()
	private TeamBi team = new TeamBi();
```

Target Entity  
- (FK) non-owning side (Parent)  
- Target Entity는 Parent(Root,Main) Entity이다.
- Source Entity는 FK의 관리 주체를 말하는 것이지, Parent(Main) Entity가 아니다. 헤깔릴 수 있다.    
- mappedBy(상대편(Source Entity에 있는 자기의 필드명, 예제에서는 team) 속성을 적는다.
  
```java
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="team")
	private List<PlayerBi> players = new ArrayList<PlayerBi>();
```

### CASCASE
[참고](https://vladmihalcea.com/a-beginners-guide-to-jpa-and-hibernate-cascade-types/)
  
### LAZY
[참고](https://vladmihalcea.com/initialize-lazy-proxies-collections-jpa-hibernate/)

## Relation

### @OneToOne
- Fetch.Eager를 기본 전략으로 한다.[참고](https://kwonnam.pe.kr/wiki/java/jpa/one-to-one)  
- 1:1 PK는 SELECT에서 INDEX를 한쪽만 타기 때문에 1:1 FK보다 50% 성능이 좋다.[참고](https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/)
- 1:1 에서는 INNER JOIN 과 LEFT JOIN 되고 안되고 차이를 분석하는게 이슈[참고](https://chanlee.wordpress.com/2012/07/04/jpa-%EC%A1%B0%EC%9D%B8%ED%8C%81-inner-or-outer-join/)

### @OneToMany
- Fetch.Lazy를 기본 전략으로 한다.  
- 항상 One쪽이 Target Entity (Parent) Many쪽이 Source Entity(Child) 이다. 
- 1:N 단방향의 성능 저하 현상 
[참고](https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/)
- JPA 1:N JOIN은 Query를 직접  작성하는 것만큼 쉽지 않다. 
 [참고](https://stackoverflow.com/questions/12465260/jpa-hibernate-inner-join-between-parent-and-child-tables)

### @ManyToOne
- Fetch.Eager를 기본 전략으로 한다.  

### @ManyToMany
- Fetch.Lazy를 기본 전략으로 한다.
- @ManyToMany 관계에서는 두 Entity의 JOIN관계를 저장하는 Join Table이 사용된다.  
  
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

### Entity Graph
https://blog.leocat.kr/notes/2019/05/26/spring-data-using-entitygraph-to-customize-fetch-graph


