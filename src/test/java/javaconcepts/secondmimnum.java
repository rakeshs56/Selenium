package javaconcepts;

import java.util.Arrays;

public class secondmimnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {55,78,51,99,23};
		System.out.println("given array elemets are "+Arrays.toString(a));
		for(int i=0;i<a.length;i++) 
		{
			for(int j=i+1; j<a.length;j++) 
			{
				if(a[i]<a[j]) //Descending
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.println("sorted given array elemets in decending are "+Arrays.toString(a));
		System.out.println("second minimum element in the sorted array "+a[a.length-2]);
	}
}
