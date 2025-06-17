import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicIncreasingStack {
    public static int[] monotonicIncreasing(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peekLast() > num) {
                stack.pollLast();
            }
            stack.offerLast(num);
        }
        int[] result = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[index--] = stack.pollLast();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2 };
        int[] result = monotonicIncreasing(nums);
        System.out.print("Monotonic increasing stack: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
