package com.hib.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	// mappedBy causes addition of one extra field in the vehicle table to map to user
	// SHOULD provide @JoinColumn(name="USER_ID") in vehicle object
	@OneToMany(mappedBy="user") 
	private Set<Vehicle> vehicle = new HashSet<Vehicle>();
	
	
	public Set<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Set<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
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
