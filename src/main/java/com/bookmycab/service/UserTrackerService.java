package com.bookmycab.service;

import com.bookmycab.exceptions.UserException;
import com.bookmycab.model.User;
import com.bookmycab.model.UserTracker;
import com.bookmycab.repository.UserDao;
import com.bookmycab.repository.UserTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserTrackerService {

    @Autowired
    UserTrackerRepository userTrackerRepository;

    @Autowired
    UserDao userRepository;

    public boolean isLoggedIn(User user) {
        Optional<UserTracker> userid = userTrackerRepository.findByUserId(user.getUserId());
        return userid.isPresent();
    }

    public boolean loginUser(User user) throws UserException {
        User userDB = userRepository.findByUsername(user.getUsername());
        if (userDB == null)
            throw new UserException("User not found");
        if (!Objects.equals(userDB.getPassword(), user.getPassword()))
            return false;

        UserTracker ut = new UserTracker();
        ut.setUserId(userDB.getUserId());
        userTrackerRepository.save(ut);
        return true;
    }

    public boolean logoutUser(User user) {
        Optional<UserTracker> ut = userTrackerRepository.findByUserId(user.getUserId());
        if (ut.isEmpty())
            return false;
        userTrackerRepository.delete(ut.get());
        return true;
    }
}
