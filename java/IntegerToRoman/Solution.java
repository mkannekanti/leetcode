/*

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: 3
Output: "III"
Example 2:

Input: 4
Output: "IV"
Example 3:

Input: 9
Output: "IX"
Example 4:

Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

*/


class Solution {
    public String printRoman(int d, String tens, String fives, String ones) {
        String roman = "";
                
        if (d <= 3) {
            while (d > 0) { roman += ones; d--; }
        } else if (d == 4) {
            roman = ones + fives;
        } else if (d == 5) {
            roman = fives;
        } else if (d <= 8) {
            roman = fives;
            while (d-5 > 0) { roman += ones; d--; }
        } else if (d == 9) {
            roman = ones + tens;
        }
                
        return roman;
    }
    
    public String intToRoman(int num) {
        String result = "";
        int reminder = 0, dividend = 0;
        
        while (num > 0) {
            if (num >= 1000) {
                result += printRoman(num/1000, " ", " ", "M");
                num = num%1000;
            } else if (num >= 100) {
                result += printRoman(num/100, "M", "D", "C");
                num = num%100;
            } else if (num >= 10) {
                result += printRoman(num/10, "C", "L", "X");
                num = num%10;
            } else {
                result += printRoman(num, "X", "V", "I");
                return result;
            }
        }
        
        return result;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);
            
            String ret = new Solution().intToRoman(num);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}
