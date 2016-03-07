package ultimate.bravery.task1;

/**
 * Created by anton on 07/03/2016.
 * <p>
 * This is the Binary Tree Implementation
 * <p>
 * please write the missing part in the file only
 * <p>
 * do not change interfaces, make sure the unit tests pass after you complete the missing parts.
 * <p>
 * your task is to add a serializer and deserializer for this implementation.
 * <p>
 * read the code for additional guidance.
 */
public class BinaryTreeImpl<T> implements BinaryTree<T>, SpecialSerializer {
    private final T data;
    private BinaryTree<T> left = null;
    private BinaryTree<T> right = null;

    public BinaryTreeImpl(T data, BinaryTree<T> left, BinaryTree<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public BinaryTree<T> getLeft() {
        return left;
    }

    @Override
    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    @Override
    public BinaryTree<T> getRight() {
        return right;
    }

    @Override
    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

    @Override
    public String serialize() throws InvalidBinaryTreeException {
        //TODO:
        return null;
    }

    @Override
    public void deserializeInto(String serialized) throws InvalidBinaryTreeException {
        //TODO:
    }
}
