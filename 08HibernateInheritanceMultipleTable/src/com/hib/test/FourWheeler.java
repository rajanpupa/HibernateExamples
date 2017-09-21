package com.hib.test;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {
	
	String SteeringWheel;

	public String getSteeringWheel() {
		return SteeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		SteeringWheel = steeringWheel;
	}
	
	
}
