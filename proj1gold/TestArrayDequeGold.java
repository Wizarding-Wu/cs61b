import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    /**
     * Randomly test StudentArrayDeque.
     * @source StudentArrayDequeLauncher.java
     * */
    @Test
    public void testArrayDeque() {
        int testN = 50;
        int opN = 20;

        for (int k = 0; k < testN; k++) {
            ArrayDequeSolution<Integer> deque = new ArrayDequeSolution<>();
            StudentArrayDeque<Integer> sDeque = new StudentArrayDeque<>();
            int size = 0;
            Integer n1, n2;

            String m = "";


            for (int i = 0; i < opN; i++) {
                double numberBetweenZeroAndOne = StdRandom.uniform();
                if (numberBetweenZeroAndOne > 0.75) {
                    if (size > 0) {
                        m += "\nremoveFirst()";
                        n1 = deque.removeFirst();
                        n2 = sDeque.removeFirst();
                        assertEquals(m, n1, n2);
                        size -= 1;
                    }
                } else if (numberBetweenZeroAndOne > 0.5) {
                    if (size > 0) {
                        m += "\nremoveLast()";
                        n1 = deque.removeLast();
                        n2 = sDeque.removeLast();
                        assertEquals(m, n1, n2);
                        size -= 1;
                    }
                } else if (numberBetweenZeroAndOne > 0.25) {
                    m += "\naddFirst(" + i + ")";
                    deque.addFirst(i);
                    sDeque.addFirst(i);
                    size += 1;
                } else {
                    m += "\naddLast(" + i + ")";
                    deque.addLast(i);
                    sDeque.addLast(i);
                    size += 1;
                }
            }
        }

    }
}

