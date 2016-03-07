package ultimate.bravery.task1;

/**
 * Created by anton on 07/03/2016.
 * <p>
 * This is the Binary Tree Interface
 * <p>
 * assume the data type will always be String
 */
public interface BinaryTree<T> {

    T getData();

    BinaryTree<T> getLeft();

    void setLeft(BinaryTree<T> left);

    BinaryTree<T> getRight();

    void setRight(BinaryTree<T> right);

}
