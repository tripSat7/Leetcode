// TC: O(n^2), SC: O(n)

enum Index {
    GOOD,
    BAD,
    UNKNOWN,
}

public class Solution {

    Index[] memo; // memo[i] stores if index i is GOOD/BAD/UNKNOWN

    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD; // last index is always GOOD

        return canJumpFromPosition(0, nums); // start from index 0
    }

    public boolean canJumpFromPosition(int position, int[] nums) {
        // Return result if already computed
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }

        // Explore all next reachable positions
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD; // memoize and return
                return true;
            }
        }

        memo[position] = Index.BAD; // no valid path from here
        return false;
    }
}
