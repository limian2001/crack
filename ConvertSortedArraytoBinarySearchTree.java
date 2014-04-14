//Given an array where elements are sorted in ascending order, convert it to a height
//balanced BST.

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0)
            return null;
        TreeNode root = new TreeNode(0);
        toBst(num,0,num.length-1,root);
        return root; 
    }
    
    public void toBst(int[] num,int i,int j,TreeNode root){
        if(i > j)
            return;
        if(i == j){
            root.val = num[i];
            return;
        }
        if(i+1 == j){
            root.val = num[j];
            root.left = new TreeNode(num[i]);
        }
        else{
            int mid = (i+j)/2;
            root.val = num[mid];
            root.left = new TreeNode(0);
            root.right = new TreeNode(0);
            toBst(num,i,mid-1,root.left);
            toBst(num,mid+1,j,root.right);
        }
    }

}
