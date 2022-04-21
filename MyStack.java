public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> arr;

    public MyStack() {
        arr = new MyArrayList<>();
    }

    public T push(T item) {
        arr.add(item);
        return item;
    }

    public T peek() {
        return arr.get(size()-1);
    }

    public T pop() {
        T removingItem = peek();

        arr.removeLast();

        return removingItem;
    }

    public int size() {
        return arr.size();
    }

}
