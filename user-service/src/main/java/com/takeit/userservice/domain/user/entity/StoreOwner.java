package com.takeit.userservice.domain.user.entity;


import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "store_owner")
@Entity
public class StoreOwner extends User {
    private String businessNumber;

    public StoreOwner(String email, String password, String name, String phoneNumber, String businessNumber) {
        super(email, password, name, phoneNumber);
        this.businessNumber = businessNumber;
    }
}
