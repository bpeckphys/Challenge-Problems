package avltree;

import java.io.File;
import java.util.Scanner;

public class AvlTreeTestRunner {


    public static void main(String args[]) {


        AvlNodeInterface avlTree = new AvlTree();

        File testingFile = new File("src/avlTree/tests.txt");
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


            if(avlTree == null) {
                System.out.println("Something has gone terribly wrong and we lost the reference to your tree.  You lose. Good day sir!");
                break;
            }
            
            if(arguments.length < 2) {
                continue;
            }
            System.out.println(input);

            switch(arguments[1]) {
                case "add":
                    avlTree = avlTree.add(Integer.parseInt(arguments[2]));
                    break;
                case "contains":
                    testEquality(avlTree.contains(Integer.parseInt(arguments[2])), Boolean.parseBoolean(arguments[3]), input);
                    break;
                case "delete":
                    avlTree = avlTree.remove(Integer.parseInt(arguments[2]));
                    break;
                case "balanced":
                    testEquality(maxHeight(avlTree) >= 0, true, input);
                    break;
                default:
                    //System.out.println(input);
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
        public AvlNodeInterface add(int number) {
            return null;
        }

        @Override
        public AvlNodeInterface remove(int number) {
            return null;
        }

        @Override
        public boolean contains(int number) {
            return false;
        }
    }

}