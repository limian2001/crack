
public class QuickSorting {
    public static void main(String[] args){
    	int a []={2,3,73,6,55,41,82,912,10,12,98,32,1,3,24,321,567,8778,231};
    	Quicksort(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
		System.out.print(a[i]+" ");
    }
    public static void Quicksort(int a[],int left,int right){
         		
    	if(right>left)
    	{
    	int i=left-1;
    	int j;
    	int pivot=a[right];
    	for(j=left;j<right;j++)
    	{
    		if(a[j]<=pivot)
    		{ i++;
    		  swapReferences(a,i,j);
    		}
    	}
    	swapReferences(a,i+1,right);
    	Quicksort(a,left,i);
    	Quicksort(a,i+2,right);
    	}
    	}
 
    public static void swapReferences(int a[],int first,int second)
    {
    	int tmp=a[first];
    	a[first]=a[second];
    	a[second]=tmp;  	
    }

    	 
    }
