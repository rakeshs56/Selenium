package javaconcepts;

public class maxlnthstring {
//max length of string array
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"abc","abcf","acccc","dddd","eeeee"};
		String max=s[0];
		for(int i=1; i<s.length;i++)
		{
			if(max.length()<=s[i].length())
			{
				max=s[i];
			}
		}System.out.println(max);
	}
}
