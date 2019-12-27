/*

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false

*/

class Solution {
    public boolean isMatch(String s, String p) {
        /*
        // Is pattern empty?
        if (p.isEmpty()) return s.isEmpty();
        
        // check if the first character matches
        boolean match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        
        // need to handle if Kleene star proceeds with this character
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (match && isMatch(s.substring(1), p) || (isMatch(s, p.substring(2)))); 
        } else {
            return match && isMatch(s.substring(1), p.substring(1));
        }
        */
        
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()] = true;
        
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length()-1; j >= 0; j--) {
                boolean match = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
                
                if (j+1 < p.length() && p.charAt(j+1) == '*') {
                    dp[i][j] = dp[i][j+2] || match && dp[i+1][j];
                } else {
                    dp[i][j] = match && dp[i+1][j+1];
                }
            }
        }
        
        return dp[0][0];
    }
}

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            String p = stringToString(line);
            
            boolean ret = new Solution().isMatch(s, p);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}
