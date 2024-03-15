package Cache_LLD.cache.storage;

import Cache_LLD.cache.exceptions.NotFoundException;
import Cache_LLD.cache.exceptions.StorageFullException;

public interface StoragePolicyInterface<Key,Value> {

    public void put(Key key,Value value) throws StorageFullException;

     Value get(Key key) throws NotFoundException;

     void remove(Key key) throws NotFoundException;

}
