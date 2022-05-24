package com.bookmycab.repository;

import com.bookmycab.model.UserTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTrackerRepository extends JpaRepository<UserTracker, Integer> {
    Optional<UserTracker> findByUserId(Integer userId);
}
