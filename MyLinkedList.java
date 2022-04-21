public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {}

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        MyNode<T> temp = head;
        int index=length;

        while (index != 0) {
            if (temp.data.equals(o))
                return true;
            temp = temp.next;
            index--;
        }
        return false;
    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        if (index<0 || index>length)
            throw new IndexOutOfBoundsException("Your index must be positive");
        MyNode<T> temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        MyNode<T> newNode = new MyNode<>(item);

        if (index==0) {
            head=newNode;
            newNode.next=temp;
            temp.prev=newNode;
            length++;
        }
        else if (index==length) {
            this.add(item);
        }
        else {
            MyNode<T> prevNode = temp.prev;
            newNode.prev = temp.prev;
            prevNode.next = newNode;
            newNode.next=temp;
            length++;
        }

    }

    public boolean isEmpty() {
        if (head==null)
            return true;
        return false;
    }

    @Override
    public boolean remove(T item) {
        MyNode<T> temp = head;
        for (int i=0;i<length;i++) {
            if (temp.data.equals(item)) {
                MyNode<T> nextNode = temp.next;
                MyNode<T> prevNode = temp.prev;
                if(prevNode == null)
                    head = nextNode;
                else if(nextNode == null)
                    tail = temp.prev;
                else {
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                }
                length--;
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index>=length || index<0)
            throw new IndexOutOfBoundsException("Your index must be less then your length");
        MyNode<T> temp = head;
        for (int i=0;i<index;i++) {
            temp=temp.next;
        }
        T store = temp.data;
        MyNode<T> nextNode = temp.next;
        MyNode<T> prevNode = temp.prev;
        if(prevNode == null)
            head = nextNode;
        else if(nextNode == null)
            tail = temp.prev;
        else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        length--;
        return store;
    }

    @Override
    public void clear() {
        head = null;
        tail=null;
        length=0;
    }

    @Override
    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        int index=-1;
        MyNode<T> temp = head;
        for (int i=0;i<length;i++) {
            if (temp.data.equals(o))
                index=i;
            temp=temp.next;
        }
        if (index==-1)
            throw new IndexOutOfBoundsException("Your item does not include in this linked list");
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index=-1;
        MyNode<T> temp = head;
        for (int i=0;i<length;i++) {
            if (temp.data.equals(o))
                return i;
            temp=temp.next;
        }
        return index;
    }

    private void swap(T o, int index) {
        MyNode<T> temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        temp.data = o;
    }

    @Override
    public void sort() {
        for (int i=0;i<length;i++) {
            for (int j=0;j<length-1-i;j++) {
                T a = this.get(j);
                T b = this.get(j+1);
                if (a.compareTo(b) >0) {
                    swap(a,j+1);
                    swap(b,j);
                }
            }
        }
    }

    @Override
    public String toString() {
        String retStr = "LinkedList: ";
        MyNode<T> temp = head;
        int index=length;

        while (index != 0) {
            retStr += temp.data + " ";
            temp=temp.next;
            index--;
        }

        return retStr;
    }
}
