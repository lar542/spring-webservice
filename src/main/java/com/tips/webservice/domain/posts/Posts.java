package com.tips.webservice.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.tips.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//기본 생성자 자동 추가 : 기본 생성자의 접근 권한을 protected로 제한
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity {

	@Id
	@GeneratedValue //pk를 정수형 자동증가하는 기본값 AUTO
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false) //타입을 TEXT로 변경
	private String content;
	
	private String author;
	
	//생성자에 포함된 빌드만 빌더에 포함하여 빌더패턴 클래스 생성 
	//빌더를 통해 필드 값을 채우면 어떤 값을 채워야 할지 명확히 인지할 수 있다.
	@Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
	
	/*
	 * getter/setter를 무작정 생성하지 않는다. 클래스의 인스턴스 값들이 언제 어디서 변해야하는 지 코드 상 알 수 없기 때문
	 * 필드 값 변경이 필요하면 명확히 목적과 의도를 나타낼 수 있는 메소드를 추가해야 한다.
	 * 
	 * 생성자와 빌더는 생성시점에 값을 채워주는 역할은 똑같으나 
	 * 생성자의 경우 채워야할 필드가 무엇인지 명확히 지정할 수 없다.
	 */
}
