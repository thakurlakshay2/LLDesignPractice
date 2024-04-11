package MultiLevelCacheSystem.provider;

import Cache_LLD.cache.exceptions.NotFoundException;
import MultiLevelCacheSystem.Exceptions.StorageFullExceptions;
import MultiLevelCacheSystem.policies.EvictionPolicyInterface;
import MultiLevelCacheSystem.storage.StoragePolicyInterface;

import java.util.ArrayList;
import java.util.List;

public class CacheProvider {
    private final EvictionPolicyInterface<String> evictionPolicy;
    private final StoragePolicyInterface cacheStorage;


    public CacheProvider(EvictionPolicyInterface<String> evictionPolicy, StoragePolicyInterface cacheStorage) {
        this.evictionPolicy = evictionPolicy;
        this.cacheStorage = cacheStorage;
    }

    public void put(String key, String value){
        try{
            cacheStorage.add(key,value);
            evictionPolicy.keyAccessed(key);
        }catch (StorageFullExceptions storageFull){
            System.out.println("Storage is full evicting some data to make space.... plz wait");
            String keytoRemove=evictionPolicy.removeKey();
            if(keytoRemove==null){
                throw new RuntimeException("Some error occured , cache was already empty . this task cannot be completed");

            }
            cacheStorage.remove(key);
            cacheStorage.add(key,value);
            evictionPolicy.keyAccessed(key);
        }
    }

    public String get(String key){
        try{
            String data=cacheStorage.get(key);
            evictionPolicy.keyAccessed(key);
            return data;
        }catch(NotFoundException keyNotFound){
            System.out.println("Data you are looking for is not available");
            return null;
        }
    }

    public double getCurrentUsage() {
        return this.cacheStorage.getCurrentUsage();
    }

}
