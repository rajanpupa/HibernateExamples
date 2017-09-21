package com.example.twitterservice.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tweet")
public class Tweet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	@Temporal(TemporalType.DATE)
	Date createdTime;
	
	@Column(length=140)
	String text;
	
	@OneToOne(fetch=FetchType.LAZY)
	User user;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="tweet_like",
			joinColumns={
				@JoinColumn(name="tweet_id", referencedColumnName="id", nullable=false)
			},
			inverseJoinColumns={
				@JoinColumn(name="user_id", referencedColumnName="id", nullable=false)
			}
	)
	Set<User> likeUsers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
