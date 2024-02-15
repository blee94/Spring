package lecture.springbootsecurity.config;

// Spring Security dependencies 를 추가했기 때문에 해당 페이지를 추가해줌.
import lecture.springbootsecurity.security.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // 스프링 설정 클래스다 를 나타내는 annotation
@EnableWebSecurity // Spring security 를 사용한다는 annotation
public class WebSecurityConfig {

@Autowired
    JwtAuthFilter jwtAuthFilter;
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean // 스프링 컨테이너에서 관리 할 수 있게 해줌
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{ // 3.0 버전으로 사용해야함. 이전버전은 사용 x
        // 스프링 시큐리티 적용하면 기본적으로 모든 경로에 인증이 있어야 접근 가능함.
        // 특정 경로에소 인증 없이 접글 할 수 있도록 아래와 같이 설정.
        http
                .cors(Customizer.withDefaults()) // react 에서 요청 시 cors 문제 처리
                .csrf(CsrfConfigurer::disable) // post, put 요청을 허용함
                .sessionManagement(sessionM -> sessionM
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // default: IF_REQUIRED
                )
                .authorizeHttpRequests(authorize->authorize
                .requestMatchers("/auth/**")  // **: /auth/모든 url
                .permitAll() // 을 허용 하겠다.
                .anyRequest() // 그 외의 경로는
                .authenticated()); // 허용하지 않겠다.
        // permitAll(): 권한 없이 접속 가능하다.
        // authenticated(): 인증이(로그인이) 필요하다.
        // .anyRequest().authenticated(): 위에 작성한 주소를 제외 한 모든 나머지 주소는 로그인이 필요하다.
        // hasRole("권한"): 특정 권한이 있어야 접속 가능.

        // CustomAutoFilter.java 에서 만들어둔 custom 필터 등록.

        http.addFilterAfter(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration config = new CorsConfiguration();
//
//        // cors 설정
//        config.setAllowCredentials(true); // 실제 응답을 보낼 때, 브라우저에게 자격 증명과 함께 요청을 보낼 수 있도록 허용합니다.
//        config.setAllowedOriginPatterns(Arrays.asList("*")); // 모든 원본에서의 요청을 허용합니다.
//        config.setAllowedMethods(Arrays.asList("HEAD","POST","GET","DELETE","PUT", "PATCH")); // 허용할 HTTP 메서드를 설정합니다.
//        config.setAllowedHeaders(Arrays.asList("*")); // 모든 헤더의 요청을 허용합니다.
//
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config); // 모든 경로에 대해 위에서 설정한 CORS 설정을 적용합니다.
//
//        return source;
//    };

}
