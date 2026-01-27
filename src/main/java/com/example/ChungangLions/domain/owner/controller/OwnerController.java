package com.example.ChungangLions.domain.owner.controller;

import com.example.ChungangLions.domain.owner.dto.request.OwnerRequestDto;
import com.example.ChungangLions.domain.owner.dto.response.OwnerResponseDto;
import com.example.ChungangLions.domain.owner.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    // 프로필 생성
    @PostMapping
    public ResponseEntity<OwnerResponseDto> createOwner(@RequestBody OwnerRequestDto requestDto) {
        OwnerResponseDto response = ownerService.createOwner(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

