
public class Matrix1_7 {
	public static void main(String args[]){
	int a[][]={{1,2,0},{4,5,6},{7,8,9}};
	ChangetoZero(a);
	for(int i=0;i<a.length;i++)
		for(int j=0;j<a[0].length;j++)
			System.out.println(a[i][j]);
	}
	
	public static void ChangetoZero(int[][] a){
		int x[]=new int[a.length];
		int y[]=new int[a[0].length];
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[0].length;j++)
				if(a[i][j] == 0){
					x[i]=20;
					y[j]=20;
				}
		for(int i=0;i<a.length;i++){
			if(x[i] == 20){
				for(int j=0;j<a[0].length;j++)
				a[i][j]=0;}
		}
		for(int j=0;j<a[0].length;j++){
			if(y[j] == 20){
				for(int i=0;i<a[0].length;i++)
				a[i][j]=0;}
		}
		
					
					
		
	}
	
	

}
