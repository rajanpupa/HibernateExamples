package com.example.twitterservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.twitterservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
