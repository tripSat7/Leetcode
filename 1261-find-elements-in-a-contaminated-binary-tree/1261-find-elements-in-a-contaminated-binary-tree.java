/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {

    TreeNode troot = new TreeNode();
    public FindElements(TreeNode root) {
        
        troot = root;
        troot.val = 0;        
        helper(troot);
    }
    
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        
        if(root.left!=null){
            root.left.val = 2*root.val + 1;    
            helper(root.left);
        }
        if(root.right!=null){
            root.right.val = 2*root.val + 2;
            helper(root.right);
        }
    }
    
    public boolean find(int target) {
        
        return findHelper(troot, target);
    }
    
    public boolean findHelper(TreeNode root, int target){
        if(root == null){
            return false;
        }
        if(root.val == target){
            return true;
        }
        
        return (findHelper(root.left, target) || findHelper(root.right, target));
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */