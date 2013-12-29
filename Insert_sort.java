

public class Insert_sort {
    
	public static void main(String[] args){
		
		
		int a []={2,78,6,12,30,67,1208,888,1001};
		insert(a);
		for(int i=0;i<a.length;i++)
		System.out.print(a[i]+" ");
	}
	
	
    public static void insert(int [] a)
    { 	
    	int tmp;
    	for(int i=1;i<a.length;i++)
    	{	tmp=a[i];
    		int j;
    		for(j=i;a[j]<a[j-1]&&j>0;j--)
    			a[j]=a[j-1];
    		    a[j]=tmp;
    	}	
    	
    	 
    }
}
