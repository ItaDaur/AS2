public class MyHashTable<K,V> {
    private static class MyNode<K,V> {
        private K key;
        private V value;
        MyNode<K,V> next;

        MyNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private MyNode<K,V>[] buckets;
    private int capacity = 16;
    private int length = 0;
    private float loadFactor = 0.75F;

    public MyHashTable() {
        buckets = new MyNode[capacity];
    }

    public MyHashTable(int initialCapacity) {
        capacity = (int)(initialCapacity * loadFactor);
        buckets = new MyNode[capacity];
    }

    public void put(K key, V value){
        MyNode<K,V> newNode = new MyNode<>(key, value);
        if (length/3>=capacity)
            rehash(2);
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            MyNode<K,V> it = buckets[index];
            while (it != null) {
                if (it.key.equals(newNode.key)) {
                    System.out.println("this key was used!");
                    return;
                }
                it = it.next;
            }
            newNode.next = buckets[index];
            buckets[index]= newNode;
        }
        length++;
    }

    public V get(K key) {
        int index = hash(key);

        MyNode<K,V> it = buckets[index];
        while (it != null) {
            if (it.key.equals(key))
                return it.value;
            it = it.next;
        }
        return null;
    }

    public K getKey (V value) {
        for (int i=0;i<capacity;i++) {
            MyNode<K,V> it = buckets[i];
            while (it !=null) {
                if (it.value.equals(value))
                    return it.key;
                it = it.next;
            }
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i=0;i<capacity;i++) {
            MyNode<K,V> it = buckets[i];
            while (it !=null) {
                if (it.value.equals(value))
                    return true;
                it = it.next;
            }
        }
        return false;
    }

    public V remote (K key) {
        int index = hash(key);
        MyNode<K,V> it = buckets[index];
        MyNode<K,V> prev = buckets[index];
        if (buckets[index].key.equals(key)) {
            buckets[index]=it.next;
        }
        while (it != null) {
            if (it.key.equals(key)) {
                prev.next = it.next;
                it=null;
                break; }
            prev = it;
            it = it.next;
        }
        length--;
        return null;
    }

    private int hash(K key){
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    private void rehash(int init) {
        MyNode<K,V>[] oldBuckets = buckets;
        capacity = capacity*init;
        buckets = new MyNode[capacity];
        for (int i=0;i< oldBuckets.length;i++) {
            MyNode<K,V> it = oldBuckets[i];
            while (it != null) {
                int index = hash(it.key);
                MyNode<K,V> newNode = new MyNode<>(it.key, it.value);
                if (buckets[index] == null) {
                    buckets[index] = newNode;
                } else {
                    newNode.next = buckets[index];
                    buckets[index]= newNode;
                }
                it=it.next;
            }
        }
    }

    public int size() {
        return length;
    }

    public void printAll() {
        for (int i=0;i<capacity;i++) {
            System.out.print(i + " -> ");
            MyNode<K,V> it = buckets[i];
            while (it != null) {
                System.out.print(it.value + " ");
                it = it.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyHashTable<Integer, String> hashTable = new MyHashTable<>(4);
        hashTable.put(1,"A");
        hashTable.put(2,"B");
        hashTable.put(15,"C");
        hashTable.put(4,"D");
        hashTable.put(3,"A");
        hashTable.put(6,"B");
        hashTable.put(7,"C");
        hashTable.put(8,"D");
        hashTable.put(10,"A");
        hashTable.put(9,"B");
        hashTable.put(11,"C");
        hashTable.put(12,"D");
        hashTable.put(13,"A");
        hashTable.put(14,"B");
        hashTable.put(16,"C");
        hashTable.put(17,"D");
        hashTable.put(18,"A");
        hashTable.put(19,"B");
        hashTable.put(20,"C");
        hashTable.put(21,"D");
        hashTable.put(22,"A");
        hashTable.put(23,"B");
        hashTable.put(24,"C");
        hashTable.put(25,"D");
        hashTable.put(26,"A");
        hashTable.put(27,"B");
        hashTable.put(28,"C");
        hashTable.put(29,"D");
        hashTable.put(30,"A");
        hashTable.put(31,"B");
        hashTable.put(32,"C");
        hashTable.put(33,"D");
        hashTable.put(34,"A");
        hashTable.put(35,"B");
        hashTable.put(36,"C");
        hashTable.put(37,"D");
        hashTable.put(38,"A");
        hashTable.put(39,"B");
        hashTable.put(40,"C");
        hashTable.put(41,"D");
        hashTable.printAll();
        System.out.println(hashTable.size());


    }
}
