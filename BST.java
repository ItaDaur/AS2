public class BST<K extends Comparable<K>, V> {
    private Node root;

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

    public V get(K key) {
        Node findNode = root;
        while (findNode != null) {
            if (key.compareTo(findNode.key)>0) {
                findNode = findNode.right;
            } else if (key.compareTo(findNode.key)<0) {
                findNode = findNode.left;
            } else {
                return findNode.value;
            }
        }
        return null;
    }

    public void delete(K key) {
        Node deleteNode = root, newNode = null;

        while (deleteNode != null) {
            if (key.compareTo(deleteNode.key)==0) {
                break;
            } else {
                newNode = deleteNode;
                if (key.compareTo(deleteNode.key)>0) {
                    deleteNode = deleteNode.right;
                } else {
                    deleteNode = deleteNode.left;
                }
            }
        }

        if (deleteNode == null) {
            return;
        }

        if (deleteNode.right == null) {
            if (newNode == null) {
                root = deleteNode.left;
            } else {
                if (deleteNode == newNode.left) {
                    newNode.left = deleteNode.left;
                } else {
                    newNode.right = deleteNode.left;
                }
            }
        } else {
            Node biggestInLeft = deleteNode.right;
            newNode = null;
            while (biggestInLeft.left != null) {
                newNode = biggestInLeft;
                biggestInLeft = biggestInLeft.left;
            }

            if (newNode!=null) {
                newNode.left = biggestInLeft.right;
            } else{
                deleteNode.right = biggestInLeft.right;
            }
            deleteNode.key=biggestInLeft.key;
            deleteNode.value = biggestInLeft.value;
        }

    }

    public Iterable<K> iterator() {
        MyQueue<K> q = new MyQueue<K>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, MyQueue<K> q) {
        if (x==null) return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }

}
