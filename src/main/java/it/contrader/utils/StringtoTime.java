package it.contrader.utils;

import java.sql.Time;
import java.text.SimpleDateFormat;

public class StringtoTime {
	
	public static Time convert(String s) {
		try {		  
		    SimpleDateFormat format = new SimpleDateFormat("HH:mm"); // 12 hour format
		    java.util.Date d1 =(java.util.Date)format.parse(s);
		    java.sql.Time ppstime = new java.sql.Time(d1.getTime());
		  return ppstime;
		} catch(Exception e) {
		    System.out.println("Exception Strint to time "+ e.toString());
		}
		return null;
	
	}
}
