package test;

import java.util.Scanner;

public class HelloSwitch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入月份：");
		
		int input = sc.nextInt();	//获取输入的月份
		
        //通过输入的月份来判断当前季节并输出
		/*****start*****/
		switch (input){
			case 12:
			case 1:
			case 2:
				System.out.println(input+"是冬季");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println(input+"是春季");
			case 6:
			case 7:
			case 8:
				System.out.println(input+"是夏季");
			case 9:
			case 10:
			case 11:
				System.out.println("是秋季");
		}
	
		
		/*****end*****/
		
	}
}
