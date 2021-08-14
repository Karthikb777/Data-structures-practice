public class Sorting {
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        int temp;
//        loop for no. of passes
        for (int i = 0; i <= len-1; i++) {
//            loop for no.of comparisions
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }
    printArray(arr);
    }

    public static void bubbleSortAdaptive(int[] arr) {
        int len = arr.length;
        boolean isSorted;
        int temp;
//        loop for no. of passes ( total n-1 passes )
        for (int i = 0; i < len-1; i++) {
            System.out.println("pass " + i);
//            loop for no.of comparisions
            isSorted = true;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                return;
            }
        }
//        printArray(arr);
    }

    public static void insertionSort(int[] arr) {
        int len = arr.length;
        int key, j;
        for (int i = 1; i <= len-1 ; i++) {
            System.out.println("pass " + i);
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println("");
    }
}

class testSort {
    public static void main(String[] args) {
//        int[] arr = {50, 45, 22, 35, 10};
//        int[] arr = {50, 45, 22, 35, 10, 1, 100, 2, 21, 5, 8};
        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr = {5, 4, 3, 2, 1};
        Sorting.printArray(arr);
        System.out.println("after sorting\n");
        Sorting.insertionSort(arr);
        Sorting.printArray(arr);

    }
}
