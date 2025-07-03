package javaconcepts;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class removeduplicates {

	public static void main(String[] args) {
		String s="find the number of of occurance in given string";
		String[] st=s.split(" ");
		LinkedHashSet<String> set =new LinkedHashSet<String>();
		
		for(int i=0;i<st.length;i++) {
			set.add(st[i]);
		}
		for(String str:set)
		System.out.print(str+" ");
	}}
