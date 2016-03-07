package ultimate.bravery.task1;

/**
 * Created by anton on 07/03/2016.
 * <p>
 * use this exception when you detect a cycle in the tree you serialize
 */
public class InvalidBinaryTreeException extends Exception {
    public InvalidBinaryTreeException() {
        super();
    }
}
