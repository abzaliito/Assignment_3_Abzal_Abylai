package org.example.algorithms;

import org.example.graph.DisjointSet;
import org.example.graph.Edge;
import org.example.graph.Graph;
import org.example.model.MSTResult;

import java.util.*;

public class KruskalAlgorithm {

    public MSTResult run(Graph g) {
        long ops = 0;
        long t0 = System.currentTimeMillis();

        List<Edge> edges = g.getAllEdgesUnique();
        Collections.sort(edges);

        DisjointSet ds = new DisjointSet();
        ds.makeSet(g.getVertices());

        List<Edge> mst = new ArrayList<>();
        int total = 0;

        for (Edge e : edges) {
            ops++;
            String a = e.from, b = e.to;
            if (ds.union(a, b)) {
                mst.add(e);
                total += e.weight;
                if (mst.size() == g.vertexCount() - 1) break;
            }
        }

        ops += ds.finds + ds.unions + ds.pathCompressions;

        long dt = System.currentTimeMillis() - t0;
        return new MSTResult(mst, total, ops, dt);
    }
}
