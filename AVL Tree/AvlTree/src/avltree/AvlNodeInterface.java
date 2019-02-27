package avltree;

public interface AvlNodeInterface {


    AvlNodeInterface getLeftChild();

    AvlNodeInterface getRightChild();

    AvlNodeInterface add(int number);

    AvlNodeInterface remove(int number);

    boolean contains(int number);

}
