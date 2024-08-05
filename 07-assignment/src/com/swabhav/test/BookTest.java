package com.swabhav.test;


import java.util.Scanner;
import com.swabhav.model.Book;
 
public class BookTest {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int size = scanner.nextInt();
 
        Book[] books = new Book[size];
 
        // Inputting book details
        for (int i = 0; i < books.length; i++) {
            System.out.println("\nEnter details for Book " + (i + 1));
            System.out.print("Enter book Id: ");
            int bookId = scanner.nextInt();
            System.out.print("Enter Name of Book: ");
            String name = scanner.next();
            System.out.print("Enter Name of Author: ");
            String author = scanner.next();
            System.out.print("Enter Price of Book: ");
            double price = scanner.nextDouble();
 
            books[i] = new Book(bookId, name, author, price);
        }
 
        // Displaying book details
        System.out.println("\nBook details:");
        for (Book book : books) {
            book.displayBookDetails();
        }
 
 
        // Displaying sorted book details
        System.out.println("\nBooks sorted by price (descending):");
        for (Book book : books) {
            book.displayBookDetails();
        }
 
        scanner.close();
    }
}