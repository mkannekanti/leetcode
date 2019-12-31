/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

*/

class Solution {
    LinkedList<String> result = new LinkedList<>();
    HashMap<Character, String> keyPad = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    
    public void combine(String prefix, String next_digits) {        
        if (next_digits.length() == 0) {
            result.add(prefix);   
        } else {
            String keys = keyPad.get(next_digits.charAt(0));
            for (int i = 0; i < keys.length(); i++) {
                combine(prefix+keys.charAt(i), next_digits.substring(1));
            }
        }
        return;
    }
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            combine("", digits);
        
        return result;
    }
}

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String digits = stringToString(line);
            
            List<String> ret = new Solution().letterCombinations(digits);
            
            String out = stringListToString(ret);
            
            System.out.print(out);
        }
    }
}
