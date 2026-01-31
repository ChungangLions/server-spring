package com.example.ChungangLions.domain.user.controller;

import com.example.ChungangLions.domain.user.dto.request.JoinRequestDto;
import com.example.ChungangLions.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * 회원가입 API
     */
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinRequestDto dto) {
        userService.join(dto);
        return ResponseEntity.ok("회원가입이 성공적으로 완료되었습니다.");
    }
}