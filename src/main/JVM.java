package main;

import java.util.ArrayList;

public class JVM {
	
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Object> list=new ArrayList<>();
		while(true) {
			byte[] aa=new byte[1*32*128];
			list.add(aa);
			Thread.sleep(500);
			System.err.println(list.size() );
//			System.err.println(list.size() );
		}
	}
	
}
