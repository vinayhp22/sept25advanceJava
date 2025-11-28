package com.vtech.oop.composition;

public class Runner {

	public static void main(String[] args) {
		Book java = new Book("Java Programming");
		System.out.println(java.title);
		
		Library library = new Library("DSA");
		System.out.println(library.book.title);
	}
}
