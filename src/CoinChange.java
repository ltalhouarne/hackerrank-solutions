import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];

        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }

        System.out.println(count(coins, n, 0, new HashMap<>()));
    }

    public static long count(int[] coins, int money, int index, Map<String, Long> map) {
        if(money == 0) return 1;
        if(index >= coins.length) return 0;

        int amount = 0;
        long count = 0;

        String key = money + "-" + index;

        if(map.containsKey(key)) {
            return map.get(key);
        }

        while(amount <= money){
            int remaining = money - amount;
            count += count(coins, remaining, index + 1, map);
            amount += coins[index];
        }

        map.put(key, count);

        return count;
    }
}
