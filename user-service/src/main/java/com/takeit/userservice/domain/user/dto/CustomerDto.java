package com.takeit.userservice.domain.user.dto;

import com.takeit.userservice.domain.user.entity.Customer;
import com.takeit.userservice.domain.user.entity.OAuth2Provider;
import lombok.Getter;

@Getter
public class CustomerDto extends UserDto {
    private OAuth2Provider provider;

    public CustomerDto(Customer customer) {
        super(customer);
        this.provider = customer.getProvider();
    }
}
