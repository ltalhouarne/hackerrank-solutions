import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BearAndSteadyGene {
    private static boolean isValid(Map<Character, Integer> freqMap, int need){
        return freqMap.get('A') <= need && freqMap.get('C') <= need && freqMap.get('T') <= need && freqMap.get('G') <= need;
    }

    private static boolean isValidAsIs(Map<Character, Integer> freqMap, int need){
        return freqMap.get('A') == need && freqMap.get('C') == need && freqMap.get('T') == need && freqMap.get('G') == need;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        char[] arr = scanner.next().toCharArray();

        int need = count >> 2;

        Map<Character, Integer> freqMap = new HashMap<>();

        freqMap.put('A', 0);
        freqMap.put('C', 0);
        freqMap.put('G', 0);
        freqMap.put('T', 0);

        IntStream
                .range(0, arr.length)
                .forEach(i -> freqMap.compute(arr[i], (k, v) -> ++v));

        if(isValidAsIs(freqMap, need)) System.out.println(0);
        else {
            int left = 0;
            int answer = arr.length;

            for(int i = 0; i < arr.length; i++) {
                freqMap.compute(arr[i], (k, v) -> --v);

                while(isValid(freqMap, need) && left < i){
                    answer = Math.min(answer, i - left + 1);
                    freqMap.compute(arr[left], (k1, v1) -> ++v1);
                    left++;
                }
            }

            System.out.println(answer);
        }
    }
}
