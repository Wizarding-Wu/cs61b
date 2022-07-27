import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void Testfun() {
        assertEquals(true, Flik.isSameNumber(127, 127));
        assertEquals(true, Flik.isSameNumber(128, 128));
        assertEquals(true, Flik.isSameNumber(129, 129));
    }

}
