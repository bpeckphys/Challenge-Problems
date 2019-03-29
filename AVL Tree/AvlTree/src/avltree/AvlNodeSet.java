
package avltree;

public class AvlNodeSet {
    Integer value;
    Integer balanceFactor;
    
    AvlNodeSet leftChild;
    AvlNodeSet rightChild;
    
    public AvlNodeSet(int value){
        this.value = value;
        this.balanceFactor = 0;
    }
    
    public AvlNodeSet(){
        
    }
    
    boolean add(Integer input){
        if (value == null) {
            value = input;
            return true;
        }
        
        if (input == value) {
            return false;
        }
        
        if (input < value) {
            if (leftChild == null) {
                leftChild = new AvlNodeSet(input);
                return true;
            }
            
            return leftChild.add(input);
        }
        
        if (input > value) {
            if (rightChild == null) {
                rightChild = new AvlNodeSet(input);
                return true;
            }
            
            return rightChild.add(input);
        }
        
        return false;
    }
    
    boolean contains(Integer input){
        if (value == null) {
            return false;
        }
        
        if (input == value) {
            return true;
        }
        
        if (input < value) {
            if (leftChild == null) {
                return false;
            }
            
            return leftChild.contains(input);
        }
        
        if (input > value) {
            if (rightChild == null) {
                return false;
            }
            
            return rightChild.contains(input);
        }
        
        return false;
    }
    
    AvlNodeSet remove(int number){
        AvlNodeSet temp;
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
            leftChild = leftChild.remove(number);
            return this;
        }
        
        if (number > value) {
            rightChild = rightChild.remove(number);
            return this;
        }
        
        return balance();
    }
    
    AvlNodeSet secondDeepestLeftChild(){
        if (leftChild == null) {
            return this;
        }
        
        if (leftChild.leftChild == null) {
            return this;
        }
        
        return leftChild.secondDeepestLeftChild();
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
    
    public int maxHeight(AvlNodeSet avlNode){
        int leftHeight;
        int rightHeight;
        
        if (avlNode == null || avlNode.value == null) {
            return 0;
        }
        leftHeight = 1 + maxHeight(avlNode.leftChild);
        rightHeight = 1 + maxHeight(avlNode.rightChild);
        return Math.max(leftHeight, rightHeight);
    }
    
    AvlNodeSet rightRightPivot(){
        AvlNodeSet temp, temp2;
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
    
    AvlNodeSet rightLeftPivot(){
        AvlNodeSet temp;
        temp = rightChild.leftChild;
        rightChild.leftChild = null;
        temp.leftChild = this;
        temp.rightChild = rightChild;
        this.rightChild = null;
        return temp;
    }
    
    AvlNodeSet leftLeftPivot(){
        AvlNodeSet temp, temp2;
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
    
    AvlNodeSet leftRightPivot(){
        AvlNodeSet temp;
        temp = leftChild.rightChild;
        leftChild.rightChild = null;
        temp.rightChild = this;
        temp.leftChild = leftChild;
        this.leftChild = null;
        return temp;
    }
    
    public AvlNodeSet balance(){
        balanceFactor = getBalanceFactor();
//        System.out.println("Balance: Current node: " + this.value);
        if (leftChild == null && rightChild == null) {
//            System.out.println("Balance: No children");
            return this;
        }
        
        if (leftChild == null) {
//            System.out.println("Balance: No left child");
            rightChild = rightChild.balance();
        }
        
        if (rightChild == null) {
//            System.out.println("Balance: No right child");
            leftChild = leftChild.balance();
        }
        
        if (rightChild != null && leftChild != null) {
//            System.out.println("Balance: Both Children, recursing");
            leftChild = leftChild.balance();
            rightChild = rightChild.balance();
        }
        
        if (maxHeight(rightChild) > 1 + maxHeight(leftChild)) {
            // RL Pivot
            if (balanceFactor >= 2 && rightChild.balanceFactor == -1) {
//                System.out.println("Balance: Doing a right-left pivot on " + this.value);
                return rightLeftPivot();
            }
            
            // RR Pivot
//            System.out.println("Balance: Doing a right-right pivot on " + this.value);
            return rightRightPivot();
        }
        
        if (maxHeight(leftChild) > 1 + maxHeight(rightChild)) {
            // LR Pivot
            if (balanceFactor <= -2 && leftChild.balanceFactor == 1) {
//                System.out.println("Balance: Doing a left-right pivot on " + this.value);
                return leftRightPivot();
            }
            
            // LL Pivot
//            System.out.println("Balance: Doing a left-left pivot on " + this.value);
            return leftLeftPivot();
        }
        
        return this;
    }
    
}
