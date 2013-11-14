




public class MiniBST4_3 {
	TreeNode CreateMiniBST(int array[]){
		return CreateMiniBST(array,0,array.length-1);
	}
	TreeNode CreateMiniBST(int arr[],int start,int end){
		int mid=(start+end)/2;
		if(start>end)
			return null;
		TreeNode n=new TreeNode(arr[mid]);
		n.left=CreateMiniBST(arr,start,mid-1);
		n.right=CreateMiniBST(arr,mid+1,end);
		return n;
	
	}
	class TreeNode{
		
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int arr){
			
		}
	}
}
		
		