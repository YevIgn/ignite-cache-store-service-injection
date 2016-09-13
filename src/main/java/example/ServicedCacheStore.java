package example;

import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.resources.ServiceResource;

import javax.cache.Cache;

/**
 * @author Evgeniy_Ignatiev
 * @since 9/13/2016 4:11 PM
 */
public class ServicedCacheStore<K, V> extends CacheStoreAdapter<K, V> {
    @ServiceResource(serviceName = CacheStoreBackend.SERVICE_NAME)
    private CacheStoreBackend backend;

    @Override
    public void write(Cache.Entry<? extends K, ? extends V> entry) {
        backend.put(entry.getKey(), entry.getValue());
    }

    @Override
    public V load(K key) {
        return backend.get(key);
    }

    @Override
    public void delete(Object key) {
        backend.delete(key);
    }
}
