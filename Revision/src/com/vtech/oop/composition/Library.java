package com.vtech.oop.composition;

public class Library {

	Book book; //HAS A
	
	public Library(String title) {
		this.book = new Book(title);
	}
}
