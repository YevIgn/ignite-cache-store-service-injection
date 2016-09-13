package example;

import org.apache.ignite.services.Service;
import org.apache.ignite.services.ServiceContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeniy_Ignatiev
 * @since 9/13/2016 4:14 PM
 */
public class CacheStoreBackend implements Service {
    public static final String SERVICE_NAME = "backendService";

    private final Map<Object, Object> map = new HashMap<>();

    @Override
    public void init(ServiceContext context) {
    }

    @Override
    public void execute(ServiceContext context) {
    }

    @Override
    public void cancel(ServiceContext context) {
    }

    public void put(Object key, Object value) {
        map.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <K> K get(Object key) {
        return (K) map.get(key);
    }

    public void delete(Object key) {
        map.remove(key);
    }
}
