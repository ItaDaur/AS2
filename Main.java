public class Main {
    public static void main(String[] args) {


    }

    public static boolean searchKey(int key, int[] list) {
        int min = 0;
        int max = list.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            int mb = list[mid];
            if (mb == key) {
                return true;
            }
            if (mb > key) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return false;
    }

    public static boolean searchSum(int sum, int[] list) {
        for (int i=0;i<list.length;i++) {
            if (list[i] == sum )
                return true;
            int min = i;
            int max= list.length-1;
            int storage = list[i];
            while (min <= max) {
                int mid = (min + max) / 2;
                int mb = list[mid];
                if (mb == (sum-storage)) {
                    return true;
                }
                if (mb > (sum-storage)) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }

        }
        return false;
    }
}
