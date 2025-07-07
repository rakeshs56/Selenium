package javaconcepts;

import java.util.Scanner;

public class java1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		Scanner s=new Scanner(System.in);
		System.out.println("st number");
		int a=s.nextInt();
 
		if(a==1) {
			System.out.println("2 is smallest prime number");
		}
		
		for(i=2; i<a; i++) {
			if(a%i==0) {
				System.out.println(a+" is not prime number");
				break;
			}
		}
		if(a==i) {
			System.out.println(a+" is prime number");
		}	
	}
}
