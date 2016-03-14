package ultimate.bravery.task3;

import java.util.Objects;

/**
 * Created by anton on 14/03/2016.
 * fun for the whole family
 */
public class InternationalizationPredicate {
    /**
     * this is a speed run, make sure you finish this task in under 40 minutes
     *
     *
     * please write a utility class to handle abbreviated non numeric text (text without numbers) by using the following rules:
     * all characters represent their value as-is.
     * numbers represent the number of characters skipped from the original non numeric text.

     * the predicate function equals returns true if the given text representation provided in the constructor
     * can be written in the second form provided in the single string parameter.
     * for example: new InternationalizationPredicate("internationalization").equals("i18n")
     *
     * make sure your hashCode is doing it's best while still being true to java's constraints:
     * equal items must have same hash code, non equal items should have different hashCodes.
     * equals should be symmetric, reflexive and transitive.
     *
     * don't use StringUtils or any external library, use Java 7 syntax.
     */

    /**
     * this constructor receives both strings and i18n abbreviated format
     * Note: normal text won't have numbers in it!
     *
     * @param text i18n abbreviated text
     */
    public InternationalizationPredicate(String text) {
        //TODO:
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternationalizationPredicate that = (InternationalizationPredicate) o;

        return false; //TODO:
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(0); //TODO:
    }
}
