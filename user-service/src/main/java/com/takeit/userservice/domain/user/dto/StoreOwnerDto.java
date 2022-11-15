package com.takeit.userservice.domain.user.dto;

import com.takeit.userservice.domain.user.entity.StoreOwner;
import lombok.Getter;

@Getter
public class StoreOwnerDto extends UserDto {
    private String businessNumber;

    public StoreOwnerDto(Long id, String email, String password, String name, String phoneNumber, String dtype,
                         String businessNumber) {
        super(id, email, password, name, phoneNumber, dtype);
        this.businessNumber = businessNumber;
    }

    public StoreOwnerDto(StoreOwner storeOwner) {
        super(storeOwner.getId(), storeOwner.getEmail(), storeOwner.getPassword(), storeOwner.getName(),
                storeOwner.getPhoneNumber(),
                storeOwner.getDtype());
        this.businessNumber = storeOwner.getBusinessNumber();
    }
}
