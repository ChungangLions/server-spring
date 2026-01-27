package com.example.ChungangLions.domain.owner.dto.request;

import com.example.ChungangLions.domain.owner.BusinessDay;
import com.example.ChungangLions.domain.owner.Owner;
import com.example.ChungangLions.domain.owner.PartnershipType;
import com.example.ChungangLions.domain.owner.Type;
import com.example.ChungangLions.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class OwnerRequestDto {
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

    public Owner toEntity(User user){
        return Owner.builder()
                .user(user)
                .photo(this.photo)
                .type(this.type)
                .location(this.location)
                .comment(this.comment)
                .contact(this.contact)
                .businessDay(this.businessDay)
                .partnershipType(this.partnershipType)
                .partnershipCondition(this.partnershipCondition)
                .partnershipContents(this.partnershipContents)
                .partnershipStartDate(this.partnershipStartDate)
                .partnershipEndDate(this.partnershipEndDate)
                .build();
    }
}
