package ultimate.bravery.task2;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by anton on 08/03/2016.
 * <p>
 * use these unit tests to test your code
 */
public class WildcardUtilsTest extends TestCase {

    public void testMatch() throws Exception {
        Assert.assertTrue(WildcardUtils.match("a", "a"));
        Assert.assertFalse(WildcardUtils.match("b", "bc"));
        Assert.assertFalse(WildcardUtils.match("abc", "b"));
        Assert.assertTrue(WildcardUtils.match("prefix", "pre*"));
        Assert.assertTrue(WildcardUtils.match("suffix", "*fix"));
        Assert.assertTrue(WildcardUtils.match("multiple words", "*word*"));
        Assert.assertTrue(WildcardUtils.match("zero matches", "zero* *matches"));
        Assert.assertTrue(WildcardUtils.match("this is not regex", "this is not r?g?x"));
        Assert.assertFalse(WildcardUtils.match("a\\bc", "a\\*"));
        Assert.assertTrue(WildcardUtils.match("!@#$%^&*()", "!@#$%^&\\*()"));
        Assert.assertTrue(WildcardUtils.match("simple escaping test * ?", "simple escaping test \\* \\?"));
        Assert.assertTrue(WildcardUtils.match("complex escaping test \\* \\?", "complex escaping test \\\\* \\\\?"));
        Assert.assertTrue(WildcardUtils.match("schweinsteiger", "**steiger"));
        Assert.assertTrue(WildcardUtils.match("krankenwagen", "*****w???n"));
        Assert.assertTrue(WildcardUtils.match("greedy greedy test", "gr*edy gr*edy test"));
        Assert.assertTrue(WildcardUtils.match("greedy greedy test", "gr*edy test"));
    }
}