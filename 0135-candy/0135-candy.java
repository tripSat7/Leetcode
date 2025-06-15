//Time complexity : O(n)
//Space complexity : O(n)
public class Solution {
    public int candy(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];

        // Every child gets at least one candy
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);

        // Left to right: ensure higher rated child gets more candy than left neighbor
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }

        // Right to left: ensure higher rated child gets more candy than right neighbor
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }

        // Final candy count: take max from both directions for each child
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }

        return sum;
    }
}
