package com.tips.webservice.web;

import com.tips.webservice.domain.posts.Posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 절대로 테이블과 매핑이 되는 Entity 클래스를 Request/Response 클래스로 사용해서는 안 된다! 
 * 서비스 클래스나 비즈니스 로직들은 Entity 클래스를 기준으로 동작하기 때문에
 * Entity 클래스가 변경되면 여러 클래스에 영향을 끼치게 된다.
 * 하지만 Request와 Response용 DTO는 View를 위한 클래스이므로 자주 변경이 필요하다.
 * View Layer와 DB Layer를 철저하게 역할 분리를 하는 게 좋다.
 * Controller에서 여러 테이블을 조인해서 결과 값을 반환해야하는 경우가 많기 때문에 
 * Entity 클래스만으로 표현하기 어려운 경우가 많다. 
 * 그러므로 Entity 클래스와 Controller에서 쓸 DTO는 분리해서 사용하자.
 */
@Getter
@Setter //@RequestBody 로 외부에서 데이터를 받는 경우에는 기본 생성자 + setter를 통해서만 값이 할당하기 때문에 setter를 허용
@NoArgsConstructor //기본 생성자
public class PostsSaveRequestDto {

	private String title;
	private String content;
	private String author;
	
	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
}
