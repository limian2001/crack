/*Cracking 4.1:
 *Implement a function to check if a binary tree
 *is balanced. For the purposes of this question, a
 *balanced tree is defined to be a tree such that the
 *heights of the two subtrees of any node never differ 
 *by more than one.*/


public class isBalance {
	public static void main(String args[]){
		TreeNode root=new TreeNode();
		root.left=new TreeNode();
		root.right=new TreeNode(); 
		root.left.left=new TreeNode();
		root.left.right=new TreeNode();
		root.right.left=new TreeNode();
		root.right.right=new TreeNode();  
	
		if(Math.abs(getHeight(root.left)-getHeight(root.right))>1)
			System.out.println("This tree is not balance!");
		else
			System.out.println("This tree is balance!");
			
	}
	public static int getHeight(TreeNode a){
		if(a==null)
			return 0;
		else if(a.left==null && a.right==null)
			return 1;
		else
			return Math.max(getHeight(a.left),getHeight(a.right))+1;
		
	}
	
	}
	



