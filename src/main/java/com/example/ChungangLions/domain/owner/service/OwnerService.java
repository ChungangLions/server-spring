package com.example.ChungangLions.domain.owner.service;

import com.example.ChungangLions.domain.owner.Owner;
import com.example.ChungangLions.domain.owner.dto.request.OwnerRequestDto;
import com.example.ChungangLions.domain.owner.repository.OwnerRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;

    // 프로필 생성
    @Transactional
    public OwnerResponseDto createOwner(OwnerRequestDto dto, Long userId){
        Owner owner = dto.toEntity();
        Owner saved = ownerRepository.save(owner);

        OwnerResponseDto response = OwnerResponseDto.fromEntity(saved);
        return response;
    }
}
