package com.springboot.demo.api.controller;

public class TestLamdba {
	static {
		new Thread(()->{
//			System.out.println("kkk:"+this);
			System.out.println("sss:");
		}).start();
	}
	public static void main(String[] args) {
		new TestLamdba().test();
		Runnable r = ()->{
			System.out.println("----");
		};
		System.out.println("7:"+r);
		new Thread(()->{
//			System.out.println("4:"+this);
			System.out.println("4:");
		}).start();
		new Thread(()->{
			System.out.println("5:");
		}).start();
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("6:"+this);
			}
		}).start();
	}
	public void test(){
		new Thread(()->{
			System.out.println("1:"+this);
			
			new Thread(new Runnable(){
				@Override
				public void run() {
					System.out.println("2:"+this);
					Runnable r = ()->{
						System.out.println("10:"+this);
					};
					new Thread(r).start();
					System.out.println("11:"+r);
				}
			}).start();
			
			new Thread(()->{
					System.out.println("3:"+this);
			}).start();
			
			Runnable r = ()->{
				System.out.println("8:"+this);
			};
			new Thread(r).start();
			System.out.println("9:"+r);
		}).start();
	}
}
