package javaconcepts;

import java.util.Arrays;

public class arraysortminnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {50,82,54,41,21,45};
		System.out.println("given array elemets are "+Arrays.toString(a));
		for(int i=0;i<a.length;i++) 
		{
			for(int j=i+1; j<a.length;j++) 
			{
				if(a[i]<a[j]) 
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.println("sorted given array elemets are "+Arrays.toString(a));
		System.out.println("minmum  in the sorted array "+a[a.length-1]);
	}

}
