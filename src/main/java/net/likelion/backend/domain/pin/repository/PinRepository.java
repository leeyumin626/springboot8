package net.likelion.backend.domain.pin.repository;

import java.util.List;

import net.likelion.backend.domain.pin.entity.Pin;

public interface PinRepository {

	List<Pin> findAll();

	Pin save(Pin pin);
}
