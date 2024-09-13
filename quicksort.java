package algorithm;

public class Quicksort {

    public static void main(String[] args) {
        int[] array = {9, 7, 5, 11, 12, 2, 14, 3, 10, 6};
      

        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array:");
        printArray(array);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivI = left;
        int too_Small_Index = right;
        int too_Big_Index = left + 1;
        int pivotValue = array[pivI];

        while (too_Big_Index <= too_Small_Index) {
            while (too_Big_Index <= too_Small_Index && array[too_Big_Index] <= pivotValue) {
                too_Big_Index++;
            }
            while (too_Big_Index <= too_Small_Index && array[too_Small_Index] > pivotValue) {
                too_Small_Index--;
            }
            if (too_Big_Index <= too_Small_Index) {
                int temp = array[too_Big_Index];
                array[too_Big_Index] = array[too_Small_Index];
                array[too_Small_Index] = temp;
            }
        }

        int temp = array[pivI];
        array[pivI] = array[too_Small_Index];
        array[too_Small_Index] = temp;

        return too_Small_Index;
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
