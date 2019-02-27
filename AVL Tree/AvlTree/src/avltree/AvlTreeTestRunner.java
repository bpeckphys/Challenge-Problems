package avltree;

import java.io.File;
import java.util.Scanner;

public class AvlTreeTestRunner {


    public static void main(String args[]) {


        AvlNodeInterface avlTree = new BlankAvl();

        File testingFile = new File("src/tests.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(testingFile);
        } catch(Exception e) {
            System.out.println("Test file was not found, check the file path and try again");
            return;
        }

        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] arguments = input.split(" ");
            if(arguments.length < 2) {
                System.out.println(input);
                continue;
            }

            switch(arguments[1]) {
                case "add":
                    testEquality(avlTree.add(Integer.parseInt(arguments[2])), Boolean.parseBoolean(arguments[3]), input);
                    break;
                case "contains":
                    testEquality(avlTree.contains(Integer.parseInt(arguments[2])), Boolean.parseBoolean(arguments[3]), input);
                    break;
                case "delete":
                    testEquality(avlTree.remove(Integer.parseInt(arguments[2])), Boolean.parseBoolean(arguments[3]), input);
                    break;
                case "balanced":
                    testEquality(maxHeight(avlTree) >= 0, true, input);
                    break;
                default:
                    System.out.println(input);
            }



        }
    }

    public static <T> void testEquality(T actual, T expected, String inputLine) {
        if(!actual.equals(expected)) {
            System.out.println("Test Failed, \"" + inputLine + "\" expected a return of \"" + expected + "\" instead returned \"" + actual + "\"");
        }
    }

    public static int maxHeight(AvlNodeInterface tree) {
        int leftHeight = tree.getLeftChild() == null? 0: maxHeight(tree.getLeftChild());
        int rightHeight = tree.getRightChild() == null? 0: maxHeight(tree.getRightChild());

        if(leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        return Math.abs(leftHeight - rightHeight) <=1 ? Math.max(leftHeight, rightHeight) : -1;
    }

    public static class BlankAvl implements AvlNodeInterface {

        @Override
        public AvlNodeInterface getLeftChild() {
            return null;
        }

        @Override
        public AvlNodeInterface getRightChild() {
            return null;
        }

        @Override
        public boolean add(int number) {
            return false;
        }

        @Override
        public boolean remove(int number) {
            return false;
        }

        @Override
        public boolean contains(int number) {
            return false;
        }
    }

}