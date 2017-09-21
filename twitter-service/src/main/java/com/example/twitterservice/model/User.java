package com.example.twitterservice.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String passwordHash;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "user_follower", 
			joinColumns = { 
				// this is the column which identifies this object
				@JoinColumn(name = "user_id", referencedColumnName="id") 
			},
			inverseJoinColumns={
				// this is the object which identifies the object in the below collection
				@JoinColumn(name="follower_id", referencedColumnName="id")
			}
	)
	Set<User> followers;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "user_follower", 
		joinColumns = {
			@JoinColumn(name = "follower_id", referencedColumnName="id") 
		},
		inverseJoinColumns={
			@JoinColumn(name="user_id", referencedColumnName="id")
		}
	)
	Set<User> following;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Set<User> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}

	public Set<User> getFollowing() {
		return following;
	}

	public void setFollowing(Set<User> following) {
		this.following = following;
	}
	
}
