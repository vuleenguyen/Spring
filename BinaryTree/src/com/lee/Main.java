package com.lee;

import java.util.Stack;

public class Main {

    private static int maxDepth = 0;

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(9);
        root.insertLeft(8);
        root.insertRight(7);
        root.getLeft().insertLeft(6);
        root.getLeft().insertRight(5);
        root.getLeft().getLeft().insertLeft(2);
        root.getLeft().getLeft().insertRight(1);
        root.getRight().insertLeft(4);
        root.getRight().insertRight(3);

        boolean isSuperBalanced = checkSuperBalanced(root, 0);
        System.out.println(isSuperBalanced);
    }

//    public static boolean checkSuperBalanced(BinaryTreeNode currentNode, int currentDepth) {
//        boolean result = true;
//        if (currentNode != null) currentDepth++;
//
//        if (currentNode.left == null && currentNode.right == null) {
//            if (currentDepth < maxDepth - 1) return false;
//        }
//
//        maxDepth = Math.max(currentDepth, maxDepth);
//
//        if (currentNode.left != null) result = checkSuperBalanced(currentNode.left, currentDepth);
//        if (currentNode.right != null) result = checkSuperBalanced(currentNode.right, currentDepth);
//
//        return result;
//    }

    public static boolean checkSuperBalanced(BinaryTreeNode root) {
        if (root == null) return true;

        int currentDepth = 1;
        int maxDepth = Integer.MAX_VALUE;

        Stack<TreeNodePair> nodePairStack = new Stack<>();
        nodePairStack.push(new TreeNodePair(root, currentDepth));
        TreeNodePair nodePair = nodePairStack.pop();
        BinaryTreeNode currentNode = nodePair.getNode();
        
        while (currentNode != null) {
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {

            } else {
                currentDepth++;
                if (currentNode.getRight() != null) {
                    nodePairStack.push(new TreeNodePair(currentNode.getRight(), currentDepth));
                }

                if (currentNode.getLeft() != null) {
                    nodePairStack.push(new TreeNodePair(currentNode.getLeft(), currentDepth));
                }
            }

            nodePair = nodePairStack.pop();
            maxDepth = Math.max(nodePair.getDepth(), maxDepth);
            currentNode = nodePair.getNode();
        }

        return true;
    }
}

class TreeNodePair {
    public BinaryTreeNode node;
    public int depth;

    public TreeNodePair(BinaryTreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }

    public BinaryTreeNode getNode() {
        return node;
    }

    public void setNode(BinaryTreeNode node) {
        this.node = node;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
