package com.creaty.algorithm;

/**
 * Created by hyx on 2016/4/13.
 */
public class Sort {

    public static void insertSort(int arr[]) {
        insertSort(arr, 0, arr.length - 1);
    }

    public static void insertSort(int arr[], int p, int r) {
        int i, j;
        for (i = p + 1; i < r + 1; i++) {
            int tmp = arr[i];
            for (j = i - 1; j >= 0 && tmp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
    }

    public static void mergeSort(int arr[]) {
        int tmp[] = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
    }

    public static void mergeSort(int arr[], int p, int r, int[] tmp) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q, tmp);
            mergeSort(arr, q + 1, r, tmp);
            merge(arr, p, q, r, tmp);
        }
    }

    public static void merge(int arr[], int p, int q, int r, int tmp[]) {
        System.arraycopy(arr, p, tmp, p, r - p + 1);
        int x = q + 1, y = r + 1;
        int i = p, j = q + 1;
        int k = p;
        while (i < x && j < y) {
            if (tmp[i] <= tmp[j]) {
                arr[k] = tmp[i];
                i++;
            } else {
                arr[k] = tmp[j];
                j++;
            }
            k++;
        }
        if (i >= x) {
            System.arraycopy(tmp, j, arr, k, y - j);
        } else {
            System.arraycopy(tmp, i, arr, k, x - i);
        }
    }

    public static void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static final int CUTOFF = 10;

    public static void quickSort(int arr[], int p, int r) {
        if (r - p < CUTOFF ) {
            insertSort(arr, p, r);
            return;
        }
        int q = partition(arr, p, r);
        quickSort(arr, p, q - 1);
        quickSort(arr, q + 1, r);

    }

    protected static int partition(int arr[], int p, int r) {
        int x = arr[p];
        int i = p, j = r + 1;
        while (true) {
            while (arr[++i] < x) {
                if (i == r) break;
            }
            while (x < arr[--j]) {
                if (j == p) break;
            }
            if (i >= j) break;
            exch(arr, i, j);
        }
        exch(arr, p, j);
        return j;
    }

    public static void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
//        int[] b = {-2, 1, 1, 2, 4, 5, 6, 7, 8, 9, 10};
//        int[] a = new int[b.length];
//        System.arraycopy(b, 0, a, 3, 5);
//        System.out.println(Arrays.toString(a));
    }
}
