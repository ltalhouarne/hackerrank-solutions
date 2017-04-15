import java.util.Scanner;

public class MergeSortCountingInversions {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countSwaps(arr, 0, 0));
        }
    }

    public static int countSwaps(int[] arr, int currIdx, int prevMax) {
        if(currIdx == arr.length) return 0;
        if(arr[currIdx] > prevMax) {
            return countSwaps(arr, currIdx + 1, arr[currIdx]);
        } else {
            return countSwap(arr, currIdx, arr[currIdx]) + countSwaps(arr, currIdx + 1, prevMax);
        }
    }

    public static int countSwap(int[] arr, int currIdx, int num) {
        int count = 0;
        for(int i = currIdx - 1; i >= 0; i--) {
            if(num < arr[i]) {
                count++;
            }
        }
        return count;
    }
}
