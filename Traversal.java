import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()){
            while (cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!stack.empty()){
            TreeNode node = stack.pop();
            if (node != null){
                list.add(node.val);
                stack.add(node.right);
                stack.add(node.left);
            }
        }
        return list;
    }
}
