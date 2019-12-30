/*

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // -3, 0, 1, 2
        // -2 (-3,0,1)  
        // -1 (-3,0,2)
        // 0  (-3,1,2)
        // 3  (0,1,2)
                
        Arrays.sort(nums);
        int sum = 0, diff = 0, min = Integer.MAX_VALUE;
        int result = 0;
        
        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;
            
            while (j < k) {
                sum = nums[i]+nums[j]+nums[k];
                diff = Math.abs(sum - target);
            
                if (diff == 0) return sum;
                
                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                
                if (sum < target) j++; 
                else k--;
            }
        }
        
        return result;
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
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
            
            int ret = new Solution().threeSumClosest(nums, target);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
