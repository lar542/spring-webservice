package com.tips.webservice.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

/**
 * 모든 Entity 클래스의 상위 클래스
 * Entity 들의 날짜, 시간 필드를 자동으로 관리한다.
 */
@Getter
@MappedSuperclass //JPA Entity 클래스가 이 클래스를 상속할 경우 이 클래스의 필드도 컬럼으로 인식하도록 설정
@EntityListeners(AuditingEntityListener.class) //이 클래스에 Auditing 기능을 포함
public class BaseTimeEntity {

	@CreatedDate //Entity가 저장될 때 시간이 자동 저장
	private LocalDateTime createdDate;
	
	@LastModifiedDate //조회된 Entity의 값을 변경할 때 시간이 자동 저장
	private LocalDateTime modifiedDate;
}
