
public class StairDP {
	public static void main(String args[]){
		System.out.println(Stair(50));
		
	}
	public static long Stair(int num){
		long possibleways[]=new long[num+1];
		possibleways[0]=0;
		possibleways[1]=1;
		possibleways[2]=2;
		possibleways[3]=4;
		for(int i=4;i<=num;i++){
			possibleways[i]=possibleways[i-1]+possibleways[i-2]+possibleways[i-3];
		}
		return possibleways[num];
	}

}
