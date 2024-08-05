package com.swabhav.model;

public class Book {
    private int bookId;
    private String name;
    private String author;
    private double price;
 
    public Book(int bookId, String name, String author, double price) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.price = price;
    }
 
    public int getBookId() {
        return bookId;
    }
 
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    public void displayBookDetails() {
        System.out.println("Book Id: " + bookId);
        System.out.println("Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("--------------------");
    }
}
