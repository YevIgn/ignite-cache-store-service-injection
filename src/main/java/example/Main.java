package example;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

/**
 * @author Evgeniy_Ignatiev
 * @since 9/13/2016 4:52 PM
 */
public class Main {
    public static void main(String[] args) {
        Ignite ignite = Ignition.start("ignite.xml");
        IgniteCache<Object, Object> cache = ignite.cache("testCache");

        try {
            cache.put(1, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ignite.services().service(CacheStoreBackend.SERVICE_NAME) == null);
        ignite.close();
    }

}
