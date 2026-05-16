package net.likelion.backend.domain.pin.service;

import java.util.List;

import net.likelion.backend.domain.pin.dto.PinRequestDto;
import net.likelion.backend.domain.pin.dto.PinResponseDto;

// 핀 서비스 인터페이스: 비즈니스 로직 추상화
public interface PinService {

	// 고정된 메모 전체 조회
	List<PinResponseDto> getAll();

	// 메모 고정 등록
	PinResponseDto create(PinRequestDto request);
}
