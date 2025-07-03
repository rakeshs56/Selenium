package javaconcepts;

import java.util.HashSet;

public class nuoccuranceingivenstring {

	public static void main(String[] args) {
		String s="india";
	//step1:create set collection and add all the character of given set collection
		HashSet<Character> set=new HashSet<Character>();
		for(int i=0;i<s.length(); i++) {
			set.add(s.charAt(i));
			}
	//step2:compare each character of set with all the character of string
			for(Character ch : set) {
				int count=0;
				for(int i=0;i<s.length(); i++) {
	//step3:if matching count the character 
					if(ch==s.charAt(i)) {
						count++;
					}
				}
	//step:print the character and number of occurrence
			System.out.println("character "+ch+" number of occurrence "+count);
		}
		
	}

}
