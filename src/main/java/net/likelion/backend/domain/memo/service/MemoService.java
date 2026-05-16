package net.likelion.backend.domain.memo.service;

import java.util.List;

import net.likelion.backend.domain.memo.dto.MemoRequestDto;
import net.likelion.backend.domain.memo.dto.MemoResponseDto;

public interface MemoService {

	List<MemoResponseDto> getAll();

	MemoResponseDto create(MemoRequestDto request);
}
