
public class ValidSoduku {
	
	    public boolean isValidSudoku(char[][] board) {
	        HashSet<Character> set=new HashSet<Character>(); 
	        for(int i=0;i<9;i++){
	            set.clear();
	            for(int j=0;j<9;j++){
	                if(set.contains(board[i][j]))
	                    return false;
	                else{
	                    if(board[i][j] != '.')
	                        set.add(board[i][j]);
	                }
	            }
	        }
	        for(int j=0;j<9;j++){
	            set.clear();
	            for(int i=0;i<9;i++){
	                if(set.contains(board[i][j]))
	                    return false;
	                else{
	                    if(board[i][j] != '.')
	                        set.add(board[i][j]);
	                }
	            }
	        }
	        for(int i=0;i<9;i+=3)
	            for(int j=0;j<9;j+=3){
	                if(check9(board,i,j) == false)
	                    return false;
	        
	            }
	        return true;
	        
	        
	        
	    }
	    
	    public boolean check9(char[][] c,int a,int b){
	        HashSet<Character> set=new HashSet<Character>(); 
	        for(int i=a;i<a+3;i++)
	            for(int j=b;j<b+3;j++){
	                if(set.contains(c[i][j]))
	                    return false;
	                else{
	                    if(c[i][j] != '.')
	                        set.add(c[i][j]);
	                }
	            }
	        return true;
	    }
	    
	    
	

}
