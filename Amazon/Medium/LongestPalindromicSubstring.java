public class LongestPalindromicSubstring {

    public static void longestPalSubstr(String s) {

        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {

            // Even length palindrome
            int l = i;
            int r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {

                if (r - l + 1 > maxLen) {
                    start = l;
                    maxLen = r - l + 1;
                }

                l--;
                r++;
            }

            // Odd length palindrome
            l = i - 1;
            r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {

                if (r - l + 1 > maxLen) {
                    start = l;
                    maxLen = r - l + 1;
                }

                l--;
                r++;
            }
        }

        System.out.println(s.substring(start, start + maxLen));
    }

    public static void main(String[] args) {

        String s = "babad";

        longestPalSubstr(s);
    }
}