import java.util.Arrays;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object []arr;
    private int length = 0;
    private int capacity =3;

    public MyArrayList() {
        arr = new Object[capacity];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for (int i=0;i<length;i++) {
            if (arr[i].equals(o))
                return true;
        }
        return false;
    }

    @Override
    public void add(T item) {
        if (capacity==length)
            increase();
        arr[length++]=item;
    }

    public void removeLast() {
        length--;
    }

    private void increase() {
        capacity = 2*capacity;
        Object[] old = arr;
        arr=new Object[capacity];
        for (int i=0;i<old.length;i++)
            arr[i]=old[i];
    }

    @Override
    public void add(T item, int index) {
        if (index>=length || index<0)
            throw new IndexOutOfBoundsException("Your index must be less then your length");
        if (capacity== length)
            increase();

        for (int i = length;i>index;i--) {
            arr[i]=arr[i-1];
        }
        arr[index] = item;
        length++;
    }

    @Override
    public boolean remove(T item) {
        int count = 0;
        for (int i=0;i<length;i++) {
            if (arr[i].equals(item))
                count++;
        }
        if (count==0)
            return false;
        Object[] old = arr;
        arr=new Object[length-count];
        int j=0;
        for (int i=0;i<length;i++) {
            if (old[i]==item) {
                continue;
            }
            arr[j]=old[i];
            j++;
        }
        length=length-count;

        return true;
    }

    @Override
    public T remove(int index) {
        Object[] old = arr;
        arr=new Object[length--];
        int j=0;
        for (int i=0;i<old.length;i++) {
            if (i==index)
                continue;
            arr[j]=old[i];
            j++;
        }
        return (T)old[index];
    }

    @Override
    public void clear() {
        arr=null;
        length=0;
    }

    @Override
    public T get(int index) {
        if (index<0 || index>=length)
            throw new IndexOutOfBoundsException("Your index enter incorrect");
        return (T)arr[index];
    }

    @Override
    public int indexOf(Object o) {
        int index = -1;
        for (int i=0;i<length;i++) {
            if (arr[i].equals(o)) {
                index=0;
                return i; }
        }
        if (index==-1)
            throw new IndexOutOfBoundsException("Your item does not include in this array");
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index=-1;
        for (int i=0;i<length;i++) {
            if (arr[i].equals(o))
                index=i;
        }
        if (index==-1)
            throw new IndexOutOfBoundsException("Your item does not include in this array");
        return index;
    }

    @Override
    public void sort() {
        for (int i=0;i<length;i++) {
            for (int j=0;j<length-1-i;j++) {
                T a = (T)arr[j];
                T b = (T)arr[j+1];
                if (a.compareTo(b) > 0) {
                    arr[j]=b;
                    arr[j+1]=a;
                }

            }
        }
    }

    @Override
    public String toString() {
        Object [] old = arr;
        arr = new Object[length];
        for (int i=0;i<length;i++) {
            arr[i]=old[i];
        }
        return Arrays.toString(arr);

    }
}
