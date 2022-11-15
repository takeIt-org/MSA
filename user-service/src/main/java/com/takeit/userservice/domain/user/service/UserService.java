package com.takeit.userservice.domain.user.service;

import com.takeit.userservice.domain.user.dto.CustomerDto;
import com.takeit.userservice.domain.user.entity.Customer;
import com.takeit.userservice.domain.user.exception.NotExistUserException;
import com.takeit.userservice.domain.user.repository.CustomerRepository;
import com.takeit.userservice.domain.user.repository.StoreOwnerRepository;
import com.takeit.userservice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserService {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final StoreOwnerRepository storeOwnerRepository;

    public CustomerDto findCustomerByUserId(Long userId) {
        Customer customer = customerRepository.findById(userId)
                .orElseThrow(() -> new NotExistUserException("존재하지 않는 고객입니다."));
        return new CustomerDto(customer);
    }
}
