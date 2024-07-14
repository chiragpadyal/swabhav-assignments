package com.swabhav.main.poc.serialization;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo {

	public static void main(String[] args) {
		String filename = "studentObject";
		
		
		
		try {
			FileInputStream fileinputStream = new FileInputStream(filename);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileinputStream);
			
			Student obj = (Student)objectInputStream.readObject();
			System.out.println(obj.toString());
			
			objectInputStream.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
