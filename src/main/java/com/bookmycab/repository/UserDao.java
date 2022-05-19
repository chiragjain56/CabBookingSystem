package com.bookmycab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmycab.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
