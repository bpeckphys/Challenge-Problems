public interface AvlNodeInterface {


    AvlNodeInterface getLeftChild();

    AvlNodeInterface getRightChild();

    boolean add(int number);

    boolean remove(int number);

    boolean contains(int number);

}
