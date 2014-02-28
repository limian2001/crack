import java.util.*;

public class Seedproduct {
	private static void seed(int i) {
		ArrayList<Integer> factor=new ArrayList<Integer>();
		for(int j=2;j<=i/2;j++){
			if(i%j==0)
				factor.add(j);
		}
		System.out.println(factor);
		int temp=1;
		for(int number:factor){
			int temp2=number;
			temp=number;
			while(number>0){
				temp*=number%10;
				number=number/10;
			}
			if(temp==i)
				System.out.println(temp2);
		}
	}
		
	public static void main(String args[]){
		seed(4977);
		
	}

}
