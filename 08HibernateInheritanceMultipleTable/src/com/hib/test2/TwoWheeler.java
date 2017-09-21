package com.hib.test2;

import javax.persistence.Entity;


@Entity
public class TwoWheeler extends Vehicle {
	
	String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}

	
	
}
