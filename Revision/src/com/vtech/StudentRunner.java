package com.vtech;

public class StudentRunner {

	public static void main(String[] args) {
		Student s1 = new Student(); 
		s1.setId(-101);
		s1.setCource(Cource.JAVA_FULL_STACK);
		s1.setName("Rahul");
		
		System.out.println(s1); //com.vtech.Student@4517d9a3
		//After overiding toString() - Student [id=10, name=Rahul, cource=JAVA_FULL_STACK]
		
		Student s2 = new Student(102, "Rakesh", Cource.PYTHON_FULL_STACK);
		System.out.println(s2);

		Student s3 = new Student(new Student(103, "Raju", Cource.DATA_ANALYTICS));
		System.out.println(s3);
		
		
	}
}
