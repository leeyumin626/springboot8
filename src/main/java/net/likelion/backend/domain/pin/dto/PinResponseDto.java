package net.likelion.backend.domain.pin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 핀 응답 시 클라이언트에게 돌려주는 데이터
@Getter
@AllArgsConstructor  // 모든 필드를 받는 생성자 자동 생성
public class PinResponseDto {

	private Long id;           // 핀 고유 ID
	private Long memoId;       // 고정된 메모의 ID
	private String memoContent; // 고정된 메모의 내용
}
