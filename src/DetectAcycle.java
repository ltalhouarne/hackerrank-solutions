public class DetectAcycle {
    boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        int i = 0;

        while (head.next != null && i < 101) {
            i++;
            head.next = head.next.next;
        }

        return !(i < 101);
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
