package org.example.graph;

import java.util.*;

public class Graph {
    private final Map<String, List<Edge>> adj = new HashMap<>();
    private final Set<String> vertices = new HashSet<>();

    public void addEdge(String u, String v, int w) {
        vertices.add(u); vertices.add(v);
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(u, v, w));
        adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge(v, u, w)); // неориентированный
    }

    public Set<String> getVertices() {
        return Collections.unmodifiableSet(vertices);
    }

    public List<Edge> neighbors(String u) {
        return adj.getOrDefault(u, Collections.emptyList());
    }
    public List<Edge> getAllEdgesUnique() {
        Set<Edge> uniq = new HashSet<>();
        for (String u : adj.keySet()) {
            for (Edge e : adj.get(u)) {
                uniq.add(new Edge(e.from, e.to, e.weight));
            }
        }
        return new ArrayList<>(uniq);
    }

    public int vertexCount() { return vertices.size(); }

    public int edgeCountUndirected() { return getAllEdgesUnique().size(); }
}
