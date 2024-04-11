package MultiLevelCacheSystem.storage;

import Cache_LLD.cache.exceptions.NotFoundException;
import MultiLevelCacheSystem.Exceptions.StorageFullExceptions;

import java.util.HashMap;

public class InMemoryStorage implements StoragePolicyInterface {
    private final HashMap<String,String> storage;
    private final Integer capacity;
    public InMemoryStorage(Integer capacity) {
        this.storage=new HashMap<String, String>();
        this.capacity=capacity;
    }

    @Override
    public void add(String key, String value)  throws StorageFullExceptions {
        if(isStorageFull()){
            throw new StorageFullExceptions();
        }
        storage.put(key,value);
    }

    @Override
    public String get(String key)   throws NotFoundException {

        return storage.get(key);
    }

    @Override
    public void remove(String key)   throws  NotFoundException{

         storage.remove(key);
    }

    @Override
    public boolean isStorageFull(){
        return this.storage.size()==capacity;
    }
    public double getCurrentUsage() {
        return ((double) storage.size()) / ((double) capacity);
    }
}
