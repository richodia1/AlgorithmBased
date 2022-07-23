package tst;

import glovo.AnagramClass;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class GlovoTest {

    @Test
    public void TestOne(){
        AnagramClass ana = new AnagramClass();
        assertTrue(ana.isAnagram("rice","ecri"));
        assertNotEquals(ana.isAnagram("rice","ecri"),false);
    }
}
