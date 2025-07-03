package javaconcepts;

import java.util.Scanner;

public class palendrome {

	public static void main(String[] args) {
		 Scanner user_input = new Scanner( System.in ); 
		    String variable;
		    System.out.print("Enter Variable:");
		      variable = user_input.next();
		          Separate(variable);
		   }

		   public static void Separate(String str) {
		          String number = "";
		          String letter = "";
		          String spch="";
		      String symbol = "";
		          for (int i = 0; i < str.length(); i++) {
		                 char a = str.charAt(i);
		                 if (Character.isDigit(a)) {
		                       number = number + a;

		                 } else if(Character.isAlphabetic(a)) {
		                       letter = letter + a;
		         }else {
		        	 spch=spch+a;
		         }
		          }
		          System.out.println("Alphabets in string:"+letter);
		          System.out.println("Numbers in String:"+number);   
		          System.out.println("spch in String:"+spch);   
		   }
		}
