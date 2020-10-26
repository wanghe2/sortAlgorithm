package main;

public interface AAA {
	
	String aa="default";
	
	public void fun1();
	
	public default void fun2() {
		System.err.println("-----123456-----");
	}
}
