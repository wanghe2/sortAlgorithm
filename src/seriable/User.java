package seriable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String work;
	
	private String habbies;
	
	
	public User() {
		
	}
	
	public User(String name,String work,String habbies) {
		this.name=name;
		this.work=work;
		this.habbies=habbies;
	}
	
	/**
	 * 序列化与反序列化
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void  main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		/***
		 * 序列化
		 */
		ObjectOutputStream objOutStream=new ObjectOutputStream(new FileOutputStream("D:\\object.out"));
		objOutStream.writeObject(new User("黄药师", "炼药", "弹指神通"));	
		objOutStream.writeObject(new User("欧阳锋", "养蛇", "蛤蟆功"));	
		objOutStream.writeObject(new User("一灯", "念经", "一阳指"));	
		objOutStream.writeObject(new User("洪七公", "要饭", "降龙十八掌"));	
		objOutStream.writeObject(null);//保证不会出现EOF异常
		objOutStream.flush();
		objOutStream.close();
		/**
		 * 反序列化
		 */
		ObjectInputStream objInputStream=new ObjectInputStream(new FileInputStream("D:\\\\object.out"));
		User user_get=null;
		
		while(( user_get=(User)objInputStream.readObject())!=null) {
			System.err.println(user_get.getName()+"--"+user_get.getWork()+"--"+user_get.getHabbies());
		};
		System.err.println("反序列结束");
		objInputStream.close();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getHabbies() {
		return habbies;
	}

	public void setHabbies(String habbies) {
		this.habbies = habbies;
	}
}
