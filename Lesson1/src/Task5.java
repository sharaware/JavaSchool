import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        int[] arr2 = arr.clone();
        mergeSort(arr);
        quickSort(arr2);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i : arr2) {
            System.out.print(i + "\t");
        }
    }

    private static void mergeSort(int[] arr) {
        //arr[0] = 1; arr[1] = 2;
        if(arr.length > 1) {
            int len = arr.length;
            int left_len = len/2;
            int rigth_len = len - len/2;
            int[] left = new int[left_len];
            int[] right = new int[rigth_len];
            for (int i = 0; i < len; i++) {
                if(i < left_len) {
                    left[i] = arr[i];
                } else {
                    right[i - left_len] = arr[i];
                }
            }
            mergeSort(left);
            mergeSort(right);
            int i = 0;
            int j = 0;
            while (i < left_len && j < rigth_len) {
                if(left[i] < right[j]) {
                    arr[i+j] = left[i];
                    i++;
                } else {
                    arr[i+j] = right[j];
                    j++;
                }
            }
            while (i < left_len) {
                arr[i+j] = left[i];
                i++;
            }
            while (j < rigth_len) {
                arr[i+j] = right[j];
                j++;
            }
        }
    }

    private static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(int[] arr, int beg, int end) {
        if(beg < end){
            int p = split(arr, beg, end);
            qSort(arr, beg, p);
            qSort(arr, p + 1, end);
        }
    }

    private static int split(int[] arr, int low, int high) {
        int median = arr[(low + high)/2];
        int i = low;
        int j = high;
        while(true) {
            while(arr[i] < median)
                i++;
            while(arr[j] > median)
                j--;
            if(i != j && arr[i] == arr[j])
                j--;
            if (i >= j)
                return j;
            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
    }
}
