package net.likelion.backend.domain.pin.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 핀 생성 요청 시 클라이언트에서 받는 데이터
@Getter
@NoArgsConstructor  // Jackson이 JSON을 역직렬화할 때 기본 생성자 필요
public class PinRequestDto {

	@NotNull(message = "메모 ID를 입력해주세요.")  // null이면 요청 거부
	private Long memoId;  // 고정할 메모의 ID
}
