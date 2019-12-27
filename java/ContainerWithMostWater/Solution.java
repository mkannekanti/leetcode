/*

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

*/

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, i = 0, j = height.length - 1;
        
        while (i < j) {
            maxArea = Math.max(maxArea, (j - i)*Math.min(height[i], height[j]));
            if (height[i] > height[j])
                j--;
            else
                i++;
        }
        
        return maxArea;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] height = stringToIntegerArray(line);
            
            int ret = new Solution().maxArea(height);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
