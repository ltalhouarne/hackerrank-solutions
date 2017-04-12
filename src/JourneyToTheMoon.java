import java.util.*;
import java.util.stream.Collectors;

public class JourneyToTheMoon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Node<Integer>[] astronauts = new Node[scanner.nextInt()];
        int pairCount = scanner.nextInt();

        Graph<Integer> graph = new Graph<>();

        for(int i = 0; i < astronauts.length; i++) {
            Node<Integer> node = new Node(i);
            astronauts[i] = node;
            graph.addNode(node);
        }

        Map<Node<Integer>, List<Node<Integer>>> map = graph.map;

        for(int i = 0; i < pairCount; i++) {
            graph.addEdge(astronauts[scanner.nextInt()], astronauts[scanner.nextInt()]);
        }

        Set<Node<Integer>> nodesToVisit = map.keySet();
        Set<Set<Node<Integer>>> sets = new HashSet<>();

        for(Node<Integer> node: nodesToVisit) {
            if (!node.visited) {
                Set<Node<Integer>> set = new HashSet<>();
                set.add(node);
                sets.add(dfsPath(node, set, map));
            }
        }

        nodesToVisit.removeAll(sets.stream().flatMap(set -> set.stream()).collect(Collectors.toSet()));

        for(Node<Integer> node: nodesToVisit) {
            Set<Node<Integer>> set = new HashSet<>();
            set.add(node);
            sets.add(set);
        }

        long sum = 0;
        long result = 0;

        for(Set<Node<Integer>> set : sets)
        {
            result += sum * set.size();
            sum += set.size();
        }

        System.out.println(result);
    }

    static Set<Node<Integer>> dfsPath(Node<Integer> node, Set<Node<Integer>> path, Map<Node<Integer>, List<Node<Integer>>> map) {
        node.visited = true;

        List<Node<Integer>> neighbors = map.get(node);

        for(Node<Integer> neighbor: neighbors) {
            if(!neighbor.visited) {
                path.add(neighbor);
                neighbor.visited = true;
                dfsPath(neighbor, path, map);
            }
        }

        return path;
    }

    static class Graph<T> {
        Map<Node<T>, List<Node<T>>> map = new HashMap<>();

        void addNode(Node<T> node) {
            map.computeIfAbsent(node, v -> new LinkedList<>());
        }

        void addEdge(Node<T> node, Node<T> edge) {
            map.computeIfAbsent(node, v -> new LinkedList<>()).add(edge);
            map.computeIfAbsent(edge, v -> new LinkedList<>()).add(node);
        }
    }

    static class Node<T> {
        T data;
        boolean visited;

        Node(T data) {
            this.data = data;
        }
    }
}
