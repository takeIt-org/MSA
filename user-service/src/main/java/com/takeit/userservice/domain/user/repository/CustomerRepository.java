package com.takeit.userservice.domain.user.repository;

import com.takeit.userservice.domain.user.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
