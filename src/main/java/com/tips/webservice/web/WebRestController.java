package com.tips.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tips.webservice.domain.posts.PostsRepository;

import lombok.AllArgsConstructor;

@RestController //@ResponseBody를 모든 메소드에 적용
@AllArgsConstructor //모든 필드를 인자값으로하는 생성자 생성
public class WebRestController {
	
	private PostsRepository postsRepository; //생성자를 통해 빈 객체 주입
	
	/*
	 * 생성자를 Lombok 어노테이션을 통해 생성한 이유
	 * 해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속 수정해야 하는 번거로움을 해결함
	 */

	/**
	 * 간단한 Rest API를 호출
	 */
	@GetMapping("/hello")
	public String hello() { //즉 이 메소드의 결과인 HelloWorld 문자열을 JSON 형태로 반환한다.
		return "HelloWorld";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsRepository.save(dto.toEntity());
	}
}
