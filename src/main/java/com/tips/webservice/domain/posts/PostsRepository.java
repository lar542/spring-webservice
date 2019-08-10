package com.tips.webservice.domain.posts;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * ibatis/Mybatis 등에서는 DAO라는 DB Layer 접근자가 있다면
 * JPA에서는 Repository라고 부르며 인터페이스로 생성한다.
 *  
 * JpaRepository<Entity클래스, PK타입>을 상속하면 기본적인 CRUD 메소드가 자동 생성된다.
 * 즉 @Repository 를 추가할 필요가 없다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

	//SpringDataJpa에서 제공되지 않는 메소드는 @Query를 통해 쿼리를 작성한다.
	@Query("SELECT p "
			+ "FROM Posts p "
			+ "ORDER BY p.id DESC")
	Stream<Posts> findAllDesc();
	
	/*
	 * 데이터 조회는 FK의 조인, 복잡한 조건 등으로 인해 Entity 클래스만으로 처리하기 어려워
	 * 조회용 프레임워크를 추가로 사용한다.
	 * querydsl, jooq, MyBatis 등의 프레임워크에서 하나를 선택하여 조회하고
	 * 등록, 수정, 삭제 등은 SpringDataJpa를 통해 진행한다.
	 */
}
