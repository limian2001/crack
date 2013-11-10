
public class XYDPrecursion {
	public static void main(String args[]){
		
		System.out.println(path(10,10));
	}
	
	public static int a;
	public static int path(int x,int y){
		if(x==0||y==0)
			return 1;
		else	
		    return path(x-1,y)+path(x,y-1);
	}

}
