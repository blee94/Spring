package lecture.springbootsecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
// @Builder annotation 추가 시 @NoArgsConstructor, @AllArgsConstructor 추가
@Getter
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement 설정
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "username", length = 20, nullable = false)
    private String username;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 255, nullable = false) // length default=250
    private String password;
}
