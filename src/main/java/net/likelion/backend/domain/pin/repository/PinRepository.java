package net.likelion.backend.domain.pin.repository;

import java.util.List;

import net.likelion.backend.domain.pin.entity.Pin;

// 핀 저장소 인터페이스: 구현체를 갈아끼울 수 있도록 추상화
public interface PinRepository {

	// 저장된 모든 핀 반환
	List<Pin> findAll();

	// 핀을 저장하고 저장된 핀 반환
	Pin save(Pin pin);
}
