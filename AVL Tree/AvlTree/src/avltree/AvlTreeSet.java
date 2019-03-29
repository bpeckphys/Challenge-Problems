
package avltree;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public class AvlTreeSet implements java.util.Set<Integer> {
    
    AvlNodeSet root; 
    int size;
    
    public AvlTreeSet(){
        root = null;
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return root == null || root.value == null;
    }

    @Override
    public boolean contains(Object input) {
        try {
            Integer inputValue = (Integer) input;
        } catch (ClassCastException ce) {
            System.out.println("Contains function input is not an Integer");
        }
        
        Integer inputValue = (Integer) input;
        if (root == null) {
            return false;
        }
        
        return root.contains(inputValue);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new AvlTreeSetIterator();
    }
    
    private class AvlTreeSetIterator<Integer> implements Iterator<Integer>{
        AvlNodeSet currentNode = root;
        Stack<AvlNodeSet> avlStack;
        
        public AvlTreeSetIterator(){
            avlStack = new Stack<AvlNodeSet>();
            
            while (currentNode != null) {
                avlStack.push(currentNode);
                currentNode = currentNode.leftChild;
            }
        }

        @Override
        public boolean hasNext() {
            return !avlStack.isEmpty();
        }

        @Override
        public Integer next() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Object[] arr = tree.toArray();
    
    // Object[] arr[0] = thing // write (any Object)
    // Object thing = arr[0] // read
    
    // Integer[] arr[0] = thing // write (Integer only!)
    // Object thing = arr[0] // read

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // caller
    // Tree<Integer> tree;
    // String[] arr;
    // ...
    // if (arr.type is not tree.array.supportedType())
    //    skip
    // tree.toArray(arr);

    @Override
    public boolean add(Integer input) {
        Integer inputValue = (Integer) input;
        
        if (root == null) {
            root = new AvlNodeSet(inputValue);
            size = 1;
            return true;
        }
        
        if (root.add(inputValue)) {
            size ++;
            return true;
        }
        
        return false;
    }

    @Override
    public boolean remove(Object input) {
        try {
            Integer inputValue = (Integer) input;
        } catch (ClassCastException ce) {
            System.out.println("Add function input is not an Integer");
        }
        
        Integer inputValue = (Integer) input;
        
        if (root == null) {
            return false;
        }
        if (root.contains(inputValue)) {
            root = root.remove(inputValue);
            if (root == null) {
                return false;
            }
            root = root.balance();
            size --;
            return true;
        }
        
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        boolean result = true;
        for (Object number: clctn) {
            try {
                Integer inputValue = (Integer) number;
            } catch (ClassCastException ce) {
                System.out.println("Add function input is not an Integer");
            }
            
            Integer inputValue = (Integer) number;
            
            if (!root.contains(inputValue)) {
                System.out.println("Tree does not contain: " + inputValue);
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> clctn) {
        boolean result = false;
        for (Object number: clctn) {
            try {
                Integer inputValue = (Integer) number;
            } catch (ClassCastException ce) {
                System.out.println("AddAll function input is not an Integer");
            }
            
            Integer inputValue = (Integer) number;
            if (root == null) {
                root = new AvlNodeSet();
                size = 0;
                result = true;
            }
            
            if (root.add(inputValue)) {
                result = true;
                size ++;
            }
        }
        
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        boolean result = false;
        for (Object number: clctn) {
            try {
                Integer inputValue = (Integer) number;
            } catch (ClassCastException ce) {
                System.out.println("Add function input is not an Integer");
            }
            
            Integer inputValue = (Integer) number;
            if (root == null) {
                System.out.println("Tree is empty, cannot remove " + inputValue);
                break;
            }
            
            if (root.contains(inputValue)) {
                root = root.remove(inputValue);
                root = root.balance();
                size --;
                result = true;
            }
        }
        
        return result;
    }

    @Override
    public void clear() {
        root = new AvlNodeSet();
        size = 0;
    }
    
}
