package javaconcepts;

import java.util.HashSet;

public class printuniquecharacterfromsytring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="india";
		HashSet<Character> set =new HashSet<Character>();
		for(int i=0; i<s.length(); i++) {
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
			}if(count==1) {
				System.out.println("unique character is "+ch);
			}
		}
	}

}


