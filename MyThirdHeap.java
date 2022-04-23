public class MyThirdHeap<T extends Comparable<T>> {
    private MyArrayList<T> arr;
    private boolean isMin = true;

    public MyThirdHeap() {
        arr = new MyArrayList<>();
    }

    public void add(T item){
        arr.add(item);

        if(this.size() == 0)
            return;

        System.out.println("add " + item);
        allHeap();
    }

    public void changeHeap(){
        isMin = !isMin;
        allHeap();
    }

    public void allHeap() {
        if (isMinHeap()) {
            for (int i = (this.size() / 2); i >= 0; i--) {
                System.out.println("from min: "  + i);
                heapifyMin(i);
            }
        } else {
            for (int i = (this.size() / 2); i >= 0; i--) {
                System.out.println("from min: "  + i);
                heapifyMax(i);
            }
        }

    }

    private void heapifyMin(int top) {
        int min = top;
        int l = leftChild(top), r = rightChild(top);

        if(l < this.size() && arr.get(top).compareTo(arr.get(l)) > 0){
            min=l;
        }
        if(r < this.size() && arr.get(min).compareTo(arr.get(r)) > 0) {
            min = r;
        }
        if(min != top) {
            swap(top, min);
            System.out.println(top + " " + l);
            heapifyMin(l);
        }
    }

    private void heapifyMax(int top) {
        int max = top;
        int l = leftChild(top), r = rightChild(top);

        if(l < this.size() && arr.get(top).compareTo(arr.get(l)) < 0){
            max=l;
        }
        if(r < this.size() && arr.get(max).compareTo(arr.get(r)) < 0) {
            max = r;
        }
        if(max != top) {
            swap(top, max);
            System.out.println(top + " " + l);
            heapifyMax(l);
        }
    }


    public T removeRoot() {
        T popped = arr.get(0);
        swap(0,size()-1);
        arr.remove(size()-1);
        allHeap();
        return popped;
    }

    public boolean remove(T item){
        int index = arr.indexOf(item);
        swap(index,size()-1);
        arr.remove(size()-1);
        allHeap();
        if (index!=-1) {
            return true;
        }
        return false;
    }

    private boolean removeAll(T item){
        if (arr.remove(item)) {
            allHeap();
            return true;
        }
        return false;
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
