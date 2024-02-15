package lecture.springbootsecurity.security;
// 1. 세션 기반 인증 방식
// - 로그인에 성공 -> session 에 userId 저장
// - 로그인 여부 판단 -> session 에 userId 가 존재하는지
// - 존재하면: logged in
// - else: not logged in
// - 로그아웃 시에 세션에서 로그인 정보 삭제 -> 서버에서 처리


// 2. JWT 토큰 기반 인증 방식
// - 로그인 성공 -> 서버에서 jwt 토큰 발급 -> 응답에 token 을 같이 보냄
// - 클라이언트는 브라우저에 token 을 저장 (보통 localStorage 에 저장)
// - 클라이언트에서 로그인이 필요한 요청을 보낼 때, token 을 header 의 Authentication 에 담아서 보냄.
// - 서버에서 요청 객체의 header 의 Auth 정보에서 token 을 가져옴 -> token 이 유효한지 검증

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component

// OncePerRequestFilter: 요청 당 한번만 실행한다.
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    TokenProvider tokenProvider;

// - 서버에서 요청 객체의 header 의 Auth 정보에서 token 을 가져옴 -> token 이 유효한지 검증
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getBearerToken(request);

            if (token != null && !token.equalsIgnoreCase("null")) {
                String userId = tokenProvider.validateAndGetUserId(token);

                // 1. 사용자 정보를 담는 공간? 토큰 생성
                Authentication authentication = new UsernamePasswordAuthenticationToken(String.valueOf(userId), null, AuthorityUtils.NO_AUTHORITIES);

                // 2. SecurityContextHolder 에 authentication 정보 set
                // SecurityContextHolder : 클라이언트의 요청 -> 응답 사이에 일시적으로 auth 정보를 저장할 수 있는 공간
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            log.error("auth error {}", e.getMessage());
        }

        filterChain.doFilter(request, response);
    }
    // 토큰을 헤더에서 가져오는 작업
    public String getBearerToken (HttpServletRequest request){
        String bearer = request.getHeader("Authorization");
        // StringUtils.hasText(params): param 이 null 인지 아닌지, 길이가 0보다 큰지 판별
        if(StringUtils.hasText(bearer) && bearer.startsWith("Bearer")){
            return bearer.substring(7);
        }

        return null;
    }
}
