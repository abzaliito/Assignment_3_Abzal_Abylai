package org.example.algorithms;

import org.example.graph.Edge;
import org.example.graph.Graph;
import org.example.model.MSTResult;

import java.util.*;

public class PrimAlgorithm {

    private static class QEdge implements Comparable<QEdge> {
        String to;
        int weight;
        String parent;

        QEdge(String to, int weight, String parent) {
            this.to = to; this.weight = weight; this.parent = parent;
        }
        @Override public int compareTo(QEdge o) { return Integer.compare(this.weight, o.weight); }
    }

    public MSTResult run(Graph g) {
        long ops = 0;
        long t0 = System.currentTimeMillis();

        Set<String> vertices = g.getVertices();
        if (vertices.isEmpty()) return new MSTResult(Collections.emptyList(), 0, ops, 0);

        String start = vertices.iterator().next();
        Set<String> visited = new HashSet<>();
        PriorityQueue<QEdge> pq = new PriorityQueue<>();

        visited.add(start);
        for (Edge e : g.neighbors(start)) {
            pq.add(new QEdge(e.to, e.weight, start));
            ops++;
        }

        List<Edge> mst = new ArrayList<>();
        int total = 0;

        while (!pq.isEmpty() && visited.size() < vertices.size()) {
            QEdge cur = pq.poll(); ops++; // pop
            if (visited.contains(cur.to)) { ops++; continue; }

            visited.add(cur.to);
            mst.add(new Edge(cur.parent, cur.to, cur.weight));
            total += cur.weight;

            for (Edge ne : g.neighbors(cur.to)) {
                if (!visited.contains(ne.to)) {
                    pq.add(new QEdge(ne.to, ne.weight, cur.to));
                    ops++;
                } else {
                    ops++;
                }
            }
        }

        long dt = System.currentTimeMillis() - t0;
        return new MSTResult(mst, total, ops, dt);
    }
}
