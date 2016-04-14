package com.temp.control;

import java.util.Scanner;

public class add {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入加数：");
		while (scanner.hasNext()) {
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			System.out.print("a+b=");
			System.out.println(a+b);
			System.out.println("请输入加数：");
		}
	}

}
