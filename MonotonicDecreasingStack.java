import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MonotonicDecreasingStack {
    public static List<Integer> previousGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            // Remove elements smaller than current
            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
            }

            // Previous greater element (or -1 if none)
            if (!stack.isEmpty()) {
                result.add(stack.peek());
            } else {
                result.add(-1);
            }

            stack.push(num);
        }
        return result;
    }

    // If you want the actual monotonic decreasing stack
    public static List<Integer> getMonotonicDecreasingStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            // Remove elements smaller than current to maintain decreasing order
            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
            }
            stack.push(num);
        }

        return new ArrayList<>(stack); // Convert stack to list
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2 };

        List<Integer> prevGreater = previousGreaterElement(nums);
        System.out.println("Previous Greater Elements: " + prevGreater);

        List<Integer> monoStack = getMonotonicDecreasingStack(nums);
        System.out.println("Final Monotonic Decreasing Stack: " + monoStack);
    }
}