import java.util.LinkedList;

import javax.xml.soap.Node;




public class DirectedGraph4_2 {
	public enum State{
		Unvisited,Visited,Visiting;
	}
	public static boolean search(Graph g, Node start, Node end){
		LinkedList<Node> q=new LinkedList<Node>();
		
		for(Node u:g,getNodes()){
			u.state=State.Unvisited;
		}
		start.state=State.Visiting;
		q.add(start);
		Node u;
		while(!q.isEmpty()){
			u=q.removeFirst();
		   if(u!=null){
			   for(Node v:u.getAdjacent()){
				   if(v.state==State.Unvisited){
					   if(v==end){
						   return true;
					   }else{
						   v.state=State.Visiting;
						   q.add(v);
					   }
				   }
			   }
			   u.state=State.Visited;
		   }
		}
		return false;
	}
	

}
