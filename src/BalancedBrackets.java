import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String expression) {
        String[] expressionArr = expression.split("");
        Stack<String> stack = new Stack();

        for(String str: expressionArr){
            if(stack.isEmpty() && (str.equals("}") || str.equals("]") || str.equals(")"))) return false;

            if(str.equals("{") || str.equals("[") || str.equals("(")){
                stack.push(str);
            } else if(str.equals(")") && !stack.pop().equals("(")) {
                return false;
            } else if(str.equals("]") && !stack.pop().equals("[")) {
                return false;
            } else if(str.equals("}") && !stack.pop().equals("{")) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
