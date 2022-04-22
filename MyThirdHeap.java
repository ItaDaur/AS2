public class MyThirdHeap<T extends Comparable<T>> {
    private MyArrayList<T> arr;
    private boolean isMin = true;

    public MyThirdHeap() {
        arr = new MyArrayList<>();
//        this.size = size;
    }

    public void add(T item){
        arr.add(item);

        if(this.size() == 0)
            return;

        System.out.println("add " + item);
        minHeap();
    }

    public void minHeap() {
        for (int i = (this.size() / 2); i >= 0; i--) {
            System.out.println("from min: "  + i);
            heapify(i);
        }
    }

    private boolean isLeaf(int i) {
        if (rightChild(i) >= this.size() || leftChild(i) >= this.size()) {
            return true;
        }
        return false;
    }

    private void heapify(int top) {
        int min = top;
        int l = leftChild(top), r = rightChild(top);

        if(l < this.size() && arr.get(top).compareTo(arr.get(l)) > 0){
            min = l;
        }
        if(r < this.size() && arr.get(min).compareTo(arr.get(r)) > 0) {
            min = r;
        }
        if(min != top) {
            swap(top, min);
            System.out.println(top + " " + l);
            heapify(l);
        }
    }

    public T removeRoot() {
        T popped = arr.get(0);
        arr.remove(0);
        heapify(0);

        return popped;
    }

    private int parent(int position) {
        return (position-1)/2;
    }

    private int leftChild(int position) {
        return (position*2)+1 ;
    }

    private int rightChild(int position) {
        return (position*2) + 2;
    }

    private void swap(int i, int j)
    {
        T temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j,temp);
    }

    public boolean isMinHeap(){
        return isMin;
    }

    public void print() {
        for (int i=0;i<arr.size();i++) {
            System.out.println(" " + arr.get(i));
        }
    }

    public int size(){
        return arr.size();
    }
}
