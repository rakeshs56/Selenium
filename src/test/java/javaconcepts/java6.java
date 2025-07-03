package javaconcepts;

import java.util.Scanner;

public class java6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("enter index number");
		int count=s.nextInt();
		int ar[]= {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9};
		System.out.println("enter key number");
		int key=s.nextInt();
		String result="key not found";
		
		for(int i=0; i<ar.length; i++) {
			if(ar[i]==key) {count--;}
			if(count==0) { result="key is found at index"+i; break;}
		}System.out.println(key+":"+result);
	}

}
