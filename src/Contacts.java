import java.util.Scanner;

public class Contacts {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie trie = new Trie();

        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();

            if(op.equals("add")) trie.addWord(contact);
            else System.out.println(trie.findWord(contact));
        }
    }

    public static class Trie {
        Node root = new Node();

        public void addWord(String word){
            char[] arr = word.toCharArray();
            addChars(root, arr, 0);
        }

        public int findWord(String word) {
            char[] arr = word.toCharArray();

            Node node = root;
            int index = 0;

            while(node != null && index < arr.length) {
                node = findNode(node.children, arr[index++]);
            }

            if(node == null) return 0;
            else return node.count;
        }

        private Node findNode(Node[] children, char c){
            return children[c - 'a'];
        }

        private void addChars(Node node, char[] arr, int idx) {
            node.count++;
            if(idx == arr.length) return;

            Node child = findNode(node.children, arr[idx]);

            if(child == null) {
                Node newNode = new Node();
                node.children[arr[idx] - 'a'] = newNode;
                addChars(newNode, arr, idx + 1);
            } else {
                addChars(child, arr, idx + 1);
            }
        }
    }

    public static class Node {
        Node[] children = new Node[26];
        int count = 0;
    }
}
