package study.AllTemplate.HouseRobber.ii;

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int prepre = nums[0];
        int pre = Math.max(nums[0], nums[1]);
        int cur = -1;
        for (int i = 2; i < nums.length; i++) {
            cur = Math.max(prepre + nums[i], pre);
            prepre = pre;
            pre = cur;
        }
        return cur;
    }
}