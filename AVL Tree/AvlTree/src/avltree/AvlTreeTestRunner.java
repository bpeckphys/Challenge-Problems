package avltree;

import java.io.File;
import java.util.Scanner;

public class AvlTreeTestRunner {


    public static void main(String args[]) {

        AvlTreeInterface avlTree = new AvlTree();

        File testingFile = new File("src/avlTree/tests.txt");
        System.out.println(testingFile.getAbsolutePath());
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
                    avlTree.add(Integer.parseInt(arguments[2]));
                    break;
                case "contains":
                    testEquality(avlTree.contains(Integer.parseInt(arguments[2])), Boolean.parseBoolean(arguments[3]), input);
                    break;
                case "delete":
                    avlTree.remove(Integer.parseInt(arguments[2]));
                    break;
                case "balanced":
                    testEquality(isBalanced(avlTree), true, input);
                    break;
                default:
                    //System.out.println(input);
                    avlTree = new AvlTree();
            }



        }
    }

    public static <T> void testEquality(T actual, T expected, String inputLine) {
        if(!actual.equals(expected)) {
            System.out.println("Test Failed, \"" + inputLine + "\" expected a return of \"" + expected + "\" instead returned \"" + actual + "\"");
        }
    }

    /**
     * An AVL tree is balanced if the heights of its left and right subtrees differ by at most one,
     * AND the subtrees themselves are balanced.
     */
    public static boolean isBalanced(AvlTreeInterface tree) {
        return isBalancedRec(tree.getRoot()) >= 0;
    }

    /**
     * Returns the height of the tree (x >= 0) if it is balanced, otherwise returns -1.
     * Doing it this way avoids recomputing the height at each level.
     */
    private static int isBalancedRec(AvlNodeInterface tree) {
        if (tree == null)
        {
            return 0;
        }

        int leftHeight, rightHeight;

        // If either subtree is unbalanced, or the difference in their heights is > 1, then this tree is unbalanced.
        if (    (leftHeight = isBalancedRec(tree.getLeftChild()))  < 0
            || (rightHeight = isBalancedRec(tree.getRightChild())) < 0
            || Math.abs(leftHeight - rightHeight) > 1)
        {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

}
