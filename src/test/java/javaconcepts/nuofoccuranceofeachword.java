package javaconcepts;

import java.util.HashSet;

public class nuofoccuranceofeachword {

	public static void main(String[] args) {
		String s="find the number of occurance in given string";
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
		}
		System.out.println(str+" "+count);
	}
	}} 
