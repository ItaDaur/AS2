import java.util.Iterator;

public class BST<K extends Comparable<K>, V> implements Iterable<K> {
    private Node root;

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    public void put(K key, V value) {
        Node newNode = new Node(key, value);
        root = put(root, newNode);
    }

    private Node put(Node current, Node newNode) {
        if (current == null)
            return newNode;
        if (newNode.key.compareTo(current.key)>0) {
            current.right = put(current.right, newNode);
        } else if (newNode.key.compareTo(current.key)<0) {
            current.left = put(current.left, newNode);
        } else {
            current.value = newNode.value;
        }
        return current;
    }
}
