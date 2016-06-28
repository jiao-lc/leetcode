public class BSTIterator {

    private TreeNode current;

    public BSTIterator(TreeNode root) {
        current = threadAllNodesOnLeftMostBranch(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current != null;
    }

    /** @return the next smallest number */
    public int next() {
        int result = current.val;

        current = current.right;
        // If thread(current) returns false, it means that the left sub tree of current is visited.
        // So there's no need to call threadAllNodesOnLeftMostBranch on current.
        if (current != null && current.left != null && thread(current)) {
            // current is already threaded in the if statement, skip it.
            current = current.left;
            current = threadAllNodesOnLeftMostBranch(current);
        }

        return result;
    }

    // Thread all nodes on TreeNode root's left-most branch until it reaches the last node on the branch,
    // and return the last node
    private TreeNode threadAllNodesOnLeftMostBranch(TreeNode root) {
        while (root != null && root.left != null) {
               thread(root);
               root = root.left;
        }

        return root;
    }

    // Thread or unthread TreeNode root with its successor
    // Return true if the operation turns out as a threading, and false if unthreading.
    private boolean thread(TreeNode root) {
        TreeNode predecessor  = root.left;
        while (predecessor.right != null && predecessor.right != root) {
            predecessor = predecessor.right;
        }
        if (predecessor.right == null) {
            predecessor.right = root;
            return true;
        } else {
            predecessor.right = null;
            return false;
        }
    }
}