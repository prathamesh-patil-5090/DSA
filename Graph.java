import java.util.*;
import java.util.LinkedList;

class Graph {
    private Map<Integer, List<Pair>> adj;
    private boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        this.adj = new HashMap<>();
    }

    // Helper pair class for weighted edges
    class Pair {
        int node, weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // Add a vertex
    public void addVertex(int v) {
        adj.putIfAbsent(v, new ArrayList<>());
    }

    // Add edge
    public void addEdge(int u, int v, int weight) {
        adj.putIfAbsent(u, new ArrayList<>());
        adj.putIfAbsent(v, new ArrayList<>());
        adj.get(u).add(new Pair(v, weight));
        if (!isDirected)
            adj.get(v).add(new Pair(u, weight));
    }

    // Remove edge
    public void removeEdge(int u, int v) {
        adj.get(u).removeIf(p -> p.node == v);
        if (!isDirected)
            adj.get(v).removeIf(p -> p.node == u);
    }

    // Remove vertex
    public void removeVertex(int v) {
        adj.remove(v);
        for (List<Pair> neighbors : adj.values())
            neighbors.removeIf(p -> p.node == v);
    }

    public void display() {
        System.out.println("Graph Adjacency List:");
        for (int node : adj.keySet()) {
            System.out.print(node + " → ");
            for (Pair neighbor : adj.get(node)) {
                System.out.print("(" + neighbor.node + ", weight: " + neighbor.weight + ") ");
            }
            System.out.println();
        }
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    public void dfsHelper(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");
        for (Pair neighbour : adj.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbour.node)) {
                dfsHelper(neighbour.node, visited);
            }
        }
    }

    public void bfs(int start){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited.add(start);
        System.out.println("BFS: ");

        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.println(curr + " ");
            for(Pair neighbour : adj.getOrDefault(curr, new ArrayList<>())){
                if(!visited.contains(neighbour.node)){
                    visited.add(neighbour.node);
                    q.add(neighbour.node);
                }
            }
        }
        System.out.println();
    }

    // Detect cycle (undirected)
    public boolean hasCycleUndirected() {
        Set<Integer> visited = new HashSet<>();
        for (int node : adj.keySet()) {
            if (!visited.contains(node)) {
                if (dfsCycleUndirected(node, -1, visited)) return true;
            }
        }
        return false;
    }

    private boolean dfsCycleUndirected(int node, int parent, Set<Integer> visited) {
        visited.add(node);
        for (Pair neighbor : adj.get(node)) {
            if (!visited.contains(neighbor.node)) {
                if (dfsCycleUndirected(neighbor.node, node, visited)) return true;
            } else if (neighbor.node != parent) {
                return true;
            }
        }
        return false;
    }

    // Detect cycle (directed)
    public boolean hasCycleDirected() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();
        for (int node : adj.keySet()) {
            if (dfsCycleDirected(node, visited, recursionStack)) return true;
        }
        return false;
    }

    private boolean dfsCycleDirected(int node, Set<Integer> visited, Set<Integer> stack) {
        if (stack.contains(node)) return true;
        if (visited.contains(node)) return false;
        visited.add(node);
        stack.add(node);
        for (Pair neighbor : adj.get(node)) {
            if (dfsCycleDirected(neighbor.node, visited, stack)) return true;
        }
        stack.remove(node);
        return false;
    }

    //Topological Sort
    public void topologicalSort(){
        if(!isDirected){
            System.out.println("Topological Sort only works on directed acyclic graphs(DAGs)");
            return;
        }
        Map<Integer, Integer> inDegree = new HashMap<>();
        for(int u : adj.keySet()){
            for(Pair v : adj.get(u)){
                inDegree.put(v.node, inDegree.getOrDefault(v.node, 0) + 1);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int node : adj.keySet()){
            if(inDegree.getOrDefault(node, 0) == 0){
                q.add(node);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            topo.add(curr);

            for(Pair neighbour : adj.getOrDefault(curr, new ArrayList<>())){
                inDegree.put(neighbour.node, inDegree.get(neighbour.node) - 1);
                if(inDegree.get(neighbour.node) == 0){
                    q.add(neighbour.node);
                }
            }
        }

        if(topo.size() != adj.size()){
            System.out.println("Graph contains cycles, topological sort is not possible");
        }{
            System.out.println("Topological Sort is : " + topo);
        }
    }

    //Shortest Path in unweighted graphs
    public void shortestPathUnweighted(int start){
        Map<Integer, Integer> dist = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        dist.put(start, 0);
        q.add(start);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(Pair neighbour : adj.getOrDefault(curr, new ArrayList<>())){
                if(!dist.containsKey(neighbour.node)){
                    dist.put(neighbour.node, dist.get(curr));
                    q.add(neighbour.node);
                }
            }
        }
        System.out.println("Shortest Path (Unweighted) from " + start + " : " + dist);
    }

    //Dijkstra's Algorith to find shortest path in weighted graph
    public void dijkstra(int start){
        Map<Integer, Integer> dist = new HashMap<>();
        for(int node : adj.keySet()){
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(start, 0);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(p -> p.weight));
        pq.add(new Pair(start, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.weight > dist.get(curr.node)) continue;
            for(Pair neighbour : adj.get(curr.node)){
                int newDist = neighbour.weight + dist.get(curr.node);
                if(newDist < dist.get(neighbour.node)){
                    dist.put(neighbour.node, newDist);
                    pq.add(new Pair(neighbour.node, newDist));
                }
            }
        }
        System.out.println("Dijkstra from : " + start + ": " + dist);
    }

    public static void main(String[] args) {
        Graph g = new Graph(false);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 4, 1);
        g.addEdge(3, 4, 1);
        g.addEdge(4, 5, 1);

        g.dfs(1);
        g.bfs(1);
        System.out.println("Has Cycle (Undirected): " + g.hasCycleUndirected());

        g.shortestPathUnweighted(1);
        g.dijkstra(1);
    }
}