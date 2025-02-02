import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode40 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> KingList = combinationSum2(candidates, target);
        System.out.println(KingList);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        List<List<Integer>> KingList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[n];
        backTrack(KingList, list, candidates, used, target, 0);
        return KingList;
    }
    public static void backTrack(List<List<Integer>> KingList, List<Integer> list, int[] candidates, boolean[] used, int target, int counter){
        int n = candidates.length;
        if(counter >= n) return;
        if(target == 0){
            KingList.add(new ArrayList<>(list));
            return;
        }
        if(target < 0) return;
        for(int i = counter; i < n; i++){
            if(!used[i]){
                if(i>counter && candidates[i] == candidates[i-1] && used[i] == used[i-1]) continue;
                list.add(candidates[i]);
                used[i] = true;
                target -= candidates[i];
                backTrack(KingList, list, candidates, used, target, i);
                target += candidates[i];
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}
