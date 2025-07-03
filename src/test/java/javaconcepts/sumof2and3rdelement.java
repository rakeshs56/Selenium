package javaconcepts;

import java.util.Arrays;

public class sumof2and3rdelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {55,78,51,99,23};
		System.out.println("given array elemets are "+Arrays.toString(a));
		for(int i=0;i<2;i++) 
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
		int sum=0;
		for(int i=0; i<2; i++) {
			sum=sum+a[i];
		}System.out.println("sorted 1st 2 array elements are "+ Arrays.toString(a));
		System.out.println("sum of 1st and 2nd element in the sorted array "+sum);		
	}
}
