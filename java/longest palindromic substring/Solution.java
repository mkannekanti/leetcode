/*

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

*/

class Solution {
    
    public String longestPalindrome (String s) {
        if (s == null)
            return null;
        
        int strLen = s.length();
        
        if (strLen == 0)
            return "";
        
        Boolean[][] table = new Boolean[strLen][strLen];
        int maxLen = 1 , startI = 0, end = 0;
        
        // for each possible length of palindrome check the palindrome and update the table.
        // start from the begining of the string check the palindrome for the current length.
        for (int len = 1; len <= strLen; len++) {
            for (int start = 0;  start <= strLen - len; start++) {
                end = start + len - 1;
                
                if (s.charAt(start) == s.charAt(end)) {
                    if (len <= 2)
                        table[start][end] = true;
                    else
                        table[start][end] = table[start+1][end-1];
                } else
                    table[start][end] = false;
                
                if (len > 1 && table[start][end] == true) {
                    maxLen = (maxLen < len)? len : maxLen;
                    startI = start;
                }
            }
        }
        
        return s.substring(startI, startI + maxLen);
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
            String s = stringToString(line);
            
            String ret = new Solution().longestPalindrome(s);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}
