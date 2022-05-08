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
    private int capacity = 7;
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
        int index = hash(key);


        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            newNode.next = buckets[index];
            buckets[index] = newNode;
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

        return null;
    }

    private int hash(K key){
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    private void rehash() {

    }

    public void printAll() {
        for (int i=0;i<length;i++) {
            System.out.print(i + " -> ");
            MyNode<K,V> it = buckets[i];
            while (it.next != null) {
                System.out.println(it.value + " ");
                it = it.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }
}
