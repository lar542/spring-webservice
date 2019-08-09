package com.tips.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@ResponseBody를 모든 메소드에 적용
public class WebRestController {
	
	@GetMapping("/hello")
	public String hello() { //즉 이 메소드의 결과인 HelloWorld 문자열을 JSON 형태로 반환한다.
		return "HelloWorld";
	}
}
