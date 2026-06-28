package com.musicdna.discovery_engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.musicdna.discovery_engine.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
