package com.songyang.util.tree;

/**
 * @author Yang Song
 * @date 2022/7/30 14:17
 */
public class TestTreeNode {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        System.out.print("前序遍历:");
        preOrderPrint(a);
        System.out.println();
        System.out.print("后序遍历:");
        afterOrderPrint(a);
        System.out.println();
        System.out.print("中序遍历:");
        midOrderPrint(a);
    }
    /**
     * 深度优先 前序遍历
     * @param root 根节点
     */
    public static void preOrderPrint(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    /**
     * 深度优先 后序遍历
     * @param root 根节点
     */
    public static void afterOrderPrint(TreeNode root){
        if(root == null){
            return;
        }
        afterOrderPrint(root.left);
        afterOrderPrint(root.right);
        System.out.print(root.val+" ");
    }
    /**
     * 深度优先 中序遍历
     * @param root 根节点
     */
    public static void midOrderPrint(TreeNode root){
        if(root == null){
            return;
        }
        midOrderPrint(root.left);
        System.out.print(root.val+" ");
        midOrderPrint(root.right);
    }

}
