package lecture.springbootsecurity.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("jwt") // application.properties 의 jwt 관련 속성을 참고하여, 해당 클래스의 필드 값을 설정
public class JwtProperties {
    private String issuer;
    private String secretKey;

}
