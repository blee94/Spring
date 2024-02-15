package lecture.springbootsecurity.security;
// 1. 세션 기반 인증 방식
 // - 로그인에 성공 -> session 에 userId 저장
 // - 로그인 여부 판단 -> session 에 userId 가 존재하는지
 // - 존재하면: logged in
 // - else: not logged in
 // - 로그아웃 시에 세션에서 로그인 정보 삭제 -> 서버에서 처리

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class CustomAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            log.warn("session {}" , session.getId());
            Object userId = session.getAttribute("userId");

            if(userId != null){
                // 1.  사용자 정보를 담는 토큰 생성
                Authentication authentication = new UsernamePasswordAuthenticationToken(String.valueOf(userId), null, AuthorityUtils.NO_AUTHORITIES);
                // 2. SecurityContextHolder 에 authentication 정보를 set
                //   -> 클라이언트릐 요청 => 응답 사이에 일시적으로 auth 정보를 저장할 수 있는 공간.
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e){
            log.error("filter error {}", e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
