/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import java.util.Scanner;
/**
 *
 * @author bpeck
 */
public class AvlTreeManualTester {
    
    public static void main(String[] args) {
        AvlTreeInterface avlTree = new AvlTree();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the AVL Tree Manual Tester Suite!\n");
        
        while(true) {
            System.out.println("Please enter a command: add, remove, contains, clear, getRoot, print, quit");
            String command = scanner.next().toLowerCase();
            int number;
            
            switch(command) {
                case "add":
                    System.out.println("Please enter a number to add");
                    number = scanner.nextInt();
                    if(avlTree.add(number)){
                        System.out.println("Added " + number + " to the tree");
                    } else {
                        System.out.println("Was not able to add " + number + " to the tree");
                    }
                    break;
                case "remove":
                    System.out.println("Please enter a number to remove");
                    number = scanner.nextInt();
                    if(avlTree.remove(number)){
                        System.out.println("Removed " + number + " from the tree");
                    } else {
                        System.out.println("Was not able to remove " + number + " from the tree");
                    }
                    break;
                case "contains":
                    System.out.println("Please enter a number to find");
                    number = scanner.nextInt();
                    if(avlTree.contains(number)){
                        System.out.println("The tree contains " + number);
                    } else {
                        System.out.println("Was not able to find " + number + " in the tree");
                    }
                    break;
                case "clear":
                    avlTree.clearTree();
                    System.out.println("Tree is now empty");
                    break;
                case "getroot":
                    System.out.println(avlTree.getRoot());
                    break;
                case "print":
                    avlTree.printTree();
                    break;
                case "quit":
                    System.out.println("Have a nice day!");
                    return;
                default:
                    System.out.println("Please enter a valid command");
            }
        }
    }
    
}
