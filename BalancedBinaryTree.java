
public class BalancedBinaryTree {
	 public boolean isBalanced(TreeNode root) {
	        if(root == null)
	            return true;
	        if(Math.abs((height(root.left)-height(root.right))) <= 1  && isBalanced(root.left) && isBalanced(root.right))
	            return true;
	        else
	            return false;
	    }
	    
	    public static int height(TreeNode node){
	        if(node == null)
	            return 0;
	        if(node.left == null && node.right == null)
	            return 1;
	        if(node.left == null)
	            return height(node.right)+1;
	        if(node.right == null)
	            return height(node.left)+1;
	        return Math.max(height(node.left),height(node.right))+1;
	        
	    }

}
