package com.tips.webservice.dto.posts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.tips.webservice.domain.posts.Posts;

import lombok.Getter;

/**
 * DTO는 Entity를 사용해도 되지만, Entity는 DTO에 대해 전혀 모르게 코드를 구성해야 한다.
 * Entity는 가장 Core한 클래스!
 * Entity가 DTO에 의존해서는 안 되고, DTO가 Entity에 의존하도록 코드를 작성하자!
 */
@Getter
public class PostsMainResponseDto {

	private Long id;
    private String title;
    private String author;
    private String modifiedDate;
    
    public PostsMainResponseDto(Posts entity) {
    	id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
        //View 영역에서는 LocalDateTime의 타입을 모르기 때문에 문자열로 변환
    }
    
    /**
     * Java 8 버전
     */
	private String toStringDateTime(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
	}
    
    /**
     * Java 7 버전
     */
    private String toStringDateTimeByJava7(LocalDateTime localDateTime) {
    	if(localDateTime == null) {
    		return "";
    	}
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	return formatter.format(localDateTime);
    }
}
