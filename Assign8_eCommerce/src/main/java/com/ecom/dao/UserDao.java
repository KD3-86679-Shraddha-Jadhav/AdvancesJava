package com.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entitties.UserEntity;

public interface UserDao extends JpaRepository<UserEntity,Long> {

}
