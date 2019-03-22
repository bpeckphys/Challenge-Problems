/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author bpeck
 */
public class AvlNode implements AvlNodeInterface{
    
    Integer value;
    Integer balanceFactor;
    
    AvlNode leftChild = null;
    AvlNode rightChild = null;
    
    
    public AvlNode(int value){
        this.value = value;
        this.balanceFactor = 0;
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
        AvlNode temp;
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
            
            if (rightChild.leftChild == null) {
                rightChild.leftChild = leftChild;
                return rightChild;
            }
            
            temp = rightChild.secondDeepestLeftChild().leftChild;
            if (rightChild.secondDeepestLeftChild().leftChild.rightChild == null) {
                rightChild.secondDeepestLeftChild().leftChild = null;
            } else {
                rightChild.secondDeepestLeftChild().leftChild = rightChild.secondDeepestLeftChild().leftChild.rightChild;
            }
            
            temp.leftChild = leftChild;
            temp.rightChild = rightChild;
            return temp;
        }
        
        if (number < value) {
//            System.out.println(number + " is less than " + value);
            leftChild = leftChild.remove(number);
            return this;
        }
        
        if (number > value) {
//            System.out.println(number + " is greater than " + value);
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
//        System.out.println("MaxHeight Left " + avlNode.value + " is " + leftHeight);
//        System.out.println("MaxHeight Right " + avlNode.value + " is " + rightHeight);
        
        return Math.max(leftHeight, rightHeight);
    }
    
    AvlNode rightRightPivot(){
        AvlNode temp, temp2;
        temp = rightChild;
        if (rightChild.leftChild == null) {
            rightChild.leftChild = this;
            rightChild = null;
            return temp;
        }
        
        temp2 = rightChild.leftChild;
        rightChild.leftChild = this;
        rightChild = temp2;
        return temp;
    }
    
    AvlNode rightLeftPivot(){
        AvlNode temp;
        temp = rightChild.leftChild;
        rightChild.leftChild = null;
        temp.leftChild = this;
        temp.rightChild = rightChild;
        this.rightChild = null;
        return temp;
    }
    
    AvlNode leftLeftPivot(){
        AvlNode temp, temp2;
        temp = leftChild;
        if (leftChild.rightChild == null) {
            leftChild.rightChild = this;
            leftChild = null;
            return temp;
        }
        
        temp2 = leftChild.rightChild;
        leftChild.rightChild = this;
        leftChild = temp2;
        return temp;
    }
    
    AvlNode leftRightPivot(){
        AvlNode temp;
        temp = leftChild.rightChild;
        leftChild.rightChild = null;
        temp.rightChild = this;
        temp.leftChild = leftChild;
        this.leftChild = null;
        return temp;
    }
    
    AvlNode secondDeepestLeftChild(){
        if (leftChild == null) {
            return this;
        }
        
        if (leftChild.leftChild == null) {
            return this;
        }
        
        return leftChild.secondDeepestLeftChild();
    }
    
    AvlNode deepestRightChild(){
        if (rightChild == null) {
            return this;
        }
        
        return rightChild.deepestRightChild();
    }
    
    public Integer getBalanceFactor(){
        if (rightChild == null && leftChild == null) {
            return 0;
        }
        
        if (rightChild == null) {
            if (leftChild.leftChild == null && leftChild.rightChild == null) {
                return -1;
            }
            
            return -2;
        }
        
        if (leftChild == null) {
            if (rightChild.leftChild == null && rightChild.rightChild == null) {
                return 1;
            }
            
            return 2;
        }
        
        if (rightChild.leftChild == null && rightChild.rightChild == null) {
            if (leftChild.leftChild == null && leftChild.rightChild == null) {
                return 0;
            }
            
            return -1;
        }
        
        if (leftChild.leftChild == null && leftChild.rightChild == null) {
            if (rightChild.leftChild == null && rightChild.rightChild == null) {
                return 0;
            }
            
            return 1;
        }
        
        return 0;
    }
    
