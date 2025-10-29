package org.example.comparison;

import org.example.algorithms.*;
import org.example.graph.Graph;
import org.example.model.MSTResult;

public class MSTComparison {
    public static void compare(Graph g) {
        PrimAlgorithm prim = new PrimAlgorithm();
        KruskalAlgorithm kruskal = new KruskalAlgorithm();

        MSTResult r1 = prim.run(g);
        MSTResult r2 = kruskal.run(g);

        System.out.println("===== MST Comparison =====");
        System.out.println("Prim:    cost=" + r1.totalCost + ", ops=" + r1.operations + ", time=" + r1.timeMs + " ms");
        System.out.println("Kruskal: cost=" + r2.totalCost + ", ops=" + r2.operations + ", time=" + r2.timeMs + " ms");

        if (r1.totalCost == r2.totalCost) {
            System.out.println("✅ Both algorithms give the same MST total cost!");
        } else {
            System.out.println("Costs differ!");
        }
    }
}
