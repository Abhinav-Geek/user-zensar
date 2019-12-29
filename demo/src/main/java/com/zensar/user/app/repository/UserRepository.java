package com.zensar.user.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.user.app.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
