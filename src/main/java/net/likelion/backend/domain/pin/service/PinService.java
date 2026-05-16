package net.likelion.backend.domain.pin.service;

import java.util.List;

import net.likelion.backend.domain.pin.dto.PinRequestDto;
import net.likelion.backend.domain.pin.dto.PinResponseDto;

public interface PinService {

	List<PinResponseDto> getAll();

	PinResponseDto create(PinRequestDto request);
}
