import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        HashMap<String, Integer> map = new HashMap();
        boolean success = true;

        for(int i=0; i < m; i++){
            String magStr = in.next();
            Integer magCount = map.get(magStr);
            if(magCount == null) map.put(magStr, 1);
            else map.put(magStr, ++magCount);
        }

        for(int j=0; j < n; j++){
            String ranStr = in.next();
            Integer ranCount = map.get(ranStr);
            if(ranCount != null && ranCount > 0) map.put(ranStr, --ranCount);
            else {
                success = false;
                break;
            }
        }

        System.out.println(success ? "Yes" : "No");
    }
}
