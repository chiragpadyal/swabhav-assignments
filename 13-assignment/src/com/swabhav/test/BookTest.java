package com.swabhav.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.swabhav.model.Book;
import com.swabhav.model.BookComparator;


public class BookTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Book> books = new ArrayList<Book>();
		addBooks(scanner, books);
		showBooks(books);
		
		System.out.println("---------- Sort By Author, Title and Price -------------");
		sortByAuthorByTitleByPrice(books);
		showBooks(books);
		
		System.out.println("---------- Sort By Publication Year, Price and Author -------------");
		sortByYearByPriceByAuthor(books);
		showBooks(books);
	}
	
	private static void addBooks(Scanner scanner, List<Book> books) {
		System.out.println("Enter the number of books to be added: ");
		int numberOfBooks = scanner.nextInt();
		for (int i = 1; i <= numberOfBooks; i++) {
			scanner.nextLine();  // consume left over
	        System.out.println("-----------------------------------");
	        System.out.println("Enter book " + i + " title: ");
	        String title = scanner.nextLine();
	        System.out.println("Enter book " + i + " author: ");
	        String author = scanner.nextLine();
	        System.out.println("Enter book " + i + " price: ");
	        double price = scanner.nextDouble();
	        System.out.println("Enter book " + i + " publication year: ");
	        int publicationYear = scanner.nextInt();
	        
			
			Book book = new Book(title, author, price, publicationYear);
			books.add(book);
		}
	}
	private static void showBooks(List<Book> books) {
		for (Book book : books) {
			System.out.println(book);
		}
		
	}
	
	private static void sortByAuthorByTitleByPrice(List<Book> books) {
		books.sort(
				new BookComparator.BookAuthorComparator()
				.thenComparing(new BookComparator.BookTitleComparator()
				.thenComparing(new BookComparator.BookPriceComparator()
				)));
	}
	
	private static void sortByYearByPriceByAuthor(List<Book> books) {
		books.sort(
				new BookComparator.BookPublicationYearComparator()
				.thenComparing(new BookComparator.BookPriceComparator()
				.thenComparing(new BookComparator.BookAuthorComparator()
				)));
	}
	
}
