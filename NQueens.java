/*The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
 There exist two distinct solutions to the 4-queens puzzle:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

*/
import java.util.*;
public class NQueens {
	public static ArrayList<String[]> solveNQueens(int n) {
		
	        char[][] k = new char[n][n];
	        ArrayList<String[]> res = new ArrayList<String[]>();
	        

	        recrusivePlace(k,0,res);
	        return res;
	        
	        
	        
	        
	    }
	    //check left side there is no violation
	    public static boolean isValid(char[][] k,int i,int j){
	        //check the same row
	        for(int t=j-1;t>=0;t--){
	            if(k[i][t] == 'Q')
	                return false;
	        }
	        int row = i;
	        int col = j;
	        //check leftup diagonal
	        while(row>0 && col>0){
	            row--;
	            col--;
	            if(k[row][col] == 'Q')
	                return false;
	        }
	        row = i;
	        col = j;
	        //check leftdown diagonal
	        while(row<k.length-1 && col>0){
	            row++;
	            col--;
	            if(k[row][col] == 'Q')
	                return false;
	        }
	        return true;
	        
	    }
	    //place from leftmost column, keep going right column if valid
	    public static void recrusivePlace(char[][] k,int column,ArrayList<String[]> res){
	        if(column == k.length){
	            writeRes(k,res);
	            return;
	        }
	        
	        for(int i=0;i<k.length;i++){
	            if(isValid(k,i,column)){
	                k[i][column] = 'Q';
	                recrusivePlace(k,column+1,res);
	                k[i][column] = '.';
	            }
	            
	            
	        }
	        
	    }
	    //transfer array to result
	    public static void writeRes(char[][] k,ArrayList<String[]> res){
	        String[] ss = new String[k.length];
	        
	        for(int i=0;i<k.length;i++){
	            String s = "";
	            for(int j=0;j<k.length;j++){
	                if(k[i][j] == 'Q')
	                    s += 'Q';
	                else
	                    s += '.';
	            }
	            ss[i] = s;
	                
	        }
	        res.add(ss);
	            
	    }
	
	public static void main(String args[]){
		ArrayList<String[]> s = solveNQueens(4);
		for(String[] ss : s){
			System.out.println("--------------");
			for(String k : ss)
			System.out.println(k);
    }
	}

}
