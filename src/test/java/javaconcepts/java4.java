package javaconcepts;

import java.util.Scanner;

public class java4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int ar[]= {1,2,3,4,5,6,7,8,9,};
		int key=s.nextInt();
		String result="key not found";
		for(int i=0; i<ar.length;i++)
		{
			if(ar[i]==key) {
			result="key is found";
			}
		
		}System.out.println(key+":"+result);
	}
}


