package com.aston.group24.people;

import java.math.BigDecimal;
import com.aston.group24.vehicles.Sedan;

/**
 * SedanDriver.java
 * Model of a sedan driver
 * @author James Shorthouse
 * @version 0.1
 */
public class SedanDriver extends Person{
	
	/**
	 * Constructor
	 * @param seed Seed used for random generation
	 */
	public SedanDriver(long seed) 
	{
		super(seed);
		vehicle = new Sedan(seed);
		shopTime = rnd.nextInt(19) + 12;	//2-5 minutes (12-30 ticks)
		spendingMoney = new BigDecimal((rnd.nextInt(801) + 800) / 100.00);	//(£8-£16)
		 
	}
	
	/**
	 * Returns whether the person wants to visit the shop at the current point in the simulation
	 * @return true if the person wants to visit the shop
	 */
	@Override
	public boolean wantsToShop() 
	{
		//Probability of 0.4 if the refill is done in <10 minutes (60 ticks)
		if(timeAtStation < 60 && rnd.nextInt(10) < 4) return true;
		return false;
	}

}
