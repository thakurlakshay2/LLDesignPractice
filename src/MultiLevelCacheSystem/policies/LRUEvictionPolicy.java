package MultiLevelCacheSystem.policies;

import Cache_LLD.Algorithms.DoubleLinkedList;
import Cache_LLD.Algorithms.DoubleLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicyInterface<Key> {
    private final DoubleLinkedList<Key> dll;
    private final Map<Key,DoubleLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
        this.dll = new DoubleLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if(mapper.containsKey(key)){
            dll.detatchNode(mapper.get(key));
            dll.addNodeToLast(mapper.get(key));
        }else{
            DoubleLinkedListNode<Key> newNode=dll.addElementAtLast(key);
            mapper.put(key,newNode);
        }
    }

    @Override
    public Key removeKey() {
        DoubleLinkedListNode<Key> firstNode=dll.getFirst();
        if(firstNode==null){
            return null;
        }
        dll.removeNode(firstNode);
        return firstNode.getElement();
    }
}
