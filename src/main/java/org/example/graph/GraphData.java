package org.example.graph;

import java.util.List;

public class GraphData {
    public int id;
    public List<String> nodes;
    public List<EdgeData> edges;

    public Graph toGraph() {
        Graph g = new Graph();
        for (EdgeData e : edges) {
            g.addEdge(e.from, e.to, e.weight);
        }
        return g;
    }
}
