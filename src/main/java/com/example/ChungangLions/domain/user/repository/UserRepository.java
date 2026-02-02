package com.example.ChungangLions.domain.user.repository;

import com.example.ChungangLions.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogInId(String logInId); // 로그인 아이디로 유저 찾기
}