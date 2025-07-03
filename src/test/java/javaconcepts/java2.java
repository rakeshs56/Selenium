package javaconcepts;

import java.util.Scanner;

public class java2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("enter number");
		int a=s.nextInt();
		int sum=0;
		int rev=0;
		while(a>0) {
			int rem=a%10;
			rev=rev*10+rem;
			sum=sum+rev;
			a=a/10;
		}
		System.out.println(rev);
	}

}
