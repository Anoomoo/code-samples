import java.util.HashMap;

public class Main {
    public static boolean isIsomorphic(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        HashMap<Character, Character> forwardMap = new HashMap<>();
        HashMap<Character, Character> backwardMap = new HashMap<>();
        for (int i = 0 ; i < a.length; i++) {
            if (!forwardMap.containsKey(a[i])) {
                forwardMap.put(a[i], b[i]);
            } else {
                if (b[i] != forwardMap.get(a[i])) {
                    return false;
                }
            }
            if (!backwardMap.containsKey(b[i])) {
                backwardMap.put(b[i], a[i]);
            } else {
                if (a[i] != backwardMap.get(b[i])) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));

    }
}