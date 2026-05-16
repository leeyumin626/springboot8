package net.likelion.backend.domain.pin.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.likelion.backend.domain.memo.entity.Memo;
import net.likelion.backend.domain.memo.repository.MemoryMemoRepository;
import net.likelion.backend.domain.pin.dto.PinRequestDto;
import net.likelion.backend.domain.pin.dto.PinResponseDto;
import net.likelion.backend.domain.pin.entity.Pin;
import net.likelion.backend.domain.pin.repository.MemoryPinRepository;

// 핀 서비스 구현체: 실제 비즈니스 로직 처리
@Service  // Spring이 서비스 빈으로 인식
@RequiredArgsConstructor  // final 필드를 주입받는 생성자 자동 생성
public class PinServiceImpl implements PinService {

	private final MemoryPinRepository pinRepository;   // 핀 저장소
	private final MemoryMemoRepository memoRepository; // 메모 내용 조회용

	// 고정된 핀 전체를 조회하고, 각 핀에 해당하는 메모 내용을 함께 반환
	@Override
	public List<PinResponseDto> getAll() {
		return pinRepository.findAll()
			.stream()
			.map(pin -> {
				// 핀에 연결된 메모 내용 조회 (메모가 삭제된 경우 대비)
				String content = memoRepository.findById(pin.getMemoId())
					.map(Memo::getContent)
					.orElse("(삭제된 메모)");
				return new PinResponseDto(pin.getId(), pin.getMemoId(), content);
			})
			.collect(Collectors.toList());
	}

	// 메모 ID로 메모를 찾아 핀으로 등록
	@Override
	public PinResponseDto create(PinRequestDto request) {
		// 존재하지 않는 메모 ID면 예외 발생
		Memo memo = memoRepository.findById(request.getMemoId())
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메모입니다."));

		Long id = pinRepository.generateId();  // 새 핀 ID 발급
		Pin pin = new Pin(id, memo.getId());   // 핀 객체 생성
		pinRepository.save(pin);               // 메모리에 저장

		return new PinResponseDto(pin.getId(), pin.getMemoId(), memo.getContent());
	}
}
