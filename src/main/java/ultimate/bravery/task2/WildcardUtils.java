package ultimate.bravery.task2;

/**
 * Created by anton on 08/03/2016.
 * <p>
 * in this task - write a parser for the wildcard language described below
 * but don't use regex or external libraries :)
 * <p>
 * don't forget about greediness, use the unit tests to test your code
 */
public class WildcardUtils {
    /**
     * a simple wildcard matcher predicate.
     * <p>
     * in wildcard - all characters are what they are with the following exceptions:
     * 1) * (star) means zero or more matches
     * 2) ? (question mark) means a single match of any character
     * 3) \* (star escaped by a backslash) means *
     * 4) \? (question mark escaped by a backslash) means ?
     * these are additive, i.e. ** means zero or more matches and \*\? means *?
     *
     * @param target  the string contains the data to test the predicate upon
     * @param pattern the wildcard pattern adhering to the rules above
     * @return true if the predicate matches, false if it's not
     */
    public static boolean match(String target, String pattern) {
        return false; //TODO:
    }
}
