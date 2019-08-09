package com.tips.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ibatis/Mybatis 등에서는 DAO라는 DB Layer 접근자가 있다면
 * JPA에서는 Repository라고 부르며 인터페이스로 생성한다.
 *  
 * JpaRepository<Entity클래스, PK타입>을 상속하면 기본적인 CRUD 메소드가 자동 생성된다.
 * 즉 @Repository 를 추가할 필요가 없다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
