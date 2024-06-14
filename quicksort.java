public class quicksort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo], pivotidx = lo;
        int countsize = 0;
        for (int i = lo + 1; i <= hi; i++) {
            if (arr[i] <= pivot)
                countsize++;
        }
        int correctidx = pivotidx + countsize;
        swap(arr, pivotidx, correctidx);
        int i = lo, j = hi;
        while (i < correctidx && j > correctidx) {
            if (arr[i] <= pivot)
                i++;
            else if (arr[j] > pivot)
                j--;
            else if (arr[i] > pivot && arr[j] <= pivot) {
                swap(arr, i, j);
            }
        }
        return correctidx;
    }

    public static void quick(int[] arr, int lo, int hi) {
        if (lo >= hi)
            return;
        int idx = partition(arr, lo, hi);
        quick(arr, lo, idx - 1);
        quick(arr, idx + 1, hi);
    }

    public static void main(String[] args) {
        int[] arr = { 9, 5, 7, 8, 4, 6, 3, 1, 2 };
        int n = arr.length;
        quick(arr, 0, n - 1);
        print(arr);
    }
}

