package pru04.E05;

import java.util.Scanner;

public class PRU04E05Parkingtest_damia_febrer {
	public static void main (String[] args) {
		System.out.println("Introduce matricula");
		Scanner sc = new Scanner(System.in);
		String inicial;
		int test;
		String matricula="";
		inicial=sc.nextLine();
		try {
			for(int i=0; i<4; i++) {
				if(inicial.charAt(i)>=48 || inicial.charAt(i)<=57) {
					matricula+=inicial.charAt(i);
				}
			}
			System.out.println(matricula);
		}
		catch(Exception e) {
			System.out.println("La matricula introducida es incorrecta");
		}
	}
}
