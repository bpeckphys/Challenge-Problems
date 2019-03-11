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
        root = new AvlNode();
    }
    
    @Override
    public boolean add(int number){
        boolean result;
        result = root.add(number);
        
        root = root.balance();
        
        return result;
    }
    
    @Override
    public boolean remove(int number){
        if (root.contains(number)) {
            root = root.remove(number);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean contains(int number){
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
    
}
