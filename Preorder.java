import java.util.*; 

public class Preorder {
    public static ArrayList<Integer> tree = new ArrayList<Integer>();
    
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
       
       preorder(root);
       return tree; 
        }
        
    public static void preorder(TreeNode root){
    if(root != null){
    	tree.add(root.val);
        preorder(root.left);
        preorder(root.right);
           
    }
    }
    
    public static void main(String args[]){
    	TreeNode a = new TreeNode(1);
    	a.left = new TreeNode(2);
    	a.right = new TreeNode(3);
    	
    	System.out.println(preorderTraversal(a));
    }
        

        
    }