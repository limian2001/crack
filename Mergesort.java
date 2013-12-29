
public class Mergesort {
    public static void main(String[] args){
		
		
		int a []={2,3,73,6,55,41,82,912,10,12,98,32,1,3,24,321,567,8778,231};
		MergeSort(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
		System.out.print(a[i]+" ");
	}
	
	
    public static void MergeSort(int [] c,int p,int q)
    { 	
    	if(p<q)
    	{
    	int middle=(p+q)/2;
    	
    	MergeSort(c,p,middle);
    	MergeSort(c,middle+1,q);
    	Merge(c,p,middle+1,q);
    	}
    	
    }
     public static void Merge(int a[],int leftpo,int rightpo,int rightend)
     {
    	 int tmppo=leftpo;
         int tmp[]=new int[100];
         int leftend=rightpo-1;
         int num=rightend-leftpo+1;
    	 while(leftpo<=leftend&&rightpo<=rightend)
    	 {
    		 if(a[leftpo]<a[rightpo])
    			 tmp[tmppo++]=a[leftpo++];
    		 else
    			 tmp[tmppo++]=a[rightpo++];
    	 }
    	 while(leftpo<=leftend)
    		 tmp[tmppo++]=a[leftpo++];
    	 while(rightpo<=rightend)
    		 tmp[tmppo++]=a[rightpo++];
    	 
    	 for(int i=0;i<num;i++,rightend--)
    		 a[rightend]=tmp[rightend];
        

     }
}
