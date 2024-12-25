package DynamicProgramming;

import java.util.Arrays;

public class FillingBookcaseShelves {
    int WIDTH;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        // books[0] width
        // books[1] height
        WIDTH = shelfWidth;

        int[][] dp = new int[books.length][shelfWidth + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(books, shelfWidth, 0, 0, dp);
    }

    private int helper(int[][] books, int remWidth, int idx, int height, int[][] dp) {
        // base condition
        if (idx >= books.length) {
            return height;
        }

        if (dp[idx][remWidth] != -1) {
            return dp[idx][remWidth];
        }

        // function body
        int include = Integer.MAX_VALUE;
        if (books[idx][0] <= remWidth) {
            include = helper(books, remWidth - books[idx][0], idx + 1, Math.max(height, books[idx][1]), dp);
        }

        int exclude = height + helper(books, WIDTH - books[idx][0], idx + 1, books[idx][1], dp);

        return dp[idx][remWidth] = Math.min(include, exclude);
    }
}
