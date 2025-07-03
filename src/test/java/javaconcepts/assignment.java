package javaconcepts;

import java.util.Arrays;

public class assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"apple","mango","banana","orange"};
		//so
		for(int i=1; i<s.length; i++) {
			if(s[0].length()>s[i].length()) {
				String temp=s[0];
				s[i]=s[0];
				s[0]=temp;
			}
		}
		System.out.println(Arrays.toString(s));
		
		//sort according to alphabet
		Arrays.sort(s);
		System.out.println(Arrays.toString(s));
	}
}