package javaconcepts;

import java.util.HashSet;

public class printduplicatefromgivenstring {

	public static void main(String[] args) {
		String s="india";
	//create collection and add all characters to set
		HashSet<Character> set=new HashSet<Character>();
		for(int i=0; i<s.length();i++) {
			set.add(s.charAt(i));
		}
		for(Character ch:set) {
			int count=0;
	//compare all character with given string
			for(int i=0;i<s.length();i++) {
		
				if(ch==s.charAt(i)) {
	//if character is matching count the character
					count++;
				}
	//print duplicate character
			}if(count>1) {
				System.out.println("duplicate character is "+ch);
			}
		}
		
	}

}
