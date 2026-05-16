package net.likelion.backend.domain.pin.entity;

import lombok.Getter;

// 핀 엔티티: 어떤 메모가 고정됐는지 저장하는 객체
@Getter
public class Pin {

	private final Long id;      // 핀 고유 ID
	private final Long memoId;  // 고정된 메모의 ID

	// 핀 객체 생성자
	public Pin(Long id, Long memoId) {
		this.id = id;
		this.memoId = memoId;
	}
}
