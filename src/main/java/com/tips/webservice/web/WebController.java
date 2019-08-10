package com.tips.webservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tips.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {
	
	private PostsService postsService;

	/**
	 * Spring 4.3 부터 @RequestMapping 을 대체할 수 있는 여러 매핑 어노테이션이 추가되었다.
	 * @RequestMapping(value="/", method = RequestMethod.GET)가 @GetMappring 과 동일하다.
	 */
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("posts", postsService.findAllDesc());
		/*
		 * handlebars-spring-boot-starter 덕분에 문자열을 반환할 때
		 * path에 자동으로 prefix(src/main/resources/templates)와 suffix(hbs)가 붙어
		 * View Resolver가 처리하게 된다.
		 */
		return "main";
	}
}
