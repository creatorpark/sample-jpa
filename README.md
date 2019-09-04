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
Source Entity
- owning : FK필드를 저장하고 관리하는 주체를 말한다.
- @JoinColumn(name=FK칼럼을 적는다.)
Target Entity
- non-owning : PmappedBy 속성을 적는다.
- 단방향일때는 세팅하지 않는다.

Main Entity가 Target Entity가 되어 Source Entity에게 FK를 제공하게 된다.

### CASCASE
[참고자료](https://vladmihalcea.com/a-beginners-guide-to-jpa-and-hibernate-cascade-types/)
  
### LAZY
[참고자료](https://vladmihalcea.com/initialize-lazy-proxies-collections-jpa-hibernate/)

## Relation
### @OneToOne
1:1 관계에서 동일 PK를 사용하면 SELECT에서 INDEX를 한쪽만 타도 되기 때문에 50%의 성능향상이 있다.
[참고자료](https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/)
  
1:1 다른사람 정리
https://mycup.tistory.com/223?category=665711

### @OneToMany
Source Entity
- 항상 Many쪽이 Source Entity이다.
Target Entity
- 항상 One쪽이 Target Entity이다.

이슈 : 1:N 단방향의 성능 저하 현상 
- [참고자료](https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/)

### @ManyToMany
@ManyToMany 관계에서는 두 Entity의 JOIN관계를 저장하는 Join Table이 사용된다.
  
Source Entity
- @JoinTable을 적고, joinColumns에 Join Table에서 참조하는 FK를 적는다.
- (cascade = { CascadeType.PERSIST, CascadeType.MERGE }) 에서 M : N 관계에서 삭제시에 반대편의 값도 다른 것에 의에 참조 되므로 ALL이 아닌 것에 주의한다. 

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

```
@ManyToMany(mappedBy="tags")
private Set<Post> posts = new HashSet<>();
```

