/*
Book Store
To try and encourage more sales of different books from a popular 5 book
series, a bookshop has decided to offer discounts on multiple book purchases.

One copy of any of the five books costs $8.

If, however, you buy two different books, you get a 5%
discount on those two books.

If you buy 3 different books, you get a 10% discount.

If you buy 4 different books, you get a 20% discount.

If you buy all 5, you get a 25% discount.

Note: that if you buy four books, of which 3 are
different titles, you get a 10% discount on the 3 that
form part of a set, but the fourth book still costs $8.

Your mission is to write a piece of code to calculate the
price of any conceivable shopping basket (containing only
books of the same series), giving as big a discount as
possible.

For example, how much does this basket of books cost?

2 copies of the first book
2 copies of the second book
2 copies of the third book
1 copy of the fourth book
1 copy of the fifth book
One way of grouping these 8 books is:

1 group of 5 --> 25% discount (1st,2nd,3rd,4th,5th)
+1 group of 3 --> 10% discount (1st,2nd,3rd)
This would give a total of:

5 books at a 25% discount
+3 books at a 10% discount
Resulting in:

5 x (8 - 2.00) == 5 x 6.00 == $30.00
+3 x (8 - 0.80) == 3 x 7.20 == $21.60
For a total of $51.60

However, a different way to group these 8 books is:

1 group of 4 books --> 20% discount (1st,2nd,3rd,4th)
+1 group of 4 books --> 20% discount (1st,2nd,3rd,5th)
This would give a total of:

4 books at a 20% discount
+4 books at a 20% discount
Resulting in:

4 x (8 - 1.60) == 4 x 6.40 == $25.60
+4 x (8 - 1.60) == 4 x 6.40 == $25.60
For a total of $51.20

And $51.20 is the price with the biggest discount.

*/

class Solution {
    List<HashSet<Integer>> buckets;
    public double maxDiscount = 0;
    public double[] discounts = {0, 0, 0.8, 2.4, 6.4, 10};
    
    public HashSet<Integer> findBestBucket(int num) {
        double discount = maxDiscount;
        HashSet<Integer> maxDiscountBucket = null;
        
        for (HashSet<Integer> bucket : buckets) {
            if (!bucket.contains(num)) {
                int size = bucket.size();
                double newDiscount = maxDiscount - discounts[size] + discounts[size+1];
                if (newDiscount > discount) {
                    discount = newDiscount;
                    maxDiscountBucket = bucket;
                }
            }
        }
        maxDiscount = discount;
        return maxDiscountBucket;
    }
    
    public double findMaxDiscount(int[] nums) {
        buckets = new LinkedList<HashSet<Integer>>();
        
        Arrays.sort(nums);
        for (int num : nums) {
            HashSet<Integer> bucket = findBestBucket(num);
            if (bucket == null) {
                bucket = new HashSet<Integer>();
                buckets.add(bucket);
            }
            bucket.add(num);
        }
        
        return (8*nums.length) - maxDiscount;
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
            
            double ret = new Solution().findMaxDiscount(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
