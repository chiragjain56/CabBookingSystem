package com.bookmycab.repository;

import com.bookmycab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
    User findByUsername(String username);
}
