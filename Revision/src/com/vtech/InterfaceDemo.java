package com.vtech;

public interface InterfaceDemo {

	public abstract void run();
	
	public default void start() {
		System.out.println("Utility method for this interface &  child classes");
		walk();
	}
	
	public static void stop() {
		System.out.println("When we have common feature");
		
	}
	
	private void walk() {
		System.out.println("Helps like a utilty for this interface only");
	}
}