    // TODO: Test this
    public AvlNode balance(){
        balanceFactor = getBalanceFactor();
        System.out.println("Balance: Current node: " + this.value);
        if (leftChild == null && rightChild == null) {
            System.out.println("Balance: No children");
            return this;
        }
        
        if (leftChild == null) {
            System.out.println("Balance: No left child");
            rightChild = rightChild.balance();
        }
        
        if (rightChild == null) {
            System.out.println("Balance: No right child");
            leftChild = leftChild.balance();
        }
        
        if (rightChild != null && leftChild != null) {
            System.out.println("Balance: Both Children, recursing");
            leftChild = leftChild.balance();
            rightChild = rightChild.balance();
        }
        
        // Right Pivot
        if (maxHeight(rightChild) > 1 + maxHeight(leftChild)) {
            // RL Pivot
            if (balanceFactor >= 2 && rightChild.balanceFactor == -1) {
                System.out.println("Balance: Doing a right-left pivot on " + this.value);
                return rightLeftPivot();
            }
            
            // RR Pivot
            System.out.println("Balance: Doing a right-right pivot on " + this.value);
            return rightRightPivot();
        }
        
        if (maxHeight(leftChild) > 1 + maxHeight(rightChild)) {
            // LR Pivot
            if (balanceFactor <= -2 && leftChild.balanceFactor == 1) {
                System.out.println("Balance: Doing a left-right pivot on " + this.value);
                return leftRightPivot();
            }
            
            // LL Pivot
            System.out.println("Balance: Doing a left-left pivot on " + this.value);
            return leftLeftPivot();
        }
        
        return this;
    }
    
    public void printTreeBF(){
        Queue<AvlNode> printQueue = new LinkedList<>();
        
        if (this == null) {
            return;
        }
        
        printQueue.add(this);
        
        while (!printQueue.isEmpty()) {
            AvlNode currentNode = printQueue.peek();
            
            if (currentNode.leftChild == null && currentNode.rightChild == null) {
                System.out.println(" " + currentNode.value + " ");
                printQueue.remove();
                continue;
            }
            
            if (currentNode.leftChild == null) {
                printQueue.add(currentNode.rightChild);
                System.out.println(" " + currentNode.value + " ");
                printQueue.remove();
                continue;
            }
            
            if (currentNode.rightChild == null) {
                printQueue.add(currentNode.leftChild);
                System.out.println(" " + currentNode.value + " ");
                printQueue.remove();
                continue;
            }
            
            printQueue.add(currentNode.leftChild);
            printQueue.add(currentNode.rightChild);
            System.out.println(" " + currentNode.value + " ");
            printQueue.remove();
        }
        
    }
    
