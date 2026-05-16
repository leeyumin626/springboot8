package net.likelion.backend.domain.memo.repository;

import java.util.List;
import java.util.Optional;

import net.likelion.backend.domain.memo.entity.Memo;

public interface MemoRepository {

	List<Memo> findAll();

	Memo save(Memo memo);

	Optional<Memo> findById(Long id);
}

