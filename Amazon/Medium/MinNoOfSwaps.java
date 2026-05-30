public class MinNoOfSwaps {

    static int solve(String s, char expected) {

        int mismatch = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != expected) {
                mismatch++;
            }

            expected = (expected == '0') ? '1' : '0';
        }

        return mismatch / 2;
    }

    static int minSwaps(String s) {

        int cnt0 = 0;
        int cnt1 = 0;

        for (char c : s.toCharArray()) {

            if (c == '0') cnt0++;
            else cnt1++;
        }

        // Impossible
        if (Math.abs(cnt0 - cnt1) > 1) {
            return -1;
        }

        // Equal count -> try both patterns
        if (cnt0 == cnt1) {
            return Math.min(
                solve(s, '0'),
                solve(s, '1')
            );
        }

        // More zeros
        else if (cnt0 > cnt1) {
            return solve(s, '0');
        }

        // More ones
        else {
            return solve(s, '1');
        }
    }

    public static void main(String[] args) {

        String s = "111000";

        System.out.println(minSwaps(s));
    }
}