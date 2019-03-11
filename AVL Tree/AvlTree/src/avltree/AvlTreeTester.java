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
        avlTree.root.printTree(avlTree.root);
        System.out.println("Adding 8 to tree: " + avlTree.add(8));
        avlTree.root.printTree(avlTree.root);
        
        
        // Current breakage
        System.out.println("Adding 9 to tree: " + avlTree.add(9));
        avlTree.root.printTree(avlTree.root);
        
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing heights\n");
        System.out.println("Max height is: " + avlTree.root.maxHeight(avlTree.root));
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing removing and contains\n");
        
        System.out.println("Removing 2: " + avlTree.remove(2));
        System.out.println("Tree contains 3: " + avlTree.contains((3)));
        System.out.println("Tree contains 2: " + avlTree.contains(2));
        System.out.println("Removing 2: " + avlTree.remove(2));
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Testing clear\n");
        
        System.out.println("Clearing tree");
        avlTree.clearTree();
        System.out.println("Tree contains 3: " + avlTree.contains(3));
    }
    
}
