package MultiLevelCacheSystem.storage;

import Cache_LLD.cache.exceptions.NotFoundException;
import MultiLevelCacheSystem.Exceptions.StorageFullExceptions;

public interface StoragePolicyInterface{

    public void add(String key,String value) throws StorageFullExceptions;

     String get(String key) throws NotFoundException;

     void remove(String key) throws NotFoundException;

     boolean isStorageFull();
     double getCurrentUsage();
}
