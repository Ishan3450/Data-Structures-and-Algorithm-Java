package Stack;

import java.util.Stack;

public class SimplifyPath {
    /*
     * types of paths, we are considering it as a miniPath:
     * /. -> ignore
     * / -> ignore
     * /dirName -> push it in the stack
     * /.. -> pop the top of the stack
     */

    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        int start = 0, end = start + 1;

        while (start < path.length()) {
            while (end < path.length() && path.charAt(end) != '/') {
                end++;
            }

            String miniPath = path.substring(start, end);
            System.out.println(miniPath);
            start = end;
            end = start + 1;

            if (miniPath.equals("/.") || miniPath.equals("/")) {
                continue;
            }

            if (miniPath.equals("/..") && !st.isEmpty()) {
                st.pop();
            } else if (!miniPath.equals("/..")) {
                st.push(miniPath);
            }

        }

        if (st.isEmpty()) {
            return "/";
        }

        String ans = new String("");
        while (!st.isEmpty()) {
            ans = st.pop() + ans;
        }
        return ans;
    }
}
