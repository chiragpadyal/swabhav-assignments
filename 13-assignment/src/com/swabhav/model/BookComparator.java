package com.swabhav.model;

import java.util.Comparator;

public class BookComparator {
	static public class BookAuthorComparator implements Comparator<Book>{
		@Override
		public int compare(Book book1, Book book2) {
			return book1.getAuthor().compareTo(book2.getAuthor());
		}
	}
	
	static public class BookTitleComparator implements Comparator<Book>{
		@Override
		public int compare(Book book1, Book book2) {
			return book1.getTitle().compareTo(book2.getTitle());
		}
	}
	
	static public class BookPriceComparator implements Comparator<Book>{
		@Override
		public int compare(Book book1, Book book2) {
			return (int) (book1.getPrice() - book2.getPrice());
		}
	}
	
	static public class BookPublicationYearComparator implements Comparator<Book>{
		@Override
		public int compare(Book book1, Book book2) {
			return book1.getPublicationYear() - book2.getPublicationYear();
		}
	}
	
}
