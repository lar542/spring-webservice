package com.tips.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tips.webservice.domain.posts.PostsRepository;
import com.tips.webservice.dto.posts.PostsMainResponseDto;
import com.tips.webservice.dto.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {

	private PostsRepository postsRepository;
	
	/**
	 * 게시글 저장
	 * @param dto
	 * @return 저장한 게시글의 id
	 */
	//메소드 내에서 Exception이 발생하면 해당 메소드에서 이루어진 DB 작업을 모두 취소한다.
	//즉, 모든 처리가 정상적으로 됐을 때만 DB에 커밋하고 그렇지 않은 경우에는 커밋하지 않는다.
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		/*
		 * Controller에서 dto.toEntity()를 통해 바로 전달해도 되는 데 굳이 Service에서 dto를 받는 이유
		 * Controller와 Service의 역할을 분리하기 위함이다.
		 * 비지니스 로직과 트랜잭션 관리는 모두 Service에서 관리하고
		 * View와 연동되는 부분은 Controller에서 담당하도록 구성한다.
		 */
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	/**
	 * 람다식으로 표현한 것으로
	 * .map(PostsMainResponseDto::new)는  .map(posts -> new PostsMainResponseDto(posts))
	 * 즉, repository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsMainResponseDto로 변환하고 List로 반환한다.
	 */
	//트랜잭션 범위는 유지하되 조회 기능만 남겨두어 조회 속도가 개선된다.
	//등록, 수정, 삭제 기능이 없는 메소드에서 사용하자.
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc(){
		return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
	}
}
