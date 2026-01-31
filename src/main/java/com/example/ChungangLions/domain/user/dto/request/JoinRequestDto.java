package com.example.ChungangLions.domain.user.dto.request;

import com.example.ChungangLions.domain.user.RoleType;
import com.example.ChungangLions.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinRequestDto {
    private String logInId;
    private String passWord;
    private String university;
    private RoleType role;

    // DTO를 엔티티로 변환하는 메서드
    public User toEntity(String encodedPassword) {
        return User.builder()
                .logInId(this.logInId)
                .passWord(encodedPassword) // 암호화된 비밀번호를 주입
                .university(this.university)
                .role(this.role)
                .build();
    }
}