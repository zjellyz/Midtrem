package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Student extends Person {

	private UUID StudentID;
	eMajor eMajor;
	
	
    public Student (eMajor eMajor){
        this.eMajor = eMajor;    
    }
    
    public UUID getStudentID(){
    	return this.StudentID;
    }
    
	public Student(String FirstName, String MiddleName, String LastName,Date DOB, eMajor eMajor,
			String Address, String Phone_number, String Email) throws PersonException
	{
		super(FirstName, MiddleName, LastName, DOB, Address, Phone_number, Email);
		this.StudentID = UUID.randomUUID();
		this.eMajor = eMajor;
		
	}
	
	@Override
	public void PrintName() {
		System.out.println(getLastName() + ","  + getFirstName() + ' ' + getMiddleName());
	}

	public void PrintName(boolean bnormal)
	{
		super.PrintName();
	}
}