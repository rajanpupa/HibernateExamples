package com.example.twitterservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.twitterservice.model.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer>{

}
