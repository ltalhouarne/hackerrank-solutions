public class IsBinarySearchTree {

    boolean checkBST(Node node) {
        return checkBSTMinMax(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBSTMinMax(Node node, int min, int max){
        if(node == null) return true;
        if(node.data < min || node.data > max) return false;
        return checkBSTMinMax(node.left, min, node.data - 1) && checkBSTMinMax(node.right, node.data + 1, max);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
