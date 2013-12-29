

import java.util.ArrayList;
import java.util.Stack; 

public class preorderNonRecrusion  {
    public static ArrayList<Integer> visit = new ArrayList<Integer>();
    
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
       Stack<TreeNode> s = new Stack<TreeNode>(); 
       TreeNode p = root;
       while(!s.isEmpty() || p != null){
    	  
    	   while(p!=null){
    		  visit.add(p.val);
    		  s.push(p);
    		  p = p.left;
    	   }
    	   
    	   if(!s.isEmpty()){
    		   p=(s.pop()).right;
    		   
    	   }
    	   	   
          }
    	  
    	  
    	  
       return visit; 
        }
        

    
    public static void main(String args[]){
    	TreeNode a = new TreeNode(1);
    	a.left = new TreeNode(2);
    	a.right = new TreeNode(3);
    	
    	System.out.println(preorderTraversal(a));
    }
        

        
    }