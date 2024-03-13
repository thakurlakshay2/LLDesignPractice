package Cache_LLD.cache.policies;

public interface EvictionPolicyInterface<Key> {

    public   void keyAccessed(Key key);

     Key removeKey();
}
