package June2020;


public class June20 {

    public boolean isSymmetric2(TreeNode root) {

        if(root == null) {
            return true;
        }
        TreeNode root1 = root.left;
        TreeNode root2 = root.right;

        while (root.left != null && root.right != null) {

        }


        return false;
    }

    public boolean isSymmetric(TreeNode root) {

        if(root != null) {
            return isSymmetricCore(root.left, root.right);
        } else {
            return true;
        }
    }

    public static boolean isSymmetricCore(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }

        return (root1.val == root2.val) && isSymmetricCore(root1.left, root2.right)
                && isSymmetricCore(root1.right, root2.left);
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
