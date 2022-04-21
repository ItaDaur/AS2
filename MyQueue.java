public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> ll;

    public MyQueue() {
        ll = new MyLinkedList<>();
    }

    public int size(){
        return ll.size();
    }

    public T peek() {
        return ll.get(0);
    }

    public T enqueue(T item) {
        ll.add(item);
        return item;
    }

    public T dequeue() {
        T removingItem = peek();

        ll.remove(0);

        return removingItem;
    }


}
