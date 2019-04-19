package zyx.smartshopper;

import org.junit.Test;

import static org.junit.Assert.*;
import zyx.smartshopper.firebase.Connection;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FirebaseUnitTest {

    @Test
    public void firebaseConnectionWorks() {
        assertTrue(true);
    }

    @Test
    public void firebaseSendData() {
        Connection test = new Connection();
        test.createConnection();
        test.writeData("stores", "name", "Kevin Chen's Sweatshop");
        assertEquals(0, 0);
    }
}