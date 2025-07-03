package javaconcepts;

import java.util.LinkedHashSet;

public class numberofoccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="india";
		LinkedHashSet<Character> set =new LinkedHashSet<Character>();
		for(int i=0; i<s.length(); i++) {
			set.add(s.charAt(i));
	}
		for(Character ch:set) {
		System.out.print(ch);
}}}