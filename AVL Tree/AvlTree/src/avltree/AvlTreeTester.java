/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

/**
 *
 * @author bpeck
 */
public class AvlTreeTester {
    
    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree();
        
        System.out.println("-------------------------------------------");
        System.out.println("Testing add and contains\n");
        
        System.out.println("Tree contains 3: " + avlTree.contains(3));
        System.out.println("Adding 3 to tree: " + avlTree.add(3));
        System.out.println("Tree contains 3: " + avlTree.contains((3)));
        System.out.println("Adding 3 to tree: " + avlTree.add(3));
        System.out.println("Tree contains 2: " + avlTree.contains(2));
        System.out.println("Adding 2 to tree: " + avlTree.add(2));
        System.out.println("Tree contains 2: " + avlTree.contains(2));
        System.out.println("Tree contains 3: " + avlTree.contains((3)));
        
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing adding and balancing\n");
        System.out.println("Adding 7 to tree: " + avlTree.add(7));
//        avlTree.root.printTree();
        avlTree.root.printTreeBFVisual();
        System.out.println("Adding 8 to tree: " + avlTree.add(8));
//        avlTree.root.printTree();
        avlTree.root.printTreeBFVisual();
        System.out.println("Adding 9 to tree: " + avlTree.add(9));
//        avlTree.root.printTree();
        avlTree.root.printTreeBFVisual();
        System.out.println("Tree contains 9: " + avlTree.contains((9)));
        System.out.println("Adding 10 to tree: " + avlTree.add(10));
//        avlTree.root.printTree();
        avlTree.root.printTreeBFVisual();
        System.out.println("Adding 15 to tree: " + avlTree.add(15));
//        avlTree.root.printTree();
        avlTree.root.printTreeBFVisual();
        System.out.println("Adding 4 to tree: " + avlTree.add(4));
//        avlTree.root.printTree();
        avlTree.root.printTreeBFVisual();
        System.out.println("Adding 5 to tree: " + avlTree.add(5));
//        avlTree.root.printTree();
        avlTree.root.printTreeBFVisual();
        System.out.println("Adding 6 to tree: " + avlTree.add(6));
//        avlTree.root.printTree();
        avlTree.root.printTreeBFVisual();
        System.out.println("Adding 1 to tree: " + avlTree.add(1));
//        avlTree.root.printTree();
        avlTree.root.printTreeBFVisual();
        
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing heights\n");
        System.out.println("Max height is: " + avlTree.root.maxHeight(avlTree.root));
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing removing and contains\n");
        
//        System.out.println("Removing 5: " + avlTree.remove(5));
//        System.out.println("Tree contains 5: " + avlTree.contains(5));
//        avlTree.root.printTree(avlTree.root);
        
        System.out.println("Tree contains 3: " + avlTree.contains(3));
        System.out.println("Tree contains 1: " + avlTree.contains((1)));
        System.out.println("Tree contains 4: " + avlTree.contains(4));
        System.out.println("Removing 2: " + avlTree.remove(2));
//        avlTree.root.printTree();
        
        System.out.println("Removing 1: " + avlTree.remove(1));
        System.out.println("Removing 4: " + avlTree.remove(4));
//        avlTree.root.printTree();
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing clear\n");
        
        System.out.println("Clearing tree");
        avlTree.clearTree();
        System.out.println("Tree contains 3: " + avlTree.contains(3));
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing many adds\n");
        System.out.println("Adding 1 to tree: " + avlTree.add(1));
        System.out.println("Adding 2 to tree: " + avlTree.add(2));
        System.out.println("Adding 3 to tree: " + avlTree.add(3));
        System.out.println("Adding 4 to tree: " + avlTree.add(4));
        System.out.println("Adding 5 to tree: " + avlTree.add(5));
        System.out.println("Adding 6 to tree: " + avlTree.add(6));
        System.out.println("Adding 7 to tree: " + avlTree.add(7));
        System.out.println("Adding 8 to tree: " + avlTree.add(8));
        System.out.println("Adding 9 to tree: " + avlTree.add(9));
        System.out.println("Adding 10 to tree: " + avlTree.add(10));
        System.out.println("Adding 11 to tree: " + avlTree.add(11));
        System.out.println("Adding 12 to tree: " + avlTree.add(12));
        System.out.println("Adding 13 to tree: " + avlTree.add(13));
        System.out.println("Adding 14 to tree: " + avlTree.add(14));
        System.out.println("Adding 15 to tree: " + avlTree.add(15));
        System.out.println("Adding 16 to tree: " + avlTree.add(16));
        System.out.println("Adding 17 to tree: " + avlTree.add(17));
        System.out.println("Adding 18 to tree: " + avlTree.add(18));
        System.out.println("Adding 19 to tree: " + avlTree.add(19));
        System.out.println("Adding 20 to tree: " + avlTree.add(20));
//        avlTree.root.printTree();
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing more removes\n");
        System.out.println("Removing 8: " + avlTree.remove(8));
//        avlTree.root.printTree();
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing more removes\n");
        System.out.println("Removing 9: " + avlTree.remove(9));
//        avlTree.root.printTree();
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing more removes\n");
        System.out.println("Removing 16: " + avlTree.remove(16));
//        avlTree.root.printTree();
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing more removes\n");
        System.out.println("Removing 4: " + avlTree.remove(4));
//        avlTree.root.printTree();
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing more removes\n");
        System.out.println("Removing 5: " + avlTree.remove(5));
//        avlTree.root.printTree();
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing more removes\n");
        System.out.println("Removing 6: " + avlTree.remove(6));
//        avlTree.root.printTree();
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing more removes\n");
        System.out.println("Removing 2: " + avlTree.remove(2));
//        avlTree.root.printTree();
        
        System.out.println("\n-------------------------------------------");
        avlTree.root.printTree();
        
        System.out.println("\n-------------------------------------------");
        avlTree.root.printTreeBF();
    }
    
}
