package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {
	
	private static Date Date(int year, int month, int day) {
		// TODO Auto-generated method stub
		Calendar date = Calendar.getInstance();
		date.set(year, month - 1, day);
		return date.getTime();
	}
	private static ArrayList<Staff> staff = new ArrayList<Staff>();
	
	@BeforeClass
	public static void setup() throws PersonException {
		
		staff.add(new Staff("Staff1","Staff1","Staff1",Date(1970,1,1),"address1","302-119-1119","email1@gmial.com","9-11",1,10000,Date(2000,8,1),eTitle.MR));
		staff.add(new Staff("Staff2","Staff2","Staff2",Date(1980,1,1),"address2","302-312-2321","email2@gmial.com","1-2",1,18000,Date(2009,7,1),eTitle.MRS));
		staff.add(new Staff("Staff3","Staff3","Staff3",Date(1985,1,1),"address3","302-187-1210","email3@gmial.com","12-2",1,12000,Date(2015,2,1),eTitle.MS));
		staff.add(new Staff("Staff4","Staff4","Staff4",Date(1975,1,1),"address4","302-392-1233","email4@gmial.com","3-4",1,15000,Date(2013,10,18),eTitle.MR));
		staff.add(new Staff("Staff5","Staff5","Staff5",Date(1965,1,1),"address5","302-912-2830","email5@gmial.com","2-3",1,13000,Date(2016,10,13),eTitle.MRS));

	}
	
	

	
	@Test
	public void testAverageSalary(){
		int s = 0; 
		for(Staff Staff: staff){
			s += Staff.getSalary();
		}
		int SalaryAverage =  (s / staff.size());
		int Actual = 13600;
		assertEquals(Actual,SalaryAverage);
	}	
	
	@Test
	public void testDOBException() throws PersonException{
		boolean Exception = true;
		boolean thrown= false;
		try{
			staff.get(2).setDOB(Date(1900,1,1));
		} catch(PersonException e){
			thrown = true;
		}
		assertEquals(Exception, thrown);
	}
	
	@Test
	public void testPhoneException() throws PersonException{
		boolean Exception = true;
		boolean thrown= false;
		try{
			staff.get(1).setPhone("1232132312123123123");
		} catch(PersonException e){
			thrown = true;
		}
		assertEquals(Exception, thrown);
	}
}