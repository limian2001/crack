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
addup += root.val;
        
        if(root.left == null && root.right == null){
            if(addup == sum)
                return true;
            else
                return false;
        }
        else if(root.left == null)
            return pathsum(root.right,sum,addup);
        else if(root.right == null)
            return pathsum(root.left,sum,addup);
        else{
            return pathsum(root.right,sum,addup) || pathsum(root.left,sum,addup);
        }
        
        }
    
        
	    
	    
	    public static void main(String args[]){
	    	
	    	TreeNode node = new TreeNode(1);
	    	TreeNode node1 = new TreeNode(2);
	    	node.left = node1;
	    	System.out.println(hasPathSum(node,3));
	    }
	

}
