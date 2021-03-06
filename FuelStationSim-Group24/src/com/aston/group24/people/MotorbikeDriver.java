//MotorbikeDriver.java
package com.aston.group24.people;

import java.math.BigDecimal;
import com.aston.group24.vehicles.Motorbike;

/**
 * Model of a motorbike driver
 * @author JShorthouse
 * @version 20.04.2017/2055
 */
public class MotorbikeDriver extends Person{

	/**
	 * Constructor
	 * @param seed Seed used for random generation
	 */
	public MotorbikeDriver(long seed)
	{
		super(seed);
		vehicle = new Motorbike(seed);
		shopTime = 0; 						//Motorbike drivers never visit the shop
		spendingMoney = new BigDecimal(0); 	//Motorbike drivers never visit the shop
	}

	/**
	 * Returns whether the person wants to visit the shop at the current point in the simulation
	 * Motorbike drivers never visit so will always return false
	 * @return false
	 */
	@Override
	public boolean wantsToShop()
	{
		//Always false
		return false;
	}
}
