package TrieDictionary.SampleBinaryTree;

public class BinaryTreeAccessor {

    public static void main(String args[]) {

        BinaryTreeNode root = new BinaryTreeNode(7);    //because I want it to be 7, OK?

        System.out.println("find 7: " + root.findNumber(7));
        System.out.println("find 10: " + root.findNumber(10));

        System.out.println("added 10");
        root.addNumber(10);

        System.out.println("find 10: " + root.findNumber(10));

        root.addNumber(4);
        root.addNumber(5);
        root.addNumber(6);

        root.addNumber(2);
        root.addNumber(1);
        root.addNumber(3);

        //draw out what the tree looks like at this point.  do any functions here you want so you understand how add and search works recursively.



    }
}
