package Cache_LLD.cache.factories;

import Cache_LLD.cache.Cache;
import Cache_LLD.cache.policies.LRUEvictionPolicy;
import Cache_LLD.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key,Value> {
    public Cache<Key,Value> defaultCache() {
        return new Cache<Key,Value>(new LRUEvictionPolicy<Key>(),new HashMapBasedStorage<Key,Value>());
    }

}
