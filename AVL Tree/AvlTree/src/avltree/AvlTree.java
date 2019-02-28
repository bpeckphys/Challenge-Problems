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
public class AvlTree implements AvlNodeInterface {

    int value;
    
    AvlTree leftChild = null;
    AvlTree rightChild = null;
    
    public AvlTree(int value){
        this.value = value;
    }
    
    public AvlTree(){
        
    }
    
    @Override
    public AvlTree getLeftChild() {
        if (leftChild == null) {
            return null;
        }
        
        return leftChild;
    }
    
    @Override
    public AvlTree getRightChild() {
        if (rightChild == null) {
            return null;
        }
        
        return rightChild;
    }
    
    public AvlTree add(AvlTree avlNode) {
        if (avlNode.value < this.value) {
            if (leftChild == null) {
                leftChild = avlNode;
                return this;
            }
            leftChild = leftChild.add(avlNode);
        }
        
        if (avlNode.value > this.value) {
            if (rightChild == null) {
                rightChild = avlNode;
                return this;
            }
            
            rightChild = rightChild.add(avlNode);
        }
        
        return this;
    }
    
    @Override
    public AvlTree add(int number) {
        if (number == value) {
            return this;
        }
        
        if (number < value) {
            if (leftChild == null) {
                leftChild = new AvlTree(number);
                return this;
            }
            leftChild = leftChild.add(number);
        }
        
        if (number > value) {
            if (rightChild == null) {
                rightChild = new AvlTree(number);
                return this;
            }
            rightChild = rightChild.add(number);
        }
        
        return balanceTree();
    }
    
    @Override
    public AvlTree remove(int number) {
        if (number == value) {
            
            if (leftChild == null && rightChild == null) {
                return new AvlTree();
            }
            
            if (leftChild == null) {
                return rightChild;
            }
            
            if (rightChild == null) {
                return leftChild;
            }
            
            if (maxHeight(leftChild) >= maxHeight(rightChild)) {
                rightChild.add(leftChild.rightChild);
                return leftChild;
            }
            
            leftChild.add(rightChild.leftChild);
            return rightChild;
        }
        
        if (number < value) {
            if (leftChild == null) {
                return this;
            }
            
            leftChild = leftChild.remove(number);
        }
        
        if (number > value) {
            if (rightChild == null) {
                return this;
            }
            
            rightChild = rightChild.remove(number);
        }
        
        return balanceTree();
    }
    
    @Override
    public boolean contains(int number) {
        if (number == value) {
            return true;
        }
        
        if (number < value) {
            if (leftChild == null) {
                return false;
            }
            return leftChild.contains(number);
        }
        
        if (number > value) {
            if (rightChild == null) {
                return false;
            }
            return rightChild.contains(number);
        }
        
        return false;
    }
    
    public int maxHeight(AvlTree avlNode){
        int leftHeight;
        int rightHeight;
        
        if (avlNode == null) {
            leftHeight = 0;
        } else {
            leftHeight = maxHeight(avlNode.leftChild);
        }
        
        if (avlNode == null) {
            rightHeight = 0;
        } else {
            rightHeight = maxHeight(avlNode.rightChild);
        }
        
        return Math.max(leftHeight, rightHeight);
    }
    
    public AvlTree balanceTree() {
        if (leftChild == null && rightChild == null) {
            return null;
        }

        if (Math.abs(maxHeight(leftChild) - maxHeight(rightChild)) > 1) {
            if (maxHeight(leftChild) >= maxHeight(rightChild)) {
                leftChild.add(this);
                rightChild = rightChild.balanceTree();
                return leftChild;
            }
            
            rightChild.add(this);
            leftChild = leftChild.balanceTree();
            return rightChild;
        }
        
        return this;
    }
}
