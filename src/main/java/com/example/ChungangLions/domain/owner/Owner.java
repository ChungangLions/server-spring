package com.example.ChungangLions.domain.owner;

import com.example.ChungangLions.domain.owner.dto.request.OwnerRequestDto;
import com.example.ChungangLions.domain.user.User;
import com.example.ChungangLions.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Builder
public class Owner extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 대표사진(최대 1장)
    private String photo;

    // 업종
    @Enumerated(EnumType.STRING)
    private Type type;

    // 주소
    private String location;

    // 한줄소개
    private String comment;

    // 연락처
    private String contact;

    // 영업일
    private List<BusinessDay> businessDay;

    // 제휴 유형
    @Enumerated(EnumType.STRING)
    private PartnershipType partnershipType;

    // 제휴 조건
    private String partnershipCondition;

    // 제휴 내용
    private String partnershipContents;

    // 희망 제휴 기간
    private LocalDate partnershipStartDate;
    private LocalDate partnershipEndDate;

    public void update(OwnerRequestDto dto) {
        if (dto.getPhoto() != null) this.photo = dto.getPhoto();
        if (dto.getType() != null) this.type = dto.getType();
        if (dto.getLocation() != null) this.location = dto.getLocation();
        if (dto.getComment() != null) this.comment = dto.getComment();
        if (dto.getContact() != null) this.contact = dto.getContact();
        if (dto.getBusinessDay() != null) this.businessDay = dto.getBusinessDay();
        if (dto.getPartnershipType() != null) this.partnershipType = dto.getPartnershipType();
        if (dto.getPartnershipCondition() != null) this.partnershipCondition = dto.getPartnershipCondition();
        if (dto.getPartnershipContents() != null) this.partnershipContents = dto.getPartnershipContents();
        if (dto.getPartnershipStartDate() != null) this.partnershipStartDate = dto.getPartnershipStartDate();
        if (dto.getPartnershipEndDate() != null) this.partnershipEndDate = dto.getPartnershipEndDate();
    }
}