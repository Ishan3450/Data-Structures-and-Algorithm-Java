package Trees;

public class Check2TreesAreIdenticalOrNot {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base conditions
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }

        // function body
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
