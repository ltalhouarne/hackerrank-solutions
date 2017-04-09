import java.util.Scanner;

public class BubbleSort {

    private static int[] arr = {};
    private static int swapCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] tmpArr = new int[n];

        for(int i = 0; i < n; i++) {
            tmpArr[i] = Integer.parseInt(scanner.next());
        }

        arr = tmpArr;

        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    numberOfSwaps++;
                }
            }

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }

        System.out.println("Array is sorted in " + swapCount + " swaps.");
        System.out.println("First Element: " + ((arr.length > 0) ? arr[0] : 0));
        System.out.println("Last Element: " + ((arr.length > 0) ? arr[arr.length - 1] : 0));
    }

    private static void swap(int index1, int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
        swapCount++;
    }
}
