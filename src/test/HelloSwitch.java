package test;

import java.util.Scanner;

public class HelloSwitch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�������·ݣ�");
		
		int input = sc.nextInt();	//��ȡ������·�
		
        //ͨ��������·����жϵ�ǰ���ڲ����
		/*****start*****/
		switch (input){
			case 12:
			case 1:
			case 2:
				System.out.println(input+"�Ƕ���");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println(input+"�Ǵ���");
			case 6:
			case 7:
			case 8:
				System.out.println(input+"���ļ�");
			case 9:
			case 10:
			case 11:
				System.out.println("���＾");
		}
	
		
		/*****end*****/
		
	}
}
