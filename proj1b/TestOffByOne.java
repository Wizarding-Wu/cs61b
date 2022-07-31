import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        OffByOne obo = new OffByOne();
        assertTrue(obo.equalChars('a', 'b'));
        assertTrue(obo.equalChars('b', 'a'));

        assertTrue(obo.equalChars('r', 'q'));
        assertTrue(obo.equalChars('q', 'r'));

        assertFalse(obo.equalChars('a', 'e'));
        assertFalse(obo.equalChars('z', 'a'));
        assertFalse(obo.equalChars('a', 'a'));

        assertTrue(obo.equalChars('&', '%'));
        assertTrue(obo.equalChars('%', '&'));

        assertTrue(obo.equalChars('A', 'B'));
        assertTrue(obo.equalChars('G', 'F'));
    }
}
