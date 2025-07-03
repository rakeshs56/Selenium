package javaconcepts;

import java.util.Scanner;

public class java3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		int c=s.nextInt();
		
		int d=a>c?(a>b?a:c):(c>b?c:b);
		System.out.println(d);
	}

}
