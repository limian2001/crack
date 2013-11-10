
public class CutCod {
	public static void main(String args[]){
		int[] price={3,4,8,9,10,17,17,20};
		int length=8;
		System.out.println(Maxcut(length,price));
	}
	public static int Maxcut(int l,int p[]){
		int[] max=new int[l+1];
		
		for(int i=1;i<=l;i++)
			for(int j=1;j<=i;j++){
				if(max[i-j]+p[j-1]>max[i])
					max[i]=max[i-j]+p[j-1];
	}
	return max[l];
    }
}
