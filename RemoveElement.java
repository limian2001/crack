
public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        int j=0;
        for(int i=0;i<A.length-j;i++){
            if(A[i] == elem){
                A[i]=A[A.length-1-j];
                j++;
                i--;
            }
            
        }
        return A.length-j;
    }

}
