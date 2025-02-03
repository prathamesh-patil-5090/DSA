public class leetcode3105 {
    public static void main(String[] args) {
        int[] nums = {1,4,3,3,2};
        int result = longestMonotonicSubarray(nums);
        System.out.println(result);
    }
    public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int inc = 1, dec = 1, maxLen = 1;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++; 
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            } else {
                inc = 1; 
                dec = 1;
            }
            maxLen = Math.max(maxLen, Math.max(inc, dec));
        }

        return maxLen;
    }
}
