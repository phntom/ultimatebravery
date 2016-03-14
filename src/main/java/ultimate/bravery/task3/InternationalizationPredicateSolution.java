package ultimate.bravery.task3;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by anton on 14/03/2016.
 * <p>
 * <p>
 * this is my solution, don't peak until you're done :)
 */
public class InternationalizationPredicateSolution {
    /**
     * this is a speed run, make sure you finish this task in under 40 minutes
     * <p>
     * <p>
     * please write a utility class to handle abbreviated non numeric text (text without numbers) by using the following rules:
     * all characters represent their value as-is.
     * numbers represent the number of characters skipped from the original non numeric text.
     * <p>
     * the predicate function equals returns true if the given text representation provided in the constructor
     * can be written in the second form provided in the single string parameter.
     * for example: new InternationalizationPredicate("internationalization").equals("i18n")
     * <p>
     * make sure your hashCode is doing it's best while still being true to java's constraints:
     * equal items must have same hash code, non equal items should have different hashCodes.
     * equals should be symmetric, reflexive and transitive.
     * <p>
     * don't use StringUtils or any external library, use Java 7 syntax.
     */

    private static final Pattern numbers = Pattern.compile("[0-9]+");
    private static final Pattern tokenizer = Pattern.compile("([^0-9]*)([0-9]+)");
    private final String text;
    private final int fullLength;

    /**
     * this constructor receives both strings and i18n abbreviated format
     * Note: normal text won't have numbers in it!
     *
     * @param text i18n abbreviated text
     */
    public InternationalizationPredicateSolution(String text) {
        this.text = text;
        this.fullLength = extractTextLength(text);
    }

    private static void generateStubAndPattern(StringBuilder stub, StringBuilder pattern, String text) {
        Matcher tokenMatcher = tokenizer.matcher(text);
        int lengthProcessed = 0;
        while (tokenMatcher.find()) {
            String textPart = tokenMatcher.group(1);
            if (textPart != null && !textPart.isEmpty()) {
                lengthProcessed = generatePatternForTextPart(stub, pattern, lengthProcessed, textPart);
            }
            String numericPart = tokenMatcher.group(2);
            lengthProcessed += numericPart.length();
            int numericValue = Integer.valueOf(numericPart);
            for (int i = 0; i < numericValue; i++) {
                stub.append("0");
            }
            pattern.append(String.format(".{%d}", numericValue));
        }
        if (lengthProcessed < text.length()) {
            String rest = text.substring(lengthProcessed);
            generatePatternForTextPart(stub, pattern, lengthProcessed, rest);
        }
    }

    private static int generatePatternForTextPart(StringBuilder stub, StringBuilder pattern, int lengthProcessed, String textPart) {
        stub.append(textPart);
        for (int i = 0; i < textPart.length(); i++) {
            pattern.append("[").append(textPart.charAt(i)).append("0]");
        }
        lengthProcessed += textPart.length();
        return lengthProcessed;
    }

    private int extractTextLength(String text) {
        int fullLength = text.length();
        Matcher matcher = numbers.matcher(text);
        while (matcher.find()) {
            String number = matcher.group(0);
            fullLength -= number.length();
            fullLength += Integer.valueOf(number);
        }
        return fullLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternationalizationPredicateSolution that = (InternationalizationPredicateSolution) o;
        if (fullLength != that.fullLength) return false;

        StringBuilder thisStub = new StringBuilder(fullLength);
        StringBuilder thisPattern = new StringBuilder(fullLength);
        generateStubAndPattern(thisStub, thisPattern, text);

        StringBuilder thatStub = new StringBuilder(fullLength);
        StringBuilder thatPattern = new StringBuilder(fullLength);
        generateStubAndPattern(thatStub, thatPattern, that.text);

        return Pattern.matches(thisPattern.toString(), thatStub) && Pattern.matches(thatPattern.toString(), thisStub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullLength);
    }
}
