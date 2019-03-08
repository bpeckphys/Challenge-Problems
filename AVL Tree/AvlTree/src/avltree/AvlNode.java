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
public class AvlNode implements AvlNodeInterface{
    
    Integer value;
    
    AvlNode leftChild = null;
    AvlNode rightChild = null;
    
    
    public AvlNode(int value){
        this.value = value;
    }
    
    public AvlNode(){
        
    }
    
    @Override
    public AvlNodeInterface getLeftChild(){
        if (leftChild == null) {
            return null;
        }
        
        return leftChild;
    }
    
    @Override
    public AvlNodeInterface getRightChild(){
        if (rightChild == null) {
            return null;
        }
        
        return rightChild;
    }
    
    boolean add(int number){
        if (number == value) {
            return false;
        }
        
        if (number < value) {
            if (leftChild == null) {
                leftChild = new AvlNode(number);
                return true;
            }
            return leftChild.add(number);
        }
        
        if (number > value) {
            if (rightChild == null) {
                rightChild = new AvlNode(number);
                return true;
            }
            return rightChild.add(number);
        }
        
        return false;
    }
    
    boolean remove(int number){
        if (number == value) {
            
            if (leftChild == null && rightChild == null) {
                this.value = null;
            }
            
            if (leftChild == null) {
                                
            }
        }
    }
    
}
