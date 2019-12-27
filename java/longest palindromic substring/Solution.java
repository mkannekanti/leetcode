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
    public String longestPalindrome(String s) {
        int maxPalindrome = 0, maxPalindromeStart = 0;
                    
        // for each character, find the max palindrome
        for (int i = 0; i < s.length(); i++) {
            int curMax = 0, j = i, k = s.length() - 1;
            
            while (j <= k) {
                if (s.charAt(j) == s.charAt(k)) {
                    curMax += (j == k)? 1:2;
                    j++;
                    k--;
                } else {
                    curMax = 0;
                    k--;
                }  
            }
            
            // check if this is longer
            if (curMax > maxPalindrome) {
                maxPalindrome = curMax;
                maxPalindromeStart = i;
            }            
        }
        return s.substring(maxPalindromeStart, maxPalindromeStart+maxPalindrome);
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
