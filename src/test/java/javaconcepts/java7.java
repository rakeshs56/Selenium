package javaconcepts;

public class java7 {
	public static void main(String[] args) {
		int ar[] = { 30, 20, 10, 5, 2, 1, 1, 0 } ;//{ 0, 1, 1, 2, 5, 10, 20, 30 };
        int first_index = 0;
        int last_index  = ar.length-1 ;
        int key = 20 ;

        String result = "Key is not found";
        
        while( first_index <= last_index )
        {
            int mid_index   = (first_index + last_index ) / 2 ;

            if( key  ==  ar[ mid_index ] )
            {
                result = "Key is found @ index :"+mid_index;
                break;
            }
            else if( key < ar[ mid_index ] )
            {
                /*
                 if the key is greater than mid element then 
                    we have to increase the first index
                */
                first_index  = mid_index + 1;
            }
            else if( key > ar[ mid_index ] )
            {
                /*
                 if the key is less than mid then we have to decrease the last
                */
                last_index = mid_index - 1 ;
            }
        } 
        System.out.println( result );
    }
}
