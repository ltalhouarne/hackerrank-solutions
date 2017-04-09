import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class FindTheRunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Queue<Double> bottomHalf = new PriorityQueue(n >> 1 + 1, (Collections.reverseOrder()));
        Queue<Double> topHalf = new PriorityQueue(n >> 1 + 1);

        for (int i = 0; i < n; i++) {
            double num = in.nextDouble();

            if(i == 0) {
                System.out.println(num);
                bottomHalf.add(num);
                continue;
            } else if(topHalf.size() == 0) {
                if(num < bottomHalf.peek()) {
                    topHalf.add(bottomHalf.poll());
                    bottomHalf.add(num);
                } else {
                    topHalf.add(num);
                }
                System.out.println((bottomHalf.peek() + topHalf.peek()) / 2);
                continue;
            }

            if(bottomHalf.size() == topHalf.size()) {
                if(num > bottomHalf.peek()) {
                    topHalf.add(num);
                } else {
                    bottomHalf.add(num);
                }
            } else if(bottomHalf.size() > topHalf.size()){
                if(num >= bottomHalf.peek()) {
                    topHalf.add(num);
                } else {
                    topHalf.add(bottomHalf.poll());
                    bottomHalf.add(num);
                }
            } else {
                if(num <= topHalf.peek()) {
                    bottomHalf.add(num);
                } else {
                    bottomHalf.add(topHalf.poll());
                    topHalf.add(num);
                }
            }

            if(bottomHalf.size() == topHalf.size()){
                System.out.println((bottomHalf.peek() + topHalf.peek()) / 2);
            } else {
                System.out.println(bottomHalf.size() > topHalf.size() ? bottomHalf.peek() : topHalf.peek());
            }
        }
    }
}
