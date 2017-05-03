package com.aston.group24.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.aston.group24.people.Person;

/**
 * Shop
 * 
 * Will contain and manage tills and shop floor.
 * 
 * @author JTurner
 * 
 */

public class Shop{

	private HashMap<Person, Integer> shopTime; //HashMap for storing and managing the time spent on the shop floor.
	private HashMap<Person, Integer> tillTime; //HashMap for storing and managing the time spent paying at the till.
	private ArrayList<Person> shopFloor; //Array for storing people currently on the shop floor.
	private ArrayList<Till> tills; //Array for storing tills.

public Shop(int numTills)
  {	
	shopTime = new HashMap<Person, Integer>();
	tillTime = new HashMap<Person, Integer>();
	shopFloor = new ArrayList<Person>();
    	tills = new ArrayList<Till>();
 
    createTills(numTills);
  }
  
  /**
   * Create X number of tills in the shop
   */
  protected void createTills(int amountOfTills)
  {
      for(int i = 0; i < amountOfTills; i++)
      {
          tills.add(new Till());
      }
  }
 
  /**
   * Add specified person p to shop floor
   */
  protected void addPersonToFloor(Person p)
  {		   	
	  shopFloor.add(p);
	  //Add person p to shopTime HashMap and set time to 0
	  shopTime.put(p, 0);
  }
  
  /**
   * Add person p to till with shortest queue
   */
  protected boolean addPersonToTills(Person p)
  {		
	  Till validTill = tillWithShortesQueue();
	
	  if(validTill != null)
	  {
		  tillWithShortesQueue().addPerson(p);
		  //Add person p to tillTime HashMap and set time to 0
		  tillTime.put(p, 0);
		  return true;
	  }
	  else 
	  {
		  return false;
	  } 
  }
  
  /**
   * Remove person from till
   */
  protected void removePersonFromTills(Person p)
  {
	  for(int i = 0; i < tills.size(); i++)
	  {
		  if(tills.get(i).containsPerson(p))
		  {
			  tills.get(i).removePerson(p);
		  }  
	  }
  }
  
  /**
   * Remove person from shopFloor
   */
  protected void removePersonBrowsing(Person p)
  {
	  shopFloor.remove(p);  
  }
  
  /**
   * Return ArrayList of people who have finished browsing
   */
  protected ArrayList<Person> getFinishedBrowsing()
  {
	 ArrayList<Person> finishedBrowsing = new ArrayList<Person>();

	 for(int i = 0; i < shopFloor.size(); i++)
	 { 
		 if(shopFloor.get(i).getShopTime() == shopTime.get(shopFloor.get(i)))
		 {		 	 
			 finishedBrowsing.add(shopFloor.get(i));
		 }
	 }
	 return finishedBrowsing;
  } 
  
  /**
   * Return ArrayList of people who have finished paying
   */
  protected ArrayList<Person> getFinishedPaying()
  {
	ArrayList<Person> finishedPaying = new ArrayList<Person>();
	  
	for(int i = 0; i < tills.size(); i++)
	{
	
	  if(tills.get(i).queueLength() > 0)
	  {
		  if(tills.get(i).getFirstInQueue().getTillTime() == tillTime.get(tills.get(i).getFirstInQueue()))
		  {
			  finishedPaying.add(tills.get(i).getFirstInQueue());
		  }
	  }
	}
	return finishedPaying;
  }
 
  /**
   * Sort tills in descending order
   */
  protected Till tillWithShortesQueue()
  {  
	 //ArryList to store sorted tills 
	 ArrayList<Integer> sortedTills = new ArrayList<Integer>();
	 
	 for(Till t : tills)
	 {
		sortedTills.add(t.queueLength());
	 }
	 
	 Collections.sort(sortedTills);//Sort values
	 
	 System.out.println("Shortest length:" + sortedTills.get(0));
	  
	 for(Till t : tills)
		 if(t.queueLength() == sortedTills.get(0))
		 {
			 return t;
		 }
	return null;

  }
  
  public void simulate()
  {
	  System.out.println("People on shop floor: " + shopFloor.size());
	  
	  for(int i = 0; i<tills.size(); i++){
		  System.out.print("Till " + (i + 1) + ": " + tills.get(i).queueLength() + "\t\t");
		  for(int x = 0 ; x < tills.get(i).queueLength(); x++){
			  System.out.print("▓");
		  }
		  System.out.println();
	  }
	  
	  for(Person p : shopFloor)
	  {
		  shopTime.put(p, shopTime.get(p) + 1);
	  }
	  
	  for(Till t : tills)
	  {
		  if(t.queueLength() > 0)
		  {
			  tillTime.put(t.getFirstInQueue(), tillTime.get(t.getFirstInQueue()) + 1);
		  }
	  }
  }
 
}
