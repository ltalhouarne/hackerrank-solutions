import java.util.HashMap;
import java.util.Scanner;

public class FibonacciNumbers {

    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static int fibonacci(int n) {
        if(n == 0 || n == 1) return n;

        if(!map.containsKey(n)){
            int fib = fibonacci(n - 1) + fibonacci(n - 2);
            map.put(n, fib);
        }

        return map.get(n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
