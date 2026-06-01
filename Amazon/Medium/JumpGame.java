import java.util.*;

public class JumpGame {

    static HashMap<Integer, Boolean> memo;

    static boolean helper(int[] nums, int i) {

        if (i >= nums.length - 1) return true;

        if (nums[i] == 0) return false;

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        for (int j = 1; j <= nums[i]; j++) {

            if (helper(nums, i + j)) {
                memo.put(i, true);
                return true;
            }
        }

        memo.put(i, false);

        return false;
    }

    static boolean canJump(int[] nums) {

        memo = new HashMap<>();

        return helper(nums, 0);
    }

    public static void main(String[] args) {

        int[] nums = {2,3,1,1,4};

        System.out.println(canJump(nums));
    }
}