import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
         String pattern = "aabca";
         String text = "accaabvbc";

        System.out.println(search(pattern, text));
    }

    public static int search(String pattern, String text) {
        int numberOfSubstrings = 0;
        int[] lsp = computeLspTable(pattern);
        System.out.println(Arrays.toString(lsp));

        int j = 0;  // Number of chars matched in pattern
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                // Fall back in the pattern
                j = lsp[j - 1];  // Strictly decreasing
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                // Next char matched, increment position
                j++;
                if (j == pattern.length()) {
//                    numberOfSubstrings++;
                    return i - (j - 1);
                }
            }
        }

        return -1;  // Not found
    }

    public static int[] computeLspTable(String pattern) {
        int[] lsp = new int[pattern.length()];
        lsp[0] = 0;  // Base case
        for (int i = 1; i < pattern.length(); i++) {
            // Start by assuming we're extending the previous LSP
            int j = lsp[i - 1];
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = lsp[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j))
                j++;
            lsp[i] = j;
        }
        return lsp;
    }
}
