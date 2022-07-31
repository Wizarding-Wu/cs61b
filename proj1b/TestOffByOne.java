import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('b', 'a'));

        assertTrue(offByOne.equalChars('r', 'q'));
        assertTrue(offByOne.equalChars('q', 'r'));

        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));

        assertTrue(offByOne.equalChars('&', '%'));
        assertTrue(offByOne.equalChars('%', '&'));
        assertFalse(offByOne.equalChars('%', '!'));

        assertTrue(offByOne.equalChars('A', 'B'));
        assertTrue(offByOne.equalChars('G', 'F'));
        assertFalse(offByOne.equalChars('A', 'E'));

        assertFalse(offByOne.equalChars('3', '7'));
        assertTrue(offByOne.equalChars('1', '2'));
        assertTrue(offByOne.equalChars('2', '1'));
    }
}
