/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example, 
    1
   / \
  2   3



The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13. 

Return the sum = 12 + 13 = 25. 
*/
public class SumRoottoLeafNumbers {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	    public int sumNumbers(TreeNode root) {
	        if(root == null)
	            return 0;
	            
	        String tmp = "";
	        LinkedList<String> res = new LinkedList<String>();
	        
	        sumN(root,tmp,res);
	        
	        int sum = 0;
	        
	        for(String s : res)
	            sum += Integer.parseInt(s);
	        
	        return sum;
	        
	    }
	    
	    public void sumN(TreeNode node,String tmp,LinkedList<String> res){
	        tmp += "" + node.val;
	        
	        if(node.left == null && node.right == null){
	            res.add(tmp);
	           // tmp = "";
	        }
	        else if(node.left == null)
	            sumN(node.right,tmp,res);
	        else if(node.right == null)
	            sumN(node.left,tmp,res);
	        else{
	            sumN(node.right,tmp,res);
	            sumN(node.left,tmp,res);
	        }
	   
	    }
	

}
