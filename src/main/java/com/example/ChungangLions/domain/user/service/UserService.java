package com.example.ChungangLions.domain.user.service;

import com.example.ChungangLions.domain.user.User;
import com.example.ChungangLions.domain.user.dto.request.JoinRequestDto;
import com.example.ChungangLions.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * 회원가입 로직
     */
    @Transactional
    public void join(JoinRequestDto dto) {
        // 1. 아이디 중복 검사 (필요 시 UserRepository에 findByLogInId 추가)
        validateDuplicateUser(dto.getLogInId());

        // 2. 비밀번호 암호화 [cite: 2025-12-13]
        String encodedPassword = passwordEncoder.encode(dto.getPassWord());

        // 3. DTO를 엔티티로 변환하며 암호화된 비밀번호 주입
        User user = dto.toEntity(encodedPassword);

        // 4. DB 저장
        userRepository.save(user);
    }

    private void validateDuplicateUser(String logInId) {
        // 실제 구현 시에는 userRepository.findByLogInId(logInId).isPresent() 등으로 체크
        // 현재는 기본적인 흐름만 구성함
    }
}