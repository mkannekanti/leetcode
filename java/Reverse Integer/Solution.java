/*

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/

class Solution {
    public int reverse(int x) {
        
        int leftover = x;
        int result = 0, step = 0, digit, sign = 1;
        int maxIntForMultiply = Integer.MAX_VALUE/10;
        
        if (x < 0) {
            sign = -1;
            leftover = sign*x;
        }
        
        while (leftover > 0) {
            digit = leftover%10;
            leftover /= 10;

            if (result > maxIntForMultiply || result > Integer.MAX_VALUE - digit)
                return 0;
            
            result = (10*result) + digit;
        }
        
        result *= sign;
        return result;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            
            int ret = new Solution().reverse(x);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
