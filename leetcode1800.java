public class leetcode1800 {

    public static void main(String[] args) {
        int[] nums = {12,17,15,13,10,11,12};
        int ans = maxAscendingSum(nums);
        System.out.println(ans);
    }
    public static int maxAscendingSum(int[] nums) {
        int n = nums.length;
        if(n < 2) return nums[0];
        int maxSum = nums[0], tempSum = nums[0];
        for(int i = 1; i<n; i++){
            if(nums[i] <= nums[i-1]){
                if(maxSum >= tempSum)tempSum = maxSum;
                maxSum = nums[i];
            }else{
                maxSum += nums[i];
            }
        }
        return (maxSum>tempSum)?maxSum:tempSum;
    }
}