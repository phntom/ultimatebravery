package ultimate.bravery.task3;

import junit.framework.TestCase;

import java.util.*;

/**
 * Created by anton on 14/03/2016.
 * fun fun fun
 */
public class InternationalizationPredicateTest extends TestCase {

    @SuppressWarnings("SpellCheckingInspection")
    List<List<InternationalizationPredicate>> entries = Arrays.asList(
            Arrays.asList(
                    new InternationalizationPredicate("internationalization"),
                    new InternationalizationPredicate("i18n"),
                    new InternationalizationPredicate("10n9"),
                    new InternationalizationPredicate("1n1e1n1t1o1a1i1a1i1n")
            ),
            Collections.singletonList(new InternationalizationPredicate("internati0nalization")),
            Collections.singletonList(new InternationalizationPredicate("r2dom words")),
            Collections.singletonList(new InternationalizationPredicate("to test the hash codes")),
            Collections.singletonList(new InternationalizationPredicate("variance"))
    );

    public void testEquals() throws Exception {
        List<InternationalizationPredicate> groupA = entries.get(0);
        List<InternationalizationPredicate> groupB = entries.get(1);
        for (InternationalizationPredicate a : groupA) {
            for (InternationalizationPredicate b : groupB) {
                assert !a.equals(b);
                assert !b.equals(a);
            }
        }
        for (InternationalizationPredicate a1 : groupA) {
            for (InternationalizationPredicate a2 : groupA) {
                assert a1.equals(a2);
            }
        }
    }

    public void testHashCode() throws Exception {
        List<InternationalizationPredicate> groupA = entries.get(0);
        List<InternationalizationPredicate> groupB = entries.get(1);
        for (InternationalizationPredicate a : groupA) {
            for (InternationalizationPredicate b : groupB) {
                assert a.hashCode() != b.hashCode();
            }
        }

        for (InternationalizationPredicate a1 : groupA) {
            for (InternationalizationPredicate a2 : groupA) {
                assert a1.hashCode() == a2.hashCode();
            }
        }

        Set<Integer> bucket = new HashSet<>();
        for (List<InternationalizationPredicate> entry : entries) {
            bucket.add(entry.get(0).hashCode());
        }
        assert bucket.size() == entries.size();
    }
}