/*Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
public class PlusOne {
public int[] plusOne(int[] digits) {
        
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i] == 9)
                continue;
            digits[i] += 1;
            if(i < digits.length-1){
                for(int k=i+1;k<digits.length;k++)
                    digits[k] = 0;
            }
            return digits;
        }
        
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }

}
