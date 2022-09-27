package RecursionQuestions.Backtracking;

import java.util.ArrayList;

public class MazePath {
    public static void main(String[] args){
        printPath("", 3, 3);

        System.out.println(returnPath("", 3, 3));
    }

    static void printPath(String p, int row, int col){
        // base condition
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }

        // function body + recursive calls
        if(row > 1){
            printPath(p + 'D', row-1, col);
        }

        if(col > 1){
            printPath(p + 'R', row, col-1);
        }

    }

    static ArrayList<String> returnPath(String p, int row, int col){
        // base condition
        if(row == 1 && col == 1){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        // function body
        ArrayList<String> ans = new ArrayList<>();

        if(row > 1){
            ans.addAll(returnPath(p+"D", row-1, col));
        }
        if(col > 1){
            ans.addAll(returnPath(p+"R", row, col-1));
        }

        return ans;
    }
}
