import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IceCreamParlor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];

            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }

            Map<Integer, Integer> sum = new HashMap<>();

            for(int a_i=0; a_i < n; a_i++){
                if(sum.containsKey(a[a_i])) {
                    System.out.println(sum.get(a[a_i]) + 1 + " " + (a_i + 1));
                    break;
                }
                else {
                    sum.put(m - a[a_i], a_i);
                }
            }

        }
    }
}
