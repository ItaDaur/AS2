public class Main {
    public static void main(String[] args) {
//        MyArrayList<String> arr = new MyArrayList<>();
//        arr.add("Atyrau");
//        arr.add("Astana");
//        arr.add("Almaty");
//        arr.add("Astana");
//        arr.add("Kokshetau",1);
//
//
//        arr.remove(2);
//        for (int i=0;i<arr.size();i++) {
//            System.out.print(arr.get(i) + " ");
//        }
//        System.out.println();
//        arr.sort();
//        System.out.println(arr);

//        MyLinkedList<String> ll = new MyLinkedList<>();
//        ll.add("Atyrau");
//        ll.add("Astana");
//        ll.add("Almaty");
//        ll.add("Aktau");
//        ll.add("London");
//        ll.add("Boston");
//        System.out.println(ll);
//        ll.add("Moscow",6);
//        System.out.println(ll);
//        System.out.println(ll.lastIndexOf("Boston"));
//        ll.sort();
//        System.out.println(ll);


//        MySecondHeap heap = new MySecondHeap(3);
//        heap.add(3);
//        heap.add(8);
//        heap.add(1);
//        heap.minHeap();
//        heap.printHeap();

        MyThirdHeap<Integer> heap = new MyThirdHeap<>();
        heap.add(34);
        heap.add(12);
        heap.add(2);
        heap.add(56);
        heap.add(45);
        heap.add(1);
        heap.print();
        heap.remove(56);
        heap.print();
    }
}
