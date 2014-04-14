/*Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. 
For example:
 Given the below binary tree and sum = 22,               5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1


return

[
   [5,4,11,2],
   [5,8,4,5]
]

*/
import java.util.*;
public class PathSumII {
public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        
        if(root == null)
            return res;
            
        if(root.left == null && root.right == null){
            if(root.val == sum){
                tmp.add(sum);
                res.add(new ArrayList<Integer>(tmp));
                return res;
            }
            else
                return res;
        }
        tmp.add(root.val);
        
        if(root.left == null)
            path(root.right,sum - root.val,tmp,res);
        
        else if(root.right == null)
            path(root.left,sum - root.val,tmp,res);
        else{
            path(root.right,sum - root.val,tmp,res);
            path(root.left,sum - root.val,tmp,res);
        }
            
        return res;
        
    }
    
    public static void path(TreeNode root,int sum,ArrayList<Integer> tmp,ArrayList<ArrayList<Integer>> res){
        tmp.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == root.val)
                res.add(new ArrayList<Integer>(tmp));
        }
        else{
            
            if(root.left == null && root.right != null)
                path(root.right,sum - root.val,tmp,res);
            else if (root.right == null && root.left != null)
                path(root.left,sum - root.val,tmp,res);
            else{
         k:       path(root.right,sum - root.val,tmp,res);
         j:       path(root.left,sum - root.val,tmp,res);
            }
        
        
        }
         //这句删除，其实是为了k和j两句命令中间传送tmp的时候用到的。当k执行完毕的时候，tmp已经写进了k的内容，交给j的时候要删除，这样k,j拿到的tmp菜一样
        //否则，j拿到的tmp已经是k递归结束以后的tmp了
        tmp.remove(tmp.size() - 1);
        
    }
    
    public static void main(String args[]){
    	
    	TreeNode node = new TreeNode(1);
    	TreeNode node1 = new TreeNode(2);
    	node.left = node1;
    	node.right = new TreeNode(3);
    	node.left.left = new TreeNode(3);
    	node.left.right = new TreeNode(2);
    	node.right.left = new TreeNode(2);
    	node.right.right = new TreeNode(2);
    	System.out.println(pathSum(node,6));
    }


}
