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
public class AvlTree implements AvlTreeInterface{
    
    AvlNode root;
    
    public AvlTree(){
        root = null;
    }
    
    @Override
    public boolean add(int number){
        if (root == null) {
            root = new AvlNode();
        }
        boolean result;
        result = root.add(number);
//        System.out.println("Added " + number + ": " + result + " Now balancing");
        
        root = root.balance();
        
        return result;
    }
    
    @Override
    public boolean remove(int number){
        if (root == null) {
            return false;
        }
        if (root.contains(number)) {
            root = root.remove(number);
            if (root == null) {
                return false;
            }
            root = root.balance();
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean contains(int number){
        if (root == null) {
            return false;
        }
        return root.contains(number);
    }
    
    @Override
    public void clearTree(){
        root = new AvlNode();
    }
    
    @Override
    public AvlNodeInterface getRoot(){
        return this.root;
    }
    
    @Override
    public void printTree(){
        root.printTree();
    }
    
}
