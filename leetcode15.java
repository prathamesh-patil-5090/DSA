import java.util.*;

public class leetcode15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> KingList = threeSum(nums);
        System.out.println(KingList);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> KingList = new ArrayList<>();
        for(int k = 0; k < n-2; k++){
            if(k > 0 && nums[k] == nums[k-1]) continue;
            int i = k+1, j = n-1;
            while(i<j){
                if(nums[i]+nums[j]+nums[k] == 0){
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j]));
                    KingList.add(new ArrayList<>(list));
                    while(i < j && nums[i] == nums[i+1]) i++;
                    while(j > i && nums[j] == nums[j-1]) j--;
                    i++;
                    j--;
                }else if(nums[i]+nums[j]+nums[k] < 0) {
                    i++;
                }else{
                    j--;
                }
            }
        }
        return KingList;
    }
}
