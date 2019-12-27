/*

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?

*/

class Solution {
    public int myAtoi(String str) {
        if (str == null)
            return 0;
        
        Boolean sign = false, digits = false, isPositive = true;
        int result = 0;
        
        for (char ch : str.toCharArray()) {
            // escape white space characters
            if (ch == ' ') {
                if (digits == true || sign == true)
                    break;
                
                continue;
            } else if (ch == '-' || ch == '+') {
                if (digits == true || sign == true)
                    break;
                
                sign = true;
                isPositive = (ch == '-') ? false : true;
                
            } else if (ch >= 48 && ch <= 57) {
                digits = true;

                if (isPositive) {
                    if (result > Integer.MAX_VALUE/10 || result*10 > Integer.MAX_VALUE - ch + 48)
                        return Integer.MAX_VALUE;
                } else {
                    if (-1*result < Integer.MIN_VALUE/10 || -1*result*10 < Integer.MIN_VALUE + ch - 48)
                        return Integer.MIN_VALUE;
                }
                
                result = (result * 10) + ch - 48;
            } else {
                if (digits == true)
                    break;
                else
                    return 0;
            }
        }
        return (isPositive)?result:-result;
    }
}

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String str = stringToString(line);
            
            int ret = new Solution().myAtoi(str);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
