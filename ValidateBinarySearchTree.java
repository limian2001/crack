/*
 * Validate Binary Search Tree Total Accepted: 6506 Total Submissions: 25843 My Submissions 





Given a binary tree, determine if it is a valid binary search tree (BST). 

Assume a BST is defined as follows: 
•The left subtree of a node contains only nodes with keys less than the node's key.
•The right subtree of a node contains only nodes with keys greater than the node's key.
•Both the left and right subtrees must also be binary search trees.


confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
*/
public class ValidateBinarySearchTree {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    public boolean isValidBST(TreeNode root) {
	        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	        
	    }
	    
	    public boolean isBST(TreeNode node,int min,int max){
	        if(node == null)
	            return true;
	        if(node.val >= max || node.val <= min)
	            return false;
	        else
	            return isBST(node.left,min,node.val) && isBST(node.right,node.val,max);
	    }
	}

}
