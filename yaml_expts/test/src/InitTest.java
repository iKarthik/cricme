import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static junit.framework.Assert.*;

/**
 * Created by hx44352 on 11/6/13.
 */
public class InitTest {

    @Before
    public void before(){

    }

    @Test
    public void testCanary(){
        assertTrue(true);
    }

    @Test
    public void testLoad() throws Exception {
        Yaml yaml = new Yaml();
        Object data = yaml.load(new FileInputStream(new File("C:\\play\\GitHub Projects\\yaml_expts\\files\\211028.yaml")));
        assertNotNull(data);
    }
}


