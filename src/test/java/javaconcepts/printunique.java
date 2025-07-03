package javaconcepts;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class printunique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="find the number of of occurance in given string";
		String[] st=s.split(" ");
		HashSet<String> set =new HashSet<String>();
		for(int i=0;i<st.length;i++) {
			set.add(st[i]);
		}
		for(String str:st) {
			int count=0;
		for(int i=0;i<st.length;i++) {
			if(str.equals(st[i])) {
				count++;
			}
		}if(count==1) 
		{
			System.out.print(str+" ");
		}
	}
	}
}
