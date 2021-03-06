//StringToFile.java
package com.aston.group24.util;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class sends a String to a text file in the local directory
 * 
 * @author HarmanU
 * @version 02.05.2017/2350
 */
public class StringToFile {
	
	/**
	 * Send String to a text file in the local directory
	 * 
	 * @param text Text to send to file
	 * @param nameOfFile Name of the file to be generated
	 * @throws IOException If it cannot write the file, throws an exception
	 */
	public static void sendToFile(String text, String nameOfFile) throws IOException
	{
		FileWriter writer = null;
		 try
		 {
			 writer = new FileWriter(nameOfFile + ".txt");
			 writer.write(text);
		 } 
		 finally 
		 {
			 try {
				 if (writer != null) writer.close();
			 }
			 catch (Exception e) 
			 {
				 System.out.print("Could not print file");
			 }
		 }
	}
	
	public static void sendToFileCSV(String text, String nameOfFile) throws IOException
	{
		FileWriter writer = null;
		 try
		 {
			 writer = new FileWriter(nameOfFile + ".csv");
			 writer.write(text);
		 } 
		 finally 
		 {
			 try {
				 if (writer != null) writer.close();
			 }
			 catch (Exception e) 
			 {
				 System.out.print("Could not print file");
			 }
		 }
	}

}
