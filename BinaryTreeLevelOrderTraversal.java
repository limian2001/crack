/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
 Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7



return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

*/
import java.util.*;

public class BinaryTreeLevelOrderTraversal {
public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(root == null)
            return res;
        if(root.left == null && root.right == null){
            tmp.add(root.val);
            res.add(new ArrayList<Integer>(tmp));
            return res;
        }
        
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node != null){
                tmp.add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            else{
                res.add(new ArrayList<Integer>(tmp));
                tmp.clear();
                if(!q.isEmpty())
                    q.add(null);
            }
  
        }
        return res;
        
    }

	public static void main(String args[]){
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		a.right = new TreeNode(3);
		a.left.left = new TreeNode(4);
		a.left.right = new TreeNode(5);
		System.out.println(levelOrder(a));
	}
	

}
