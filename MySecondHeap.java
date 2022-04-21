public class MySecondHeap {
        private int[] Heap;
        private int index;
        private int size;

        public MySecondHeap(int size) {
            this.size = size;
            this.index = 0;
            Heap = new int[size];
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        private int leftChild(int i) {
            return (i * 2) + 1;
        }

        private int rightChild(int i) {
            return (i * 2) + 2;
        }

        private boolean isLeaf(int i) {
            if (rightChild(i) >= size || leftChild(i) >= size) {
                return true;
            }
            return false;
        }

        public void add(int element) {
            if (index >= size) {
                return;
            }
            Heap[index] = element;
            int current = index;

            while (Heap[current] < Heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
            index++;
        }

        public int remove() {
            int popped = Heap[0];
            Heap[0] = Heap[--index];
            minHeapify(0);
            return popped;
        }

        private void minHeapify(int i) {
            if (!isLeaf(i)) {
                if (Heap[i] > Heap[leftChild(i)] ||
                        Heap[i] > Heap[rightChild(i)]) {
                    if (Heap[leftChild(i)] < Heap[rightChild(i)]) {
                        swap(i, leftChild(i));
                        minHeapify(leftChild(i));
                    } else {
                        swap(i, rightChild(i));
                        minHeapify(rightChild(i));
                    }
                }
            }
        }

        public void minHeap() {
            for (int i = (index - 1 / 2); i >= 1; i--) {
                minHeapify(i);
            }
        }

        public void printHeap() {
            for (int i = 0; i < (index / 2); i++) {
                System.out.print("Parent : " + Heap[i]);
                if (leftChild(i) < index)
                    System.out.print(" Left : " + Heap[leftChild(i)]);
                if (rightChild(i) < index)
                    System.out.print(" Right :" + Heap[rightChild(i)]);
                System.out.println();
            }
        }

        private void swap(int x, int y) {
            int tmp;
            tmp = Heap[x];
            Heap[x] = Heap[y];
            Heap[y] = tmp;
        }
}
