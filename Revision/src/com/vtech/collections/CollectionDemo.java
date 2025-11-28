package com.vtech.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionDemo {

	public static void main(String[] args) {
		List arrayList = new ArrayList();
		arrayList.add("A");
		arrayList.add("B");
		arrayList.add(3);
		arrayList.add(3);
		arrayList.add(null);
		arrayList.add(null);
		System.out.println(arrayList);
		System.out.println(arrayList.get(4));
		
		System.out.println("=========LinkedList ==============");
		LinkedList linkedList = new LinkedList();
		linkedList.add("A");
		linkedList.add("B");
		linkedList.add(3);
		linkedList.add(3);
		linkedList.add(null);
		linkedList.add(null);
		System.out.println(linkedList);
		System.out.println(linkedList.get(2));
		
		
		System.out.println("=========HashSet=========");
		Student s1 = new Student(101, "Pavan");
		Student s2 = new Student(102, "Chethan");
		Student s3 = new Student(103, "Priya");
		Student s4 = new Student(101, "Pavan"); //duplicate
		Student s5 = new Student(101, "Varun"); // hash collisions
		
		Set<Student> hs = new HashSet<Student>();
		hs.add(s1);
		hs.add(s2);
		hs.add(s3);
		hs.add(s4);
		hs.add(s5);
		hs.add(s3);
		hs.add(null);
		hs.add(null);
		
		System.out.println(hs);
		
		
	}
}
