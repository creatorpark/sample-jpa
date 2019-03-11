package creatorpark.jpa.app.entity.associations.m_n;

/* 
 * @ManyToMany 관계에서는 두 Entity의 JOIN관계를 저장하는 Join Table이 사용된다.
 * 
 * 1. Source Entity
 * - 관계를 설정하고 관리하는 주체이다.
 * - @JoinTable을 적고, joinColumns에 Join Table에서 참조하는 FK를 적는다.
 * - (cascade = { CascadeType.PERSIST, CascadeType.MERGE }) 에서 ALL이 아닌 것에 주의한다. 
 * - M : N 관계에서 삭제시에 반대편의 값도 다른 것에 의에 참조 되므로
 * 
 * 	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
 *  @JoinTable(name = "post_tag_details", 
 *		joinColumns = @JoinColumn(name = "post_id"), 
 *		inverseJoinColumns = @JoinColumn(name = "tag_id"))
 *	private Set<Tag> tags = new HashSet<>();
 * 
 * 
 * 2. Target Entity
 * - mappedBy 속성을 적는다.
 * - 참조만 가능하다.
 * 
 * 	@ManyToMany(mappedBy="tags")
 *	private Set<Post> posts = new HashSet<>();
 * 
 * 3. M:N Article
 * https://vladmihalcea.com/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/
 */
