package test;

import java.util.ArrayList;
import java.util.List;


public class Test1 {

	public static void main(String [] args) {
		
		Test2.print();
	}
	public static void InstanceVariableTest(){
		InstanceVariableTest it = new InstanceVariableTest();
		it.setI(9);//protected method is accessible in same package
	}
	
	public static void listCheck(){
		List<String> vitamins = new ArrayList<>();
		vitamins.add("A");
		vitamins.add("B12");
		vitamins.add("C");
		vitamins.set(1, "B");
		vitamins.add(1, "D");
		System.out.println(vitamins);
		// Whats the output?
	}
	
	public static final class Test3{
		public static void print(){
			System.out.println("Hello, im test3;");
		}
	}

}

class Test2{
	public static void print(){
		Test1.Test3.print();
	}
}