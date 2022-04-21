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
        MyHeap<Integer> heap = new MyHeap<>(5);
        heap.add(380);

        heap.print();

    }
}
