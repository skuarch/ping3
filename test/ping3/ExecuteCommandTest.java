package ping3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author skuarch
 */
public class ExecuteCommandTest {
    
    public ExecuteCommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of exec method, of class ExecuteCommand.
     */
    @Test
    public void testExec() throws Exception {
        
        //String[] command = new String[]{"ping ","-c ", "2","192.168.208.9"," > ","/dev/null"," && ","echo \"true\" || echo \"false\""};
        
        ExecuteCommand ec = new ExecuteCommand();        
        System.out.println(
                ExecuteCommand.exec("/home/skuarch/NetBeansProjects/ping3/ping.sh 192.168.208.9")                
        );        
        
    }
    
}
