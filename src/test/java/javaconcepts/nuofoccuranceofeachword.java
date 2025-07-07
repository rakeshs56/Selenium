package javaconcepts;

import java.util.HashSet;
import java.util.LinkedList;

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
		LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        linkedList.add("Apple"); // Duplicate element

        // Convert LinkedList to HashSet
        HashSet<String> hashSet = new HashSet<>(linkedList);

        // Print the HashSet
        System.out.println("HashSet: " + hashSet);
    }
  }

