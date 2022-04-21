public class MyHeap<T extends Comparable<T>> {
    private MyArrayList<T> arr;
    private boolean isMin = true;
    private int index = 0;
    private int size;

    public MyHeap(int size) {
        arr = new MyArrayList<>();
        this.size = size;
    }

    public void add(T item){
        arr.add(item);
        int current = index;

        T temp1 = arr.get(current), temp2 = arr.get(parent(current));

        while (temp1.compareTo(temp2)>0) {
            swap(current, parent(current));
            current = parent(current);
        }
        index++;
    }

    public void minHeap() {
        for (int i = (index - 1 / 2); i >= 1; i--) {
            heapify(i);
        }
    }

    private boolean isLeaf(int i) {
        if (rightChild(i) >= size || leftChild(i) >= size) {
            return true;
        }
        return false;
    }

    private void heapify(int pos) {
        if (!isLeaf(pos)) {
            T a = arr.get(pos), b = arr.get(leftChild(pos)),
                    c = arr.get(rightChild(pos));
            if (a.compareTo(b) > 0 || a.compareTo(c) > 0) {

                if (b.compareTo(c) < 0) {
                    swap(pos, leftChild(pos));
                    heapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    heapify(rightChild(pos));
                }
            }
        }
    }

    public T removeRoot() {
        T popped = arr.get(0);
        arr.remove(0);
        index--;
        heapify(0);

        return popped;
    }

    private int parent(int position) {
        return (position-1)/2;
    }

    private int leftChild(int position) {
        return (position*2) + 1;
    }

    private int rightChild(int position) {
        return (position*2) + 2;
    }

    private void swap(int i, int j)
    {
        T temp1, temp2;
        temp1 = arr.get(i);
        temp2 = arr.get(j);
        arr.remove(i);
        arr.remove(j);
        arr.add(temp2,i);
        arr.add(temp1,j);
    }

    public boolean isMinHeap(){
        return isMin;
    }

    public void print() {
        for (int i = 0; i < (index / 2); i++) {
            System.out.print("Parent : " + arr.get(i));
            if (leftChild(i) < index)
                System.out.print(" Left : " + arr.get(leftChild(i)));
            if (rightChild(i) < index)
                System.out.print(" Right :" + arr.get(rightChild(i)));
            System.out.println();
        }
    }


}
