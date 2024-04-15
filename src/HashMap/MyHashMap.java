package HashMap;


import java.util.HashMap;

public class MyHashMap<K,V> {
    private static int INITIAL_SIZE=1<<4 //16
    private static final int MAXIIMUM_CAPACITY=1<<30;

    public Entry[] hashTable;

    public MyHashMap(Entry[] hashTable) {
        this.hashTable = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity){
        int tabSize=tableSizeFor(capacity);
        hashTable=new Entry[tabSize];
    }
    final int tableSizeFor(int cap){
        int n=cap-1;
        n |=n>>1;
        n |=n>>2;
        n |=n>>4;
        n |=n>>8;
        n |=n>>16;
        return (n<0)?1:(n>=MAXIIMUM_CAPACITY)?MAXIIMUM_CAPACITY:n+1;
    }

    class Entry<K,V>{
        public K key;
        public V value;
        public Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key,V value){
        int hashCode=key.hashCode()%hashTable.length;
        Entry node=hashTable[hashCode];
        if(node==null){
            Entry newNode=new Entry(key,value);
            hashTable[hashCode]=newNode;
        }else{
            Entry prevNode=node;
            while (node!=null){
                if(node.key==key){
                    node.value=value;
                    return ;
                }
                prevNode=node;
                node=node.next;
            }
            Entry newNode=new Entry(key,value);
            prevNode.next=newNode;
        }
    }

    public V get(K key){
        int hashCode=key.hashCode()%hashTable.length;
        Entry node=hashTable[hashCode];

        while (node!=null){
            if(node.key.equals(key)){
                return (V) node.value;
            }
            node=node.next;
        }
        return null;
    }


    //TREEFIE threash hold. - >converts the ll to balanced binary search tree , load factor of 75%

    public static void main(String[] args) {
//        HashMap<Integer,Integer> map=new HashMap<>();
        MyHashMap<Integer,String> map=new MyHashMap<Integer,String>(12);

        map.put(1,"lask");
        map.put(2,"221d");
        map.put(3,"gwda");
        map.put(3,"bdrg");
        map.put(2,"dawd");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
        map.put(1,"test");
        System.out.println(map.get(1));


    }
}
