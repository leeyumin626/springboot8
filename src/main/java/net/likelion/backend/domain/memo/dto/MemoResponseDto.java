package net.likelion.backend.domain.memo.dto;

import net.likelion.backend.domain.memo.entity.Memo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoResponseDto {

	private Long id;
	private String content;

	public static MemoResponseDto from(Memo memo) {
		return new MemoResponseDto(memo.getId(), memo.getContent());
	}
}
