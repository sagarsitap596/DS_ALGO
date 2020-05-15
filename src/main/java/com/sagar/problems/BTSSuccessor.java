package com.sagar.problems;

public class BTSSuccessor {

    public static void main(String[] args) {
        Node n_20 = new Node(20);
        Node n_9 = new Node(9);
        Node n_25 = new Node(25);
        Node n_5 = new Node(5);
        Node n_12 = new Node(12);
        Node n_11 = new Node(11);
        Node n_14 = new Node(14);

        n_20.left = n_9;
        n_20.right = n_25;
        n_20.parent = null;

        n_9.left = n_5;
        n_9.right = n_12;
        n_20.parent = n_20;

        n_25.parent = n_20;

        n_5.parent = n_9;

        n_11.parent = n_12;

        n_14.parent = n_12;

        n_12.left = n_11;
        n_12.right = n_14;
        n_12.parent = n_9;

        Node.BinarySearchTree bts = new Node.BinarySearchTree();
        bts.root = n_20;
        Node successor = bts.findInOrderSuccesor(new Node(5));

        System.out.println(successor.key);

    }

}

class Node {

    Node left;
    Node right;
    Node parent;
    int key;

    public Node(int key) {
        this.key = key;

    }

    static class BinarySearchTree {
        Node root;

        Node findInOrderSuccesor(Node inputNode) {

            Node successorr = null;

            Node currentNode = root;

            while (successorr == null) {

                if (inputNode.key < currentNode.key) {

                    if (currentNode.left == null && currentNode.key != inputNode.key) {
                        successorr = currentNode;
                    } else if (currentNode.left == null && currentNode.key == inputNode.key) {
                        successorr = currentNode.parent;
                    }
                    currentNode = currentNode.left;

                } else {
                    if (currentNode.right == null && currentNode.key != inputNode.key) {
                        successorr = currentNode;
                    } else if (currentNode.right == null && currentNode.key == inputNode.key) {
//                        if()
                        successorr = root;
                    }
                    currentNode = currentNode.right;
                }
            }

            if (successorr.key > inputNode.key) {
                return successorr;
            }
            return null;

        }
    }
}
