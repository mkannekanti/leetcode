/*

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

*/

class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0)
            return s;
        
        if (numRows == 1)
            return s;
        
        String result = new String();
        int maxGap = 2*(numRows - 1);
        int gap = 0, step = 0;
        int tmp = 0;

        while (tmp < s.length() && step < numRows) {
            result += s.charAt(tmp);
            gap = (maxGap - gap) % maxGap;
            tmp += (gap == 0)?maxGap:gap;
            
            if (tmp >= s.length()) {
                tmp = ++step;
                gap = 2*step % maxGap;
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
            line = in.readLine();
            int numRows = Integer.parseInt(line);
            
            String ret = new Solution().convert(s, numRows);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}
