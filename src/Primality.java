import java.util.Scanner;

public class Primality {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();

        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            boolean prime = true;

            if(n == 1) System.out.println("Not prime");
            else if(n == 2) System.out.println("Prime");
            else {
                for(int i = 2; i * i <= n; i++){
                    if(n % i == 0) {
                        prime = false;
                        break;
                    }
                }
                System.out.println(prime ? "Prime" : "Not prime");
            }
        }
    }
}
