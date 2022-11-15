package com.takeit.userservice.domain.user.repository;

import com.takeit.userservice.domain.user.entity.StoreOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreOwnerRepository extends JpaRepository<StoreOwner, Long> {
}
