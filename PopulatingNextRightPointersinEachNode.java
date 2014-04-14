import java.util.*;
public class PopulatingNextRightPointersinEachNode {
	 public void connect(TreeLinkNode root) {
	        if(root == null)
	            return;
	     
	        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
	        TreeLinkNode head = new TreeLinkNode(0);
	        TreeLinkNode myhead = root;
	        q.add(root);
	        
	        while(!q.isEmpty()){
	            myhead.next = null;
	            myhead = head;
	            //copy queue and empty 
	            Queue<TreeLinkNode> qcopy = new LinkedList<TreeLinkNode>();
	            while(!q.isEmpty()){
	                
	                TreeLinkNode node = q.poll();
	                qcopy.add(node);
	            }
	            //build next relationship and add next level node to queue
	            while(!qcopy.isEmpty()){
	                //build next relationship
	                myhead.next = qcopy.poll();
	                //move on next node
	                myhead = myhead.next;
	                if(myhead.left != null && myhead.right != null){
	                    q.add(myhead.left);
	                    q.add(myhead.right);
	                }
	                
	            }
	        }
	        myhead.next = null;
	        
	        
	    }

}
