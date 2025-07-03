package javaconcepts;

public class reverstringbywithoutlength {
	
//count string without length by using count
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="India";
		char[] c = a.toCharArray();
		int count=0;
		for (char ch:c) {
			count++;
		}
		System.out.println(count);
		 String rev = "";
		for(int i=count-1; i>=0; i--) {
			rev= rev+a.charAt(i);
		}System.out.println(rev);
	}
}
