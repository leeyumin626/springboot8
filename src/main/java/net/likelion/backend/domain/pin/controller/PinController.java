package net.likelion.backend.domain.pin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.likelion.backend.domain.pin.dto.PinRequestDto;
import net.likelion.backend.domain.pin.dto.PinResponseDto;
import net.likelion.backend.domain.pin.service.PinService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

// 핀 관련 HTTP 요청을 처리하는 컨트롤러
@Tag(name = "Pin", description = "메모 고정 API")  // Swagger 그룹 태그
@RestController   // JSON 응답을 반환하는 REST 컨트롤러
@RequestMapping("/pins")  // 모든 엔드포인트의 기본 경로
@RequiredArgsConstructor  // final 필드 생성자 주입
public class PinController {

	private final PinService pinService;  // 비즈니스 로직 위임

	@Operation(summary = "고정된 메모 전체 조회", description = "고정된 모든 메모 목록을 반환합니다.")  // Swagger 문서에 표시될 API 설명
	@ApiResponse(responseCode = "200", description = "조회 성공")  // Swagger 문서에 표시될 응답 코드 설명
	@GetMapping  // GET /pins 요청을 이 메서드가 처리
	public ResponseEntity<List<PinResponseDto>> getAll() {  // 응답을 List로 감싸서 반환
		return ResponseEntity.ok(pinService.getAll());  // 200 OK와 함께 고정된 메모 목록 반환
	}

	@Operation(summary = "메모 고정", description = "메모를 고정합니다.")  // Swagger 문서에 표시될 API 설명
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "고정 성공"),           // Swagger 문서에 표시될 응답 코드 설명
		@ApiResponse(responseCode = "400", description = "존재하지 않는 메모 ID") // Swagger 문서에 표시될 응답 코드 설명
	})
	@PostMapping  // POST /pins 요청을 이 메서드가 처리
	public ResponseEntity<PinResponseDto> create(@RequestBody @Valid PinRequestDto request) {
		// @RequestBody: HTTP 요청 body의 JSON을 PinRequestDto로 변환
		// @Valid: PinRequestDto의 유효성 검사 실행 (memoId NotNull 체크)
		return ResponseEntity.status(HttpStatus.CREATED).body(pinService.create(request));  // 201 Created와 함께 생성된 핀 반환
	}
}
