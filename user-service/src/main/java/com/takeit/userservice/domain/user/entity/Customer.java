package com.takeit.userservice.domain.user.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "customer")
@Entity
public class Customer extends User {
    @Enumerated(EnumType.STRING)
    private OAuth2Provider provider;

    public Customer(String email, String password, String name, String phoneNumber, OAuth2Provider provider) {
        super(email, password, name, phoneNumber);
        this.dtype = Customer.class.getSimpleName();
        this.provider = provider;
    }
}
