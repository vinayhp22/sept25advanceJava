package com.vtech;

public class VariablesDemo {

	// instance variables(object level varibales)
	int n1; // primitive (store data directly memory)
	String s1; //reference (store only refernces in the memory)
	
	//static variables
	static int n2 ;
	static String s2 ;
	
	public VariablesDemo(int n1, String s1) {
		this.n1 = n1;
		this.s1 = s1;
	}

	public VariablesDemo() {}
	public static void main(String[] args) {
		//local variables
		int n3 = 30;
		String s3 = "Vtech";
		
		VariablesDemo v = new VariablesDemo();
		System.out.println(v.n1); 
		System.out.println(VariablesDemo.n2);
		System.out.println(v.s1); // use object reference
		System.out.println(VariablesDemo.s2); // use class name
		v.display();
		
		System.out.println("n3: "+n3);
		System.out.println("s3: "+s3);
	
	}
	
	public void display() {
		System.out.println(n1); //instace
		System.out.println(n2); // static
	}
}

