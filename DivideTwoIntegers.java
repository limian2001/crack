/*
 * 
 *
 */
public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
        int minus = 1;
        long x = dividend;
        long y = divisor;
        if(y == 1)
            return dividend;
        if(y == -1)
            return -dividend;

        if(dividend < 0 && divisor > 0){
            x = -x;
            minus = -1;
        }
        if(dividend > 0 && divisor < 0){
            y = -y;
            minus = -1;
        }
        if(dividend < 0 && divisor < 0){
            x = -x;
            y = -y;
        }
        if(x == 0 || x < y)
            return 0;
        if(x == y)
            return minus;
        
        x = x - y;
        if(x < y)
            return minus;
            
        //i is used for counting the number of divisors
        int i = 1;
        int count = i;
        long misum = y;

        while(x >= y || x < 0){
            while(x >= y){
                misum = misum << 1;
                x -= misum;
                count = count << 1;
                i += count;
            }
            while(x < 0){
                misum = misum >> 1;
                x += misum;
                count = count >> 1;
                i -= count;              
            } 

        }
        
        if(minus == -1)
            return -i;
        else
            return i;
            
    }
	
	public static void main(String args[]){
		
		System.out.println(divide(901, 30 ));
	}

}
