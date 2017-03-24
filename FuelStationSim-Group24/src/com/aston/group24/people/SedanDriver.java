package com.aston.group24.people;

import java.math.BigDecimal;
import java.util.Random;

import com.aston.group24.model.Simulation;
import com.aston.group24.vehicles.Sedan;

public class SedanDriver extends Person{
	private static Random rnd = new Random(Simulation.seed);

	public SedanDriver() 
	{
		super();
		vehicle = new Sedan();
		shopTime = rnd.nextInt(19) + 12;	//2-5 minutes (12-30 ticks)
		spendingMoney = new BigDecimal((rnd.nextInt(801) + 800) / 100.00);	//(£8-£16)
		 
	}
	
	@Override
	public boolean wantsToShop() 
	{
		//Probability of 0.4 if the refill is done in <10 minutes (60 ticks)
		if(timeAtStation < 60 && rnd.nextInt(10) < 4) return true;
		return false;
	}

}