package com.swabhav.main.poc.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		
		s1.setAge(18);
		s1.setStudentName("hari");
		
		String filename = "studentObject";
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(s1);
			
			objectOutputStream.close();
			fileOutputStream.close();
			
			System.out.println("Object saved in file");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
