package com.lee;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

    }

    public static final String regularExpression = "[^a-zA-Z][a-zA-Z0-9_]{7,29}";

    public static boolean checkSuperBalanced(BinaryTreeNode root) {
        if (root == null) return true;

        BinaryTreePair binaryTreePair = new BinaryTreePair(root, 1);
        Stack<BinaryTreePair> stackTreePair = new Stack<>();
        stackTreePair.push(binaryTreePair);
        List<Integer> listCompare = new ArrayList<>(2);
        while (!stackTreePair.empty()) {
            if (Object instanceof )
            BinaryTreePair treePair = stackTreePair.pop();
            BinaryTreeNode node = treePair.node;
            int currentDepth = treePair.depth;

            if (node.left == null && node.right == null) {

                if (!listCompare.contains(currentDepth)) {
                    listCompare.add(currentDepth);

                    if (listCompare.size() == 2
                                && Math.abs(listCompare.get(0) - listCompare.get(1)) > 1) {
                        System.out.println(listCompare.get(0));
                        System.out.println(listCompare.get(1));
                        return false;
                    }

                    if (listCompare.size() == 2 &&
                            listCompare.get(0) > listCompare.get(1)) listCompare.remove(1);
                    else if (listCompare.size() == 2) listCompare.remove(0);
                }
            } else {
                currentDepth++;
                if (node.right != null) {
                    stackTreePair.push(new BinaryTreePair(node.right, currentDepth));
                }

                if (node.left != null) {
                    stackTreePair.push(new BinaryTreePair(node.left, currentDepth));
                }
            }
        }

        return true;
    }

    @Test
    public void test_Super_Balance_Test_Case_1() {
        BinaryTreeNode root = new BinaryTreeNode(9);
        root.insertLeft(7);
        root.insertRight(8);
        root.left.insertLeft(5);
        root.left.insertRight(6);
        root.left.left.insertLeft(3);
        root.left.left.insertLeft(4);

        boolean result = checkSuperBalanced(root);
        Assert.assertEquals(false, result);
    }

    @Test
    public void test_Super_Balance_Test_Case_2() {
        BinaryTreeNode root = new BinaryTreeNode(9);
        root.insertLeft(7);
        root.insertRight(8);
        root.left.insertLeft(5);
        root.left.insertRight(6);
        root.left.left.insertLeft(3);
        root.left.left.insertLeft(4);
        root.right.insertLeft(1);
        root.right.insertRight(2);

        boolean result = checkSuperBalanced(root);
        Assert.assertEquals(true, result);
    }

    @Test
    public void test_Super_Balance_Test_Case_3() {
        BinaryTreeNode root = new BinaryTreeNode(9);
        root.insertLeft(7);
        root.insertRight(8);
        root.left.insertLeft(5);
        root.left.insertRight(6);
        root.left.left.insertLeft(3);
        root.left.left.insertLeft(4);
        root.right.insertLeft(1);
        root.right.insertRight(2);
        root.left.right.insertLeft(10);
        root.left.right.insertRight(11);
        root.left.right.left.insertLeft(12);
        root.left.right.left.insertRight(13);

        boolean result = checkSuperBalanced(root);
        Assert.assertEquals(false, result);
    }
}
