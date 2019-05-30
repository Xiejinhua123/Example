package com.xiejinhua.example.test;

public class Test {
	
	{
		System.out.println("初始化");
	}
	
	static {
		System.out.println("静态代码块");
	}
	
	public Test() {
		System.out.println("无参构造");
	}
	
	public void print() {
		
		a:{
			System.out.println("a");
			boolean b = getBoolean();
			if ( b )
				break a;
			else
				System.out.println("a1");
		}
		
		{
			System.out.println("b");
		}
		
		{
			System.out.println("c");
		}
		
	}

	private boolean getBoolean() {
		return false;
	}
	

}
