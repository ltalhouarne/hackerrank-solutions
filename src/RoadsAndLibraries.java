import java.util.*;

public class RoadsAndLibraries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int problemCount = scanner.nextInt();

        for(int i = 0; i < problemCount; i++) {
            Node[] cities = new Node[scanner.nextInt() + 1];
            int roads = scanner.nextInt();
            int libCost = scanner.nextInt();
            int roadCost = scanner.nextInt();

            Graph<Integer> graph = new Graph<>();

            for(int k = 1; k < cities.length; k++) {
                Node<Integer> node = new Node<>(k);
                cities[k] = node;
                graph.addNode(node);
            }

            for(int j = 0; j < roads; j++){
                graph.addEdge(cities[scanner.nextInt()], cities[scanner.nextInt()]);
            }

            Map<Node<Integer>, List<Node<Integer>>> map = graph.getMap();

            Set<Node<Integer>> nodesToVisit = map.keySet();

            int count = 0;
            int disconnectedLibs = 0;

            for(Node<Integer> node: nodesToVisit) {
                if(!node.visited) {
                    disconnectedLibs++;
                    count += getPath(node, map, 0);
                }
            }

            int allLibs = libCost * (cities.length - 1);
            int libAllRoads = roadCost * count + libCost * disconnectedLibs;

            if(allLibs <= libAllRoads) System.out.println(allLibs);
            else System.out.println(libAllRoads);
        }
    }

    static int getPath(Node<Integer> node, Map<Node<Integer>, List<Node<Integer>>> map, int count) {
        node.visited = true;

        List<Node<Integer>> neighbors = map.get(node);

        for(Node<Integer> neighbor: neighbors) {
            if(!neighbor.visited) {
                count = 1 + getPath(neighbor, map, count);
            }
        }

        return count;
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

        Map<Node<T>, List<Node<T>>> getMap(){
            return this.map;
        }

    }

    static class Node<T> {
        T data;
        boolean visited;

        Node(T data) {
            this.data = data;
        }

        public String toString(){
            return data + "";
        }

        public boolean equals(Object o){
            return o instanceof Node ? this.data.equals(((Node) o).data): false;
        }

        public int hashCode() {
            return data.hashCode();
        }
    }
}
