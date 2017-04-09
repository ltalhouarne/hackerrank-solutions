import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class PossibleArraysFromTree {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(10);

        Node<Integer> node1 = new Node<>(5);
        Node<Integer> node2 = new Node<>(3);
        Node<Integer> node3 = new Node<>(1);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(8);
        Node<Integer> node6 = new Node<>(7);
        Node<Integer> node7 = new Node<>(9);

        Node<Integer> node8 = new Node<>(15);
        Node<Integer> node9 = new Node<>(13);
        Node<Integer> node10 = new Node<>(11);
        Node<Integer> node11 = new Node<>(14);
        Node<Integer> node12 = new Node<>(20);
        Node<Integer> node13 = new Node<>(16);
        Node<Integer> node14 = new Node<>(22);

        root.left = node1;
        root.right = node8;

        node1.left = node2;
        node1.right = node5;

        node2.left = node3;
        node2.right = node4;

        node5.left = node6;
        node5.right = node7;

        node8.left = node9;
        node8.right = node12;

        node9.left = node10;
        node9.right = node11;

        node12.left = node13;
        node12.right = node14;


        //                                  10
        //                               /      \
        //                              /        \
        //                            5           15
        //                          /   \       /    \
        //                         3     8     13     20
        //                        / \   / \   / \     / \
        //                       1   4 7   9 11  14  16  25


        Set<LinkedList<Node<Integer>>> arrays = possibleArrays(root);
        AtomicInteger count = new AtomicInteger(0);

        arrays.forEach(list -> {
            list.forEach(System.out::print);
            System.out.println();
            count.set(count.get() + 1);
        });

        System.out.print("Total permutations count: " + count);
    }

    static Set<LinkedList<Node<Integer>>> possibleArrays(Node<Integer> node){
        if(node == null) {
            LinkedList<Node<Integer>> list = new LinkedList<>();
            Set<LinkedList<Node<Integer>>> emptyListSet = new HashSet<>();
            emptyListSet.add(list);
            return emptyListSet;
        }

        Set<LinkedList<Node<Integer>>> leftLists = possibleArrays(node.left);
        Set<LinkedList<Node<Integer>>> rightLists = possibleArrays(node.right);
        Set<LinkedList<Node<Integer>>> perms = new HashSet<>();

        for(LinkedList<Node<Integer>> leftList: leftLists) {
            for(LinkedList<Node<Integer>> rightList: rightLists) {
                LinkedList<Node<Integer>> lList = new LinkedList<>();
                LinkedList<Node<Integer>> rList = new LinkedList<>();

                if(leftList.isEmpty() && rightList.isEmpty()) {
                    LinkedList<Node<Integer>> singleItem = new LinkedList<>();
                    singleItem.add(node);
                    perms.add(singleItem);
                } else {
                    lList.add(node);
                    lList.addAll(leftList);
                    lList.addAll(rightList);

                    rList.add(node);
                    rList.addAll(rightList);
                    rList.addAll(leftList);

                    perms.add(lList);
                    perms.add(rList);
                }
            }
        }

        return perms;
    }

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }

        public String toString() {
            return data + "";
        }
    }
}
