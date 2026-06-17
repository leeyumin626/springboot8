package net.likelion.backend.global.filter;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoggingFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal
		(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {

		String requestId = UUID.randomUUID().toString().substring(0, 8);
		MDC.put("requestId", requestId);

		String method = request.getMethod();
		String uri = request.getRequestURI();
		long startTime = System.currentTimeMillis();

		log.info("[요청] {} {}", method, uri);

		try {
			filterChain.doFilter(request, response);
		} finally {
			long duration = System.currentTimeMillis() - startTime;
			log.info("[응답] {} {} {} ({}ms)", method, uri, response.getStatus(), duration);
			MDC.clear();
		}
	}
}
