package javaconcepts;

import java.util.Scanner;

public class java5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		char ch[]= {'q', 's', 'p','i','d','e','r','s','s'};
		char key=s.next().charAt(0);
		String result="key not found";
		for(int i=0; i<ch.length; i++) {
			if(ch[i]==key) {
				result="key found"+key;
			}
			}System.out.println(key+":"+result);
		}
		
	}

