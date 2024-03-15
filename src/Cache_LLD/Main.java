package Cache_LLD;

import Cache_LLD.cache.Cache;
import Cache_LLD.cache.factories.CacheFactory;
import Cache_LLD.cache.policies.EvictionPolicyInterface;
import Cache_LLD.cache.policies.LRUEvictionPolicy;
import Cache_LLD.cache.storage.HashMapBasedStorage;

public class Main {
    public static void main(String[] args) {
        CacheFactory<Integer,String> factory=new CacheFactory<Integer,String>();

        Cache<Integer, String> cache=  factory.defaultCache();
        cache.put(1,"ab");
        cache.put(12,"abc");
        cache.put(1,"abx");
        cache.put(5,"abxa");
        cache.put(15,"abs");
        cache.put(2,"abj");
        cache.put(4,"abi");
        cache.put(5,"abl");
    System.out.println(cache.get(5));
        System.out.println(cache.get(2));
        System.out.println(cache.get(99));


    }


}
