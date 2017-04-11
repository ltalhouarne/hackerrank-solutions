import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SherlockAndValidString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] arr = scanner.next().toCharArray();

        Map<Character, Integer> freqMap = new HashMap<Character, Integer>();

        IntStream
                .range(0, arr.length)
                .forEach(index -> freqMap.compute(arr[index], (k, v) -> v == null ? 1 : ++v));

        Map<Integer, Integer> freqCountMap = new HashMap<Integer, Integer>();

        for(Map.Entry<Character, Integer> entry: freqMap.entrySet()){
            freqCountMap.compute(entry.getValue(), (k, v) -> v == null ? 1 : ++v);
        }

        boolean valid = false;

        if(freqCountMap.size() == 1) valid = true;
        else if(freqCountMap.size() > 2) valid = false;
        else {
            for(Integer i: freqCountMap.values()) {
                if(i == 1) {
                    valid = true;
                    break;
                }
            }
        }

        System.out.println(valid ? "YES" : "NO");
    }
}
