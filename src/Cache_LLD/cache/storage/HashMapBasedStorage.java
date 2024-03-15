package Cache_LLD.cache.storage;

import Cache_LLD.cache.exceptions.NotFoundException;
import Cache_LLD.cache.exceptions.StorageFullException;
import com.sun.jdi.Value;

import java.util.HashMap;

public class HashMapBasedStorage<Key,Value> implements StoragePolicyInterface<Key,Value> {
    private final HashMap<Key,Value> storage;
    public HashMapBasedStorage() {
        storage=new HashMap<Key, Value>();
    }

    @Override
    public void put(Key key, Value value)  throws StorageFullException {

        storage.put(key,value);
    }

    @Override
    public Value get(Key key)   throws NotFoundException {

        return storage.get(key);
    }

    @Override
    public void remove(Key key)   throws  NotFoundException{

         storage.remove(key);
    }
}
