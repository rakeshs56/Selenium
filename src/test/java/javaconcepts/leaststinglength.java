package javaconcepts;

public class leaststinglength {
//min length of string array
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s[]= {"bye","who","hi","to","amma"};
		String min=s[0];
		for(int i=1; i<s.length; i++) {
			if(min.length()>s[i].length()) {
				min=s[i];
			}
		}
		for(int i=0; i<s.length; i++) {
			if(min.length()==s[i].length()) {
			System.out.println(s[i]);}
		}
	}
}
