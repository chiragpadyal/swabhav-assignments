package com.swabhav.main.poc;

//In this Java program, we accepts a file or directory name
//from command line arguments. Then the program will check
//if that file or directory physically exist or not and it
//displays the property of that file or directory.

import java.io.File;

//Displaying file property
class FileProperty {
 public static void main(String[] args)
 {
	 
     File f = new File("D:\\training\\05-assignment\\src\\com\\swabhav\\main\\text");
     
     System.out.println("File name: " + f.getName());
     System.out.println("Path: " + f.getPath());
     System.out.println("Absolute path: "
                        + f.getAbsolutePath());
     System.out.println("Parent: " + f.getParent());
     System.out.println("Exists : " + f.exists());

     if (f.exists()) {
         System.out.println("Is writable: "
                            + f.canWrite());
         System.out.println("Is readable: " + f.canRead());
         System.out.println("Is a directory: "
                            + f.isDirectory());
         System.out.println("File Size in bytes : "
                            + f.length());
         
         System.out.println("Turn writable Off");
         f.setWritable(false);
     }
 }
}
