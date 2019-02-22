package TrieDictionary.SampleBinaryTree;

public class BinaryTreeNode {

    int value;

    BinaryTreeNode leftChild = null;
    BinaryTreeNode rightChild = null;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public boolean addNumber(int num) {

        if(num == value) {
            return false;   //no duplicates in this implementation
        }

        if(num < value) {
            if(leftChild == null) {
                leftChild = new BinaryTreeNode(num);
                return true;
            }
            return leftChild.addNumber(num);
        } else {        //could I have left this else off? Yes, but it makes me feel safer having it here for readability
            if(rightChild == null) {
                rightChild = new BinaryTreeNode(num);
                return true;
            }
            return rightChild.addNumber(num);
        }

    }

    public boolean findNumber(int num) {
        if(num == value) {
            return true;
        }

        if(num < value) {
            if(leftChild == null) {
                return false;
            }
            return leftChild.findNumber(num);
        } else {
            if(rightChild == null) {
                return false;
            }
            return rightChild.findNumber(num);
        }
    }


}
