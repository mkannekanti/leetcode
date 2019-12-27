/*

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
             
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // if the string is null or empty then the longest is 0
        if (s == null || s.length() == 0)
            return 0;
        
        int result = 1;  // the result will be atleast 1 for non-empty strings
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // check if this character is repeated 
            if (set.contains(c)) {
                // if yes, we need to find which character is repeated and 
                // remove the items from the set
                for (; start < i; start++) {
                    if (s.charAt(start) == c) {
                        start++;
                        break;
                    } else {
                        set.remove(s.charAt(start));
                    }
                }
            } else {
                // if not, add to set and increase the length
                set.add(c);
                result = Math.max(result, set.size());
            }
        }
        return result;
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
            
            int ret = new Solution().lengthOfLongestSubstring(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
