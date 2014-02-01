import java.util.Arrays;


public class RemoveDuplicatesfromSortedArrayII {
public static int removeDuplicates(int[] A) {
        
        if(A.length < 3)
            return A.length;
        int i=1,j=1,num=0;
        
        for(;j<A.length;j++){
            
            if(A[j] != A[j-1]){
                num=0;
                
            }
            else{
                num++;
            }
            if(num < 2)
                A[i++]=A[j];
            
        }
      
        return i;   
    }
	public static void main(String args[]){
		int[] a={0,0,0,0,0};
		System.out.println(removeDuplicates(a));
		System.out.println(Integer.MIN_VALUE);
	}

}
