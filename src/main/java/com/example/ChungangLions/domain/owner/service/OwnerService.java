package com.example.ChungangLions.domain.owner.service;

import com.example.ChungangLions.domain.owner.Owner;
import com.example.ChungangLions.domain.owner.dto.response.OwnerResponseDto;
import com.example.ChungangLions.domain.owner.dto.request.OwnerRequestDto;
import com.example.ChungangLions.domain.owner.repository.OwnerRepository;
import com.example.ChungangLions.domain.user.User;
import com.example.ChungangLions.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final UserRepository userRepository;

    // 프로필 생성
    @Transactional
    public OwnerResponseDto createOwner(OwnerRequestDto dto){

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        Owner owner = dto.toEntity(user);
        Owner saved = ownerRepository.save(owner); // 변환된 엔티티를 데이터베이스에 저장

        OwnerResponseDto response = OwnerResponseDto.fromEntity(saved);
        return response;
    }
}
