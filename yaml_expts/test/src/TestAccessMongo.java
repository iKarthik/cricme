import com.mongodb.*;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by hx44352 on 11/6/13.
 */
public class TestAccessMongo {

    @Test
    public void testLoad() throws Exception {
        MongoClient mongoClient = new MongoClient( "localhost" );
        DB db = mongoClient.getDB("mydb");
        DBCollection coll = db.getCollection("newcoll");
        Yaml yaml = new Yaml();
        Map<String, Object> object =  (Map<String, Object>) yaml.load(new FileInputStream(new File("C:\\play\\GitHub Projects\\yaml_expts\\files\\seven.yaml")));
        coll.insert(new BasicDBObject(object));
        System.out.println(db);
    }

    @Test
    public void testFind() throws Exception {
        MongoClient mongoClient = new MongoClient( "localhost" );
        DB db = mongoClient.getDB("mydb");
        DBCollection coll = db.getCollection("newcoll");
        System.out.println(coll.getCount());
        DBCursor cursor = coll.find(new BasicDBObject("winner", "England"));
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }


         cursor = coll.find();
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

}
