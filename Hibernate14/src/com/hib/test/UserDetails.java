package com.hib.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//fires update statement only if db record is different from updated obj
@org.hibernate.annotations.Entity(selectBeforeUpdate=true) 
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	private String userName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
