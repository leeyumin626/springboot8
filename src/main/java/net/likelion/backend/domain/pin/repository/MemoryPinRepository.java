package net.likelion.backend.domain.pin.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import net.likelion.backend.domain.pin.entity.Pin;

// 인메모리 핀 저장소: DB 없이 메모리(List)에 핀을 저장
@Repository  // Spring이 저장소 빈으로 인식
public class MemoryPinRepository implements PinRepository {

	private final List<Pin> pins = new ArrayList<>();         // 핀을 담아두는 메모리 리스트
	private final AtomicLong idCounter = new AtomicLong(1);  // 스레드 안전한 ID 카운터

	// 저장된 모든 핀 반환
	@Override
	public List<Pin> findAll() {
		return pins;
	}

	// 핀을 리스트에 추가하고 반환
	@Override
	public Pin save(Pin pin) {
		pins.add(pin);
		return pin;
	}

	// 새 핀 저장 시 호출 - 현재 카운터 값을 반환하고 1 증가
	public Long generateId() {
		return idCounter.getAndIncrement();
	}
}
