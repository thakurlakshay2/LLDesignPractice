package Cache_LLD.cache.storage;

import com.sun.jdi.Value;

import java.util.HashMap;

public class HashMapBasedStorage<Key,Value> implements StoragePolicyInterface<Key,Value> {
    private final HashMap<Key,Value> storage;
    private final int capacity;
    public HashMapBasedStorage(int capacity) {
        storage=new HashMap<Key, Value>();
        this.capacity=capacity;
    }

    @Override
    public void put(Key key, Value value)  throws  StorageFullException{

        storage.put(key,value);
    }

    @Override
    public Value get(Key key)   throws  NotFoundException{

        return storage.get(key);
    }

    @Override
    public void remove(Key key)   throws  NotFoundException{

         storage.remove(key);
    }
}
