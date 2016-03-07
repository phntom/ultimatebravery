package ultimate.bravery.task1;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by anton on 07/03/2016.
 * <p>
 * use this unit tests to test your code
 */
public class BinaryTreeTest extends TestCase {

    private static void validateTree(BinaryTreeImpl<String> tree) throws InvalidBinaryTreeException {
        String serialized = tree.serialize();
        Assert.assertNotNull(serialized);
        BinaryTreeImpl<Object> deserialized = new BinaryTreeImpl<>(null, null, null);
        deserialized.deserializeInto(serialized);
        String reserialized = deserialized.serialize();
        Assert.assertEquals(serialized, reserialized);
    }

    public void testSanity() throws Exception {
        BinaryTree<String> child1 = new BinaryTreeImpl<>("leaf1", null, null);
        BinaryTree<String> child4 = new BinaryTreeImpl<>("leaf4", null, null);
        BinaryTree<String> child3 = new BinaryTreeImpl<>("child3", null, child4);
        BinaryTree<String> child2 = new BinaryTreeImpl<>("child2", child3, null);
        BinaryTreeImpl<String> stringBinaryTree = new BinaryTreeImpl<>("Root", child1, child2);
        validateTree(stringBinaryTree);
    }

    public void testTwoTrees() throws Exception {
        BinaryTreeImpl<String> node1 = new BinaryTreeImpl<>("node1", null, null);
        BinaryTreeImpl<String> root1 = new BinaryTreeImpl<>("root", node1, null);
        BinaryTreeImpl<String> root2 = new BinaryTreeImpl<>("root", null, node1);
        Assert.assertNotSame(root1.serialize(), root2.serialize());

        Assert.assertNotSame(
                new BinaryTreeImpl<>("v1", null, null).serialize(),
                new BinaryTreeImpl<>("v2", null, null).serialize()
        );
    }

    public void testRootOnly() throws Exception {
        validateTree(new BinaryTreeImpl<>("root", null, null));
    }

    public void testCycleDetection() throws Exception {
        BinaryTreeImpl<String> node1 = new BinaryTreeImpl<>("node1", null, null);
        BinaryTreeImpl<String> node2 = new BinaryTreeImpl<>("node2", node1, null);
        BinaryTreeImpl<String> node3 = new BinaryTreeImpl<>("node3", node2, null);
        BinaryTreeImpl<String> node4 = new BinaryTreeImpl<>("node4", node3, null);
        node1.setRight(node4);
        try {
            node2.serialize();
            Assert.fail();
        } catch (InvalidBinaryTreeException ignored) {
        }
    }

    public void testComplexTree() throws Exception {
        /**
         *     A
         *    / \
         *   B   C
         *  / \   \
         * D   E   F
         * \      / \
         *  G    H   I
         */

        BinaryTree<String> g = new BinaryTreeImpl<>("G", null, null);
        BinaryTree<String> h = new BinaryTreeImpl<>("H", null, null);
        BinaryTree<String> i = new BinaryTreeImpl<>("I", null, null);

        BinaryTree<String> d = new BinaryTreeImpl<>("D", null, g);
        BinaryTree<String> e = new BinaryTreeImpl<>("E", null, null);
        BinaryTree<String> f = new BinaryTreeImpl<>("F", h, i);

        BinaryTree<String> b = new BinaryTreeImpl<>("B", d, e);
        BinaryTree<String> c = new BinaryTreeImpl<>("C", null, f);

        BinaryTreeImpl<String> a = new BinaryTreeImpl<>("A", b, c);

        validateTree(a);
    }

    public void testReentrantcy() throws Exception {
        BinaryTreeImpl<String> n1 = new BinaryTreeImpl<>("n1", null, null);
        BinaryTreeImpl<String> n2 = new BinaryTreeImpl<>("n2", n1, null);
        BinaryTreeImpl<String> m2 = new BinaryTreeImpl<>("m2", n1, null);
        BinaryTreeImpl<String> n3 = new BinaryTreeImpl<>("n3", n2, null);
        BinaryTreeImpl<String> m3 = new BinaryTreeImpl<>("m3", n3, null);

        validateTree(m2);
        validateTree(m3);
        validateTree(n1);
        validateTree(n2);
        validateTree(n3);
        validateTree(m3);
        validateTree(m2);
        validateTree(m3);
    }
}