public class MyHeap<T extends Comparable<T>> {
    private MyArrayList<T> arr;
    private boolean isMin = true;
    private int index = 0;
    private int size;

    public MyHeap() {
        arr = new MyArrayList<>();
    }

    public T getRoot(){
        return arr.get(0);
    }

    private int leftChildIndex(int i) {
        return 2*(i-1);
    }

    private int rightChildIndex(int i) {
        return ((2 * i) + 1);
    }

    private int parentIndex(int i) {
        return i / 2;
    }

    private void swap(int i, int j) {
        T temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j,temp);
    }

    public boolean isMin() {
        return isMin;
    }
}
