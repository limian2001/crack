/*Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum. 
For example:
 Given the below binary tree and sum = 22,               5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1


return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/

public class PathSum {
	 public static boolean hasPathSum(TreeNode root, int sum) {
	        int addup = 0;
	        if(root == null)
	            return false;
	            
	        return pathsum(root,sum,addup);
	    }
	    
	    public static boolean pathsum(TreeNode root,int sum,int addup){
	        
	        if(root == null){
	            if(addup == sum)
	                return true;
	        }
	        else{
	        addup+= root.val;
	        
	        return (pathsum(root.left,sum,addup) || pathsum(root.right,sum,addup));
	        }
	    
	        return false;
	    }
	    
	    public static void main(String args[]){
	    	
	    	TreeNode node = new TreeNode(1);
	    	System.out.println(hasPathSum(node,1));
	    }
	

}
