import java.util.*;
import java.util.stream.Collectors;

public class BuildOrder {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();

        Set<Node<String>> projects = new LinkedHashSet<>();

        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");

        projects.add(a);
        projects.add(b);
        projects.add(c);
        projects.add(d);
        projects.add(e);
        projects.add(f);

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);

        graph.addEdge("a", "d");
        graph.addEdge("f", "b");
        graph.addEdge("b", "d");
        graph.addEdge("f", "a");
        graph.addEdge("d", "a");

        Set<Node<String>> order = buildOrder(graph, projects, new LinkedHashSet<>());

        if (order != null) {
            order.forEach(System.out::print);
        } else {
            System.out.println("Not possible.");
        }
    }

    static Set<Node<String>> buildOrder(Graph<String> graph, Set<Node<String>> projects, Set<Node<String>> path) {

        if (graph.map.isEmpty()) {
            return path;
        }

        int size = graph.map.size();

        Set<Node<String>> projectsWithDependencies = graph
                .map
                .values()
                .stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toSet());

        Set<Node<String>> projectsCopy = new HashSet<>(projects);

        projects
                .removeAll(projectsWithDependencies);

        projects.forEach(project -> {
            if (!path.contains(project)) {
                path.add(project);
            }
            graph.map.remove(project);
        });

        projects = projectsCopy;

        int sizeAfter = graph.map.size();

        if (size == sizeAfter) {
            return null;
        }

        return buildOrder(graph, projects, path);
    }

    static class Graph<T> {
        Map<Node<T>, Set<Node<T>>> map = new HashMap<>();

        void addNode(T value) {
            addNode(new Node<>(value));
        }

        void addNode(Node<T> node) {
            map.computeIfAbsent(node, v -> new LinkedHashSet<>());
        }

        void addEdge(T val1, T val2) {
            addEdge(new Node<>(val1), new Node<>(val2));
        }

        void addEdge(Node<T> node, Node<T> edge) {
            map.computeIfAbsent(node, v -> new LinkedHashSet<>()).add(edge);
        }
    }

    static class Node<T> {
        T data;

        Node(T data) {
            this.data = data;
        }

        public boolean equals(Object o) {
            if (o instanceof Node) {
                return data.equals(((Node) o).data);
            } else {
                System.out.println("false");
                return false;
            }
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return data + "";
        }
    }
}
