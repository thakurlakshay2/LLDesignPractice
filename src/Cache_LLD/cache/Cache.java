package Cache_LLD.cache;

public class Cache {
    private final EvictionPolicy<Key> evictionPolicy;
    private final CacheStorage<Key,Value> cacheStorage;
˛

    public Cache(EvictionPolicy<Key> evictionPolicy, CacheStorage<Key, Value> cacheStorage) {
        this.evictionPolicy = evictionPolicy;
        this.cacheStorage = cacheStorage;
    }

    public void put(Key key, Value value){
        try{
            cacheStorage.put(key,value);
            evictionPolicy.keyAccessed(key);
        }catch (StorageFullException storageFull){
            System.out.println("Storage is full evicting some data to make space.... plz wait");
            Key keytoRemove=evictionPolicy.removeKey();
            if(keytoRemove==null){
                throw new RuntimeException("Some error occured , cache was already empty . this task cannot be completed");
                return ;
            }
            cacheStorage.remove(key);
            cacheStorage.put(key,value);
            evictionPolicy.keyAccessed(key);
        }
    }

    public Value get(Key key){
        try{
            Value data=cacheStorage.get(key);
            evictionPolicy.keyAccessed(key);
            return data;
        }catch(NotFoundException keyNotFound){
            System.out.println("Data you are looking for is not available");
            return null;
        }
    }
}
