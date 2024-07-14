package com.swabhav.main.poc.serialization;

import java.io.Serializable;

public class Student implements Serializable{
	
    private int age;
    private String studentName;
    
    public int getAge() {
		return age;
	}
    
    public String getStudentName() {
		return studentName;
	}
    
    public void setAge(int age) {
		this.age = age;
	}
    
    public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
    
    public String toString() {
    	return "Student name is " + this.studentName + " and age is " + this.age;
    }
}