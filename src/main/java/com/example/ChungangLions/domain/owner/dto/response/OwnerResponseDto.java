package com.example.ChungangLions.domain.owner.dto.response;

import com.example.ChungangLions.domain.owner.BusinessDay;
import com.example.ChungangLions.domain.owner.Owner;
import com.example.ChungangLions.domain.owner.PartnershipType;
import com.example.ChungangLions.domain.owner.Type;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class OwnerResponseDto {
    private Long id;
    private Long userId;
    private String photo;
    private Type type;
    private String location;
    private String comment;
    private String contact;
    private List<BusinessDay> businessDay;
    private PartnershipType partnershipType;
    private String partnershipCondition;
    private String partnershipContents;
    private LocalDate partnershipStartDate;
    private LocalDate partnershipEndDate;

    public static OwnerResponseDto fromEntity(Owner owner){
        return OwnerResponseDto.builder()
                .id(owner.getId())
                .userId(owner.getUser().getId())
                .photo(owner.getPhoto())
                .

    }
}
