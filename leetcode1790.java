public class leetcode1790 {
    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true; // Already equal
        
        int first = -1, second = -1;
        int diffCount = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 2) return false; // More than one swap needed
                
                if (first == -1) {
                    first = i; 
                } else {
                    second = i;
                }
            }
        }
        
        return diffCount == 2 && 
               s1.charAt(first) == s2.charAt(second) && 
               s1.charAt(second) == s2.charAt(first);
    }
    public static void main(String[] args) {
        String s1 = "bank";
        String s2 = "kanb";
        System.out.println(areAlmostEqual(s1, s2));
    }
}
