package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.graph.Graph;
import org.example.algorithms.PrimAlgorithm;
import org.example.model.MSTResult;
import org.example.graph.Edge;

import java.util.List;

public class PrimAlgorithmTest {

    @Test
    public void testSimpleGraphMST() {
        // --- создаём тестовый граф ---
        Graph g = new Graph();
        g.addEdge("A", "B", 4);
        g.addEdge("A", "C", 1);
        g.addEdge("B", "C", 2);
        g.addEdge("B", "D", 5);
        g.addEdge("C", "D", 3);

        PrimAlgorithm prim = new PrimAlgorithm();
        MSTResult result = prim.run(g);

        assertEquals(6, result.totalCost, "Total cost must equal 6");
        assertEquals(3, result.mstEdges.size(), "MST should contain 3 edges");

        List<Edge> edges = result.mstEdges;
        boolean connected = edges.stream()
                .flatMap(e -> List.of(e.from, e.to).stream())
                .distinct()
                .count() == 4;
        assertTrue(connected, "MST should connect all 4 vertices");

        System.out.printf(
                "✅ Prim MST cost=%d, ops=%d, time=%d ms%n",
                result.totalCost, result.operations, result.timeMs
        );
    }
}
