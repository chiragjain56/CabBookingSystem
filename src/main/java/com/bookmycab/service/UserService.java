package com.bookmycab.service;

import com.bookmycab.exceptions.UserException;
import com.bookmycab.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user) throws UserException;

    User updateUser(Integer id, User user) throws UserException;

    User deleteUser(Integer id) throws UserException;

    List<User> getAllUser();

    User getUserById(Integer id) throws UserException;

    User getUserByUsername(String username) throws UserException;
}
