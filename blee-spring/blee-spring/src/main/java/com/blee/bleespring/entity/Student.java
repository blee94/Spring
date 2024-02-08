package com.blee.bleespring.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Entity // 데이터베이스의 필드와 변수의 연관관계가 정의된 친구, db 테이블에 대응되는 하나의 클래스
        // class Student {} 와 같은 빈 생성자가 필수로 필요!
@NoArgsConstructor
@Getter
@Builder // 필드가 전체 다 들어있는 생성자가 필수로 필요!
@AllArgsConstructor
public class Student {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int id;
    // id int primary key auto_increment
    // SEQUENCE : 새로운 오브젝트를 만들어서 id를 부여하는 방법 ( mysql x )
    // TABLE : SEQUENCE 전략을 흉내낸 전략 -> 모든 DBMS 에서 사용 가능
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    // name varchar(20) not null,
    @Column(columnDefinition = "TEXT")
    private String nickname;

    // enum
//    @Enumerated(EnumType.STRING)
//    private LoginType type;
    public enum LoginType {
        GOOGLE, KAKAO
    }
}