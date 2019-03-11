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
        if (value == null) {
            value = number;
            
            return true;
        }
        
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
    
    public boolean contains(int number){
        if (value == null) {
            return false;
        }
        
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
    
    AvlNode remove(int number){
        if (number == value) {
            if (leftChild == null && rightChild == null) {
                return null;
            }
            
            if (leftChild == null) {
                return rightChild;
            }
            
            if (rightChild == null) {
                return leftChild;
            }
            
            if (maxHeight(leftChild) > maxHeight(rightChild)) {
                if (leftChild.rightChild == null) {
                    return leftChild;
                }

                if (rightChild != null) {
                    deepestRightChild(leftChild).rightChild = rightChild;
                    return leftChild.balance();
                }
            }
            
            if (maxHeight(rightChild) > maxHeight(leftChild)) {
                if (rightChild.leftChild == null) {
                    return rightChild;
                }
                
                if (leftChild != null) {
                    deepestLeftChild(rightChild).leftChild = leftChild;
                    return rightChild.balance();
                }
            }
        }
        
        if (number < value) {
            System.out.println(number + " is less than " + value);
            leftChild = leftChild.remove(number);
            return this;
        }
        
        if (number > value) {
            System.out.println(number + " is greater than " + value);
            rightChild = rightChild.remove(number);
            return this;
        }
        
        return balance();
    }
    
    public int maxHeight(AvlNode avlNode){
        int leftHeight;
        int rightHeight;
        
        if (avlNode == null || avlNode.value == null) {
            return 0;
        }
        leftHeight = 1 + maxHeight(avlNode.leftChild);
        rightHeight = 1 + maxHeight(avlNode.rightChild);
        System.out.println("MaxHeight Left " + avlNode.value + " is " + leftHeight);
        System.out.println("MaxHeight Right " + avlNode.value + " is " + rightHeight);
        
        return Math.max(leftHeight, rightHeight);
    }
    
    // TODO: Test this
    AvlNode leftPivot(AvlNode node){
        AvlNode temp;
        
        if (rightChild == null) {
            return this;
        }
        
        if (rightChild.leftChild == null) {
            rightChild.leftChild = this;
            return rightChild;
        }
        
        temp = rightChild.leftChild;
        rightChild.leftChild = this;
        rightChild.leftChild.rightChild = temp;
        return rightChild;
    }
    
    // TODO: Test this
    AvlNode rightPivot(AvlNode node){
        AvlNode temp;
        
        if (leftChild == null) {
            return this;
        }
        
        if (leftChild.rightChild == null) {
            leftChild.rightChild = this;
            return leftChild;
        }
        
        temp = leftChild.rightChild;
        leftChild.rightChild = this;
        leftChild.rightChild.leftChild = temp;
        return leftChild;
    }
    
    AvlNode deepestRightChild(AvlNode node){
        if (node.rightChild == null) {
            return this;
        }
        
        return deepestRightChild(node.rightChild);
    }
    
    AvlNode deepestLeftChild(AvlNode node){
        if (node.leftChild == null) {
            return this;
        }
        
        return deepestLeftChild(node.leftChild);
    }
    
    // TODO: Test this
    public AvlNode balance(){
        if (leftChild == null && rightChild == null) {
            return this;
        }
        
        if (leftChild == null) {
            rightChild = rightChild.balance();
        }
        
        if (rightChild == null) {
            leftChild = leftChild.balance();
        }
        
        if (leftChild != null && rightChild != null) {
            leftChild = leftChild.balance();
            rightChild = rightChild.balance();
        }
        
        if (maxHeight(leftChild) - maxHeight(rightChild) > 1) {
            System.out.println("     doing a right pivot");
            return rightPivot(this);
        }
        
        if (maxHeight(rightChild) - maxHeight(leftChild) > 1) {
            System.out.println("     doing a left pivot");
            return leftPivot(this);
        }
        
        return this;
    }
    
    public void printTree(AvlNode node){
        if (node.value != null) {
            System.out.println("Root is: " + node.value);
        }
        
        if (node.leftChild != null) {
            System.out.println("Left Child is: " + node.leftChild.value);
            printTree(node.leftChild);
        }
        
        if (node.rightChild != null) {
            System.out.println("Right Child is: " + node.rightChild.value);
            printTree(node.rightChild);
        }
        
        if (node.rightChild == null && node.leftChild == null) {
            System.out.println("No more nodes");
        }
    }
}
