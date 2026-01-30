package com.example.ChungangLions.domain.user;

import com.example.ChungangLions.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK (주요키)

    @Column(nullable = false)
    private String logInId; // 아이디 (varchar, NOT NULL)

    @Column(nullable = false)
    private String passWord; // 비밀번호 (varchar, NOT NULL)

    @Column(nullable = false)
    private String university; // 학교 (varchar, NOT NULL)

    @Column(nullable = false)
    private LocalDate createdAt; // 생성일자 (Date, NOT NULL)

    @Enumerated(EnumType.STRING) // DB에 숫자가 아닌 'OWNER' 등의 문자열로 저장
    @Column(nullable = false)
    private RoleType role; // ERD: 역할 (ENUM) { OWNER, GROUP, STUDENT }

    @Builder
    public User(String logInId, String passWord, String university, RoleType role) {
        this.logInId = logInId;
        this.passWord = passWord;
        this.university = university;
        this.role = role;
        this.createdAt = LocalDate.now(); // 객체 생성 시 현재 날짜 할당
    }
    
    /* 아래와 같은 방식으로 넘겨주면 됨
    User user = User.builder()
    .logInId("lion123")
    .passWord("safePassword")
    .university("중앙대학교")
    .role(RoleType.OWNER) // Enum 활용
    .build();
    * */
}