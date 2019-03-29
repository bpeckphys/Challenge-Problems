
package avltree;

import java.util.ArrayList;
import java.util.Collection;

public class AvlTreeSetTester {
    public static void main(String[] args) {
        AvlTreeSet avlTreeSet = new AvlTreeSet();
        
        System.out.println("-------------------------------------------");
        System.out.println("Testing Add");
        
        System.out.println("Adding 1 to tree: " + avlTreeSet.add(1));
        System.out.println("Adding 2 to tree: " + avlTreeSet.add(2));
        System.out.println("Adding 3 to tree: " + avlTreeSet.add(3));
        System.out.println("Adding 4 to tree: " + avlTreeSet.add(4));
        System.out.println("Adding 5 to tree: " + avlTreeSet.add(5));
        System.out.println("Adding 6 to tree: " + avlTreeSet.add(6));
        System.out.println("Adding 7 to tree: " + avlTreeSet.add(7));
        System.out.println("Adding 8 to tree: " + avlTreeSet.add(8));
        System.out.println("Adding 9 to tree: " + avlTreeSet.add(9));
        System.out.println("Adding 10 to tree: " + avlTreeSet.add(10));
        System.out.println("Adding 11 to tree: " + avlTreeSet.add(11));
        System.out.println("Adding 12 to tree: " + avlTreeSet.add(12));
        System.out.println("Adding 13 to tree: " + avlTreeSet.add(13));
        System.out.println("Adding 14 to tree: " + avlTreeSet.add(14));
        System.out.println("Adding 15 to tree: " + avlTreeSet.add(15));
        System.out.println("Adding 16 to tree: " + avlTreeSet.add(16));
        System.out.println("Adding 17 to tree: " + avlTreeSet.add(17));
        System.out.println("Adding 18 to tree: " + avlTreeSet.add(18));
        System.out.println("Adding 19 to tree: " + avlTreeSet.add(19));
        System.out.println("Adding 20 to tree: " + avlTreeSet.add(20));
        
        System.out.println("-------------------------------------------");
        System.out.println("Testing Contains");
        
        System.out.println("Checking if 1 is in the tree: " + avlTreeSet.contains(1));
        System.out.println("Checking if 2 is in the tree: " + avlTreeSet.contains(2));
        System.out.println("Checking if 3 is in the tree: " + avlTreeSet.contains(3));
        System.out.println("Checking if 4 is in the tree: " + avlTreeSet.contains(4));
        System.out.println("Checking if 5 is in the tree: " + avlTreeSet.contains(5));
        System.out.println("Checking if 6 is in the tree: " + avlTreeSet.contains(6));
        System.out.println("Checking if 7 is in the tree: " + avlTreeSet.contains(7));
        System.out.println("Checking if 8 is in the tree: " + avlTreeSet.contains(8));
        System.out.println("Checking if 9 is in the tree: " + avlTreeSet.contains(9));
        System.out.println("Checking if 10 is in the tree: " + avlTreeSet.contains(10));
        System.out.println("Checking if 11 is in the tree: " + avlTreeSet.contains(11));
        System.out.println("Checking if 12 is in the tree: " + avlTreeSet.contains(12));
        System.out.println("Checking if 13 is in the tree: " + avlTreeSet.contains(13));
        System.out.println("Checking if 14 is in the tree: " + avlTreeSet.contains(14));
        System.out.println("Checking if 15 is in the tree: " + avlTreeSet.contains(15));
        System.out.println("Checking if 16 is in the tree: " + avlTreeSet.contains(16));
        System.out.println("Checking if 17 is in the tree: " + avlTreeSet.contains(17));
        System.out.println("Checking if 18 is in the tree: " + avlTreeSet.contains(18));
        System.out.println("Checking if 19 is in the tree: " + avlTreeSet.contains(19));
        System.out.println("Checking if 20 is in the tree: " + avlTreeSet.contains(20));
        
        System.out.println("-------------------------------------------");
        System.out.println("Testing Clear and isEmpty");
        
        System.out.println("Clearing tree");
        avlTreeSet.clear();
        System.out.println("Checking if 1 is in the tree: " + avlTreeSet.contains(1));
        System.out.println("IsEmpty: " + avlTreeSet.isEmpty());
        System.out.println("Adding 1 to tree: " + avlTreeSet.add(1));
        System.out.println("IsEmpty: " + avlTreeSet.isEmpty());
        
        System.out.println("-------------------------------------------");
        System.out.println("Testing containsAll");
        Collection<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(6);
        System.out.println("Contains 1: " + avlTreeSet.contains(1));
        System.out.println("Contains 6: " + avlTreeSet.contains(6));
        
        System.out.println("Checking if list (1,6) is in the tree: " + avlTreeSet.containsAll(list));
        
        System.out.println("Adding 6 to tree: " + avlTreeSet.add(6));
        System.out.println("Checking if list (1,6) is in the tree: " + avlTreeSet.containsAll(list));
        
        System.out.println("-------------------------------------------");
        System.out.println("Testing add all");
        avlTreeSet.clear();
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        
        System.out.println("Adding list (1,2,3,4,5,6,7,8,9,10) to tree: " + avlTreeSet.addAll(list));
        System.out.println("Checking if list (1,2,3,4,5,6,7,8,9,10) is in the tree: " + avlTreeSet.containsAll(list));
        
        System.out.println("-------------------------------------------");
        System.out.println("Testing size");
        System.out.println("Size: " + avlTreeSet.size());
        System.out.println("Removing 5: " + avlTreeSet.remove(5));
        System.out.println("Size: " + avlTreeSet.size());
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(7);
        System.out.println("Removing list (1,3,7) from tree: " + avlTreeSet.removeAll(list));
        System.out.println("Size: " + avlTreeSet.size());
    }
}
