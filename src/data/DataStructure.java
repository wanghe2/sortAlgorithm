package data;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

import main.AAA;
import main.AAAImpl;

public class DataStructure {

	/**
	 *
	 */
	public void fun1() {
		LinkedList<String>linkedList=new LinkedList<String>();
		linkedList.add("one");
		linkedList.add("two");
		linkedList.add("three");
		linkedList.add("four");
		linkedList.push("zero");
		
		System.err.println("*********list使用***********");
		for(String data:linkedList) {
			System.err.println(data);
		}
		

		System.err.println("*********正向队列使用***********");
		while(linkedList.size()>0) {
			System.err.println(linkedList.poll());
		}
		
	}
	
	public static void main(String[] args) {
		DataStructure dataStructure=new DataStructure();
		dataStructure.fun3();
	}
	/**
	 * linkedhashmap （有序）
	 * 
	 * treemap是自动排序
	 */
	public void fun2() {
		LinkedHashMap<String, Object>linkedHashMap=new LinkedHashMap<String, Object>();
		linkedHashMap.put("name", "wanghe");
		linkedHashMap.put("work", "coder");
		linkedHashMap.put("habbies", "running and music");
		for(String key:linkedHashMap.keySet()) {
			System.err.println(key+" : "+linkedHashMap.get(key));
		}
	}
	/**
	 * concurrenthashmap 锁分离技术
	 */
	public void fun3() {
		ConcurrentHashMap<String, Object>concurrentHashMap=new ConcurrentHashMap<String, Object>();
		concurrentHashMap.put("", "");
		AAA aaa=new AAAImpl();
		aaa.fun2();
		
		Hashtable<String, String>hashtable=new Hashtable<String, String>();
		hashtable.put("a", "good");
		
	}
	
}
