package com.tips.webservice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tips.webservice.domain.posts.Posts;
import com.tips.webservice.domain.posts.PostsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
	/**
	 * 이후 테스트 코드에 영향을 미치지 않기 위해
	 * 테스트 메소드가 끝날 때마다 repository 전체를 비운다.
	 */
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
//	@Test
	public void 게시글저장_불러오기() {
		//given : 테스트 기반 환경 구축 단계, @builder 사용법도 함께 확인
		postsRepository.save(Posts.builder()
				.title("테스트 게시글")
				.content("테스트 게시글")
				.author("gugu")
				.build());
		
		//when : 테스트하는 단계, Posts가 DB에 insert되는지 확인
		List<Posts> postsList = postsRepository.findAll();
		
		//then : 테스트 결과 검증 단계, 실제로 DB에 insert되었는지 확인하기 위한 조회
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("테스트 게시글"));
		assertThat(posts.getContent(), is("테스트 게시글"));
	}
	
	@Test
	public void BaseTimeEntity_등록() {
		//given
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(Posts.builder()
				.title("테스트 게시글")
				.content("테스트 본문")
				.author("gugu")
				.build());
		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertTrue(posts.getCreatedDate().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
	}
}
