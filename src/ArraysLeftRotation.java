import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArraysLeftRotation {

    public static int numberNeeded(String first, String second) {
        String[] firstArr = first.split("");
        String[] secondArr = second.split("");
        Map<String, Integer> map = new HashMap();

        int count = 0;

        for(String str: firstArr){
            Integer val = map.get(str);
            if(val != null) map.put(str, ++val);
            else map.put(str, 1);
        }

        for(String str: secondArr){
            Integer val2 = map.get(str);
            if(val2 != null && val2 > 0) map.put(str, --val2);
            else count++;
        }

        for (Integer value : map.values()) {
            if(value > 0) count += value;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
