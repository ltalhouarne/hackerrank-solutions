import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class ATaleOfTwoStacks {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    private static class MyQueue<T> {

        Stack<T> stack1 = new Stack();
        Stack<T> stack2 = new Stack();

        private void enqueue(T item){
            stack1.push(item);
        }

        private void dequeue(){
            if(stack2.isEmpty()) emptyFirstStackIntoSecondOne(stack1, stack2);
            stack2.pop();
        }


        private T peek(){
            if(stack2.isEmpty()) emptyFirstStackIntoSecondOne(stack1, stack2);
            return stack2.peek();
        }

        private void emptyFirstStackIntoSecondOne(Stack firstStack, Stack secondStack){
            Iterator iterator = firstStack.iterator();

            while(iterator.hasNext()){
                secondStack.push(firstStack.pop());
            }
        }
    }
}
