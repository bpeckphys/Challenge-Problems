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
        return root.add(number);
    }
    
    @Override
    public boolean remove(int number){
        // TODO: implement
        return false;
    }
    
    @Override
    public boolean containsNode(int number){
        // TODO: implement
        return false;
    }
    
    @Override
    public void clearTree(){
        // TODO: implement
        
    }
    
    @Override
    public AvlNodeInterface getRoot(){
        // TODO: implement
        return this.root;
    }
    
}