    // TODO: Implement this
    public void printTreeBFVisual() {
        int largestDigitNumber = deepestRightChild().value.toString().length();
        int breadthFactor = (int) Math.pow(2, maxHeight(this) - 1);
        int maxWidth = (int) breadthFactor * largestDigitNumber + (int) breadthFactor - 1;
        System.out.println("largestDigitNumber " + largestDigitNumber);
        System.out.println("breadthFactor " + breadthFactor);
        System.out.println("maxWidth " + maxWidth);
        int level = 1;
        int levelChars = (int) Math.pow(2, level - 1);
        int spacingWidth = maxWidth - levelChars * largestDigitNumber;
        String spacing = new String(new char[spacingWidth]).replace("\0", " ");
        String emptySpacing = new String(new char[largestDigitNumber]).replace("\0", " ");
        String padding = "";
        int count = 0;
        
        Queue<AvlNode> printQueue = new LinkedList<>();
        AvlNode emptyNode = new AvlNode(0);
        emptyNode.value = null;
        
        if (this == null) {
            return;
        }
        
        int valueLength;
        
        printQueue.add(this);
        System.out.print(spacing);
        
        while (!printQueue.isEmpty()) {
            AvlNode currentNode = printQueue.peek();
            valueLength = currentNode.value.toString().length();
            count++;
            System.out.println("Level " + level);
            System.out.println("Count " + count);
            System.out.println("Nodes on level: " + (int) Math.pow(2, level - 1));
            
            if (largestDigitNumber != valueLength) {
                padding = new String(new char[largestDigitNumber - valueLength]).replace(null," ");
            }
            
            if (count > Math.pow(2, level - 1)) {
                level++;
                System.out.println("Level increased to " + level);
                levelChars = (int) Math.pow(2, level - 1);
                spacingWidth = maxWidth - levelChars * largestDigitNumber;
                spacing = new String(new char[spacingWidth]).replace("\0", " ");
                System.out.print("\n" + spacing);
            }
            
            if (currentNode.leftChild == null && currentNode.rightChild == null && level < this.maxHeight(this)) {
                System.out.println("No child nodes so creating empty nodes");
                if (currentNode.value == null) {
                    System.out.print(emptySpacing + spacing);
                }
                if (currentNode.value != null) {
                    System.out.print(currentNode.value + spacing);
                }
                
                printQueue.add(emptyNode);
                printQueue.add(emptyNode);
                printQueue.remove();
                continue;
            }
            
            if (currentNode.leftChild == null && currentNode.rightChild == null) {
                System.out.println("No child nodes and final level");
                if (currentNode.value == null) {
                    System.out.print(emptySpacing + spacing);
                }
                if (currentNode.value != null) {
                    System.out.print(currentNode.value + spacing);
                }
                printQueue.remove();
                continue;
            }
            
            if (currentNode.leftChild == null && level < this.maxHeight(this)) {
                System.out.println("No left child node so creating an empty node");
                if (currentNode.value == null) {
                    System.out.print(emptySpacing + spacing);
                }
                if (currentNode.value != null) {
                    System.out.print(currentNode.value + spacing);
                }
                printQueue.add(emptyNode);
                printQueue.add(currentNode.rightChild);
                printQueue.remove();
                continue;
            }
            
            if (currentNode.leftChild == null) {
                System.out.println("No left child node and final level");
                if (currentNode.value == null) {
                    System.out.print(emptySpacing + spacing);
                }
                if (currentNode.value != null) {
                    System.out.print(currentNode.value + spacing);
                }
                printQueue.remove();
                continue;
            }
            
            if (currentNode.rightChild == null && level < this.maxHeight(this)) {
                System.out.println("No right child node so creating an empty node");
                if (currentNode.value == null) {
                    System.out.print(emptySpacing + spacing);
                }
                if (currentNode.value != null) {
                    System.out.print(currentNode.value + spacing);
                }
                printQueue.add(currentNode.leftChild);
                printQueue.add(emptyNode);
                printQueue.remove();
                continue;
            }
            
            if (currentNode.rightChild == null) {
                System.out.println("No right child node and final level");
                if (currentNode.value == null) {
                    System.out.print(emptySpacing + spacing);
                }
                if (currentNode.value != null) {
                    System.out.print(currentNode.value + spacing);
                }
                printQueue.remove();
                continue;
            }
            
            if (level < this.maxHeight(this)) {
                System.out.println("Adding child nodes to queue");
                if (currentNode.value == null) {
                    System.out.print(emptySpacing + spacing);
                }
                if (currentNode.value != null) {
                    System.out.print(currentNode.value + spacing);
                }
                printQueue.add(currentNode.leftChild);
                printQueue.add(currentNode.rightChild);
                printQueue.remove();
                continue;
            }
            
            System.out.println("Final level, no more nodes to add");
            if (currentNode.value == null) {
                System.out.print(emptySpacing + spacing);
            }
            
            if (currentNode.value != null) {
                System.out.print(currentNode.value + spacing);
            }
            
            printQueue.remove();
        }
        
        System.out.println("\n");
    }
    
    public void printTree(){
        if (value != null) {
            System.out.println("Root is: " + value);
        }
        
        if (leftChild != null) {
            System.out.println("Left Child is: " + leftChild.value);
            if (rightChild != null) {
                System.out.println("Right Child is: " + rightChild.value);
            } else {
                System.out.println("No Right Child");
            }
            leftChild.printTree();
        }
        
        if (rightChild != null) {
            System.out.println("Right Child is: " + rightChild.value);
            if (leftChild != null) {
                System.out.println("Left Child is: " + leftChild.value);
            } else {
                System.out.println("No Left Child");
            }
            rightChild.printTree();
        }
        
        if (rightChild == null && leftChild == null) {
            System.out.println("No more nodes");
        }
    }
}
