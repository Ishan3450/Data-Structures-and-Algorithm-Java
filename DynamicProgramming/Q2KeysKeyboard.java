package DynamicProgramming;

import java.util.Arrays;

public class Q2KeysKeyboard {
    public int minSteps(int n) {
        // return recursive(n, 1, 0);

        int[][] dp = new int[n][n];
        for(int[] row: dp) Arrays.fill(row, -1);

        return memoization(n, 1, 0, dp);
    }

    // memoization
    public int memoization(int n, int charactersOnScreen, int clipboard, int[][] dp){
        // base condition
        if(charactersOnScreen == n){
            return 0;
        }

        if(charactersOnScreen > n){
            return -1;
        }

        if(dp[charactersOnScreen][clipboard] != -1){
            return dp[charactersOnScreen][clipboard];
        }

        // function body
        
        // copy all the characters from the screen
        int copyAll = -1;

        // when clipboard size is same as characters on screen there is no sense of copying it again so no rec call for that
        if(clipboard != charactersOnScreen){
            copyAll = memoization(n, charactersOnScreen, charactersOnScreen, dp);
        }

        // append the clipboard on with the characters on screen
        int pasteClipboard = -1;

        // when clipboard size is 0 then also there is no sense of pasting on the screen with an empty clipboard
        if(clipboard != 0){
            pasteClipboard = memoization(n, charactersOnScreen + clipboard, clipboard, dp);
        }

        int ans = 0;
        if(copyAll == -1 && pasteClipboard == -1){
            ans = -1;
        } else if(copyAll == -1){
            ans = 1 + pasteClipboard;
        } else if(pasteClipboard == -1){
            ans = 1 + copyAll;
        } else {
            ans = 1 + Math.min(copyAll, pasteClipboard);
        }

        return dp[charactersOnScreen][clipboard] = ans;
    }

    // recursive
    public int recursive(int n, int charactersOnScreen, int clipboard){
        // base condition
        if(charactersOnScreen == n){
            return 0;
        }

        if(charactersOnScreen > n){
            return -1;
        }

        // function body
        
        // copy all the characters from the screen
        int copyAll = -1;

        // when clipboard size is same as characters on screen there is no sense of copying it again so no rec call for that
        if(clipboard != charactersOnScreen){
            copyAll = recursive(n, charactersOnScreen, charactersOnScreen);
        }

        // append the clipboard on with the characters on screen
        int pasteClipboard = -1;

        // when clipboard size is 0 then also there is no sense of pasting on the screen with an empty clipboard
        if(clipboard != 0){
            pasteClipboard = recursive(n, charactersOnScreen + clipboard, clipboard);
        }

        if(copyAll == -1 && pasteClipboard == -1){
            return -1;
        } else if(copyAll == -1){
            return 1 + pasteClipboard;
        } else if(pasteClipboard == -1){
            return 1 + copyAll;
        } else {
            return 1 + Math.min(copyAll, pasteClipboard);
        }
    }
}
