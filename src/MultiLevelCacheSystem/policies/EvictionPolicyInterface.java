package MultiLevelCacheSystem.policies;

public interface EvictionPolicyInterface<Key> {

    public   void keyAccessed(Key key);

     Key removeKey();
}
