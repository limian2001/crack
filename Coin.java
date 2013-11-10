
public class Coin {

	public static void main(String args[]){
		int[] a={1,2,5,10,20,50,100};
		System.out.println(CoinDp(198,a));
	}
	
	public static int CoinDp(int value,int[] a){
		int[] min=new int[value+1];
		min[0]=0;
		for(int i=1;i<=value;i++)
			min[i]=value;
		
		for(int i=1;i<=value;i++){
		    for(int j=0;j<a.length;j++){
		    	if((a[j]<=i)&&(min[i-a[j]]+1<min[i]))
		    		min[i]=min[i-a[j]]+1;
		    	
		    	
		    }
		}
		if(min[value]==value)
			return 9999;
		return min[value];
	}
	
}
