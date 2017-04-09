import java.util.*;
import java.util.stream.IntStream;

public class ShortestReachInGraph {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        IntStream
                .range(0, count)
                .forEach(idx -> {
                    int nodeCount = scanner.nextInt();
                    int edgeCount = scanner.nextInt();

                    HashMap<Integer, List<Integer>> graph = new HashMap<>();

                    IntStream
                            .range(1, nodeCount + 1)
                            .forEach(i -> graph.put(i, new LinkedList<>()));

                    IntStream
                            .range(0, edgeCount)
                            .forEach(i -> {
                                int node = scanner.nextInt();
                                int node2 = scanner.nextInt();

                                graph.get(node).add(node2);
                                graph.get(node2).add(node);
                            });

                    int startingIdx = scanner.nextInt();
                    int[] distances = getDistances(graph, startingIdx);

                    for(int i = 1; i < distances.length; i++) {
                        if(distances[i] != 0) System.out.print(distances[i]  + " ");
                    }

                    System.out.println();
                });
    }

    private static int[] getDistances(HashMap<Integer, List<Integer>> graph, int startNode)     {
        int[] distances = new int[graph.size() + 1];
        Arrays.fill(distances, -1);

        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Integer> nodesToVisit = new LinkedList<>();

        distances[startNode] = 0;
        nodesToVisit.add(startNode);
        visitedNodes.add(startNode);

        while(!nodesToVisit.isEmpty()) {
            int node = nodesToVisit.poll();
            List<Integer> neighbors = graph.get(node);

            neighbors.forEach(neighbor -> {
                if(!visitedNodes.contains(neighbor)){
                    distances[neighbor] = distances[node] + 6;
                    visitedNodes.add(neighbor);
                    nodesToVisit.add(neighbor);
                }
            });
        }

        return distances;
    }
}
