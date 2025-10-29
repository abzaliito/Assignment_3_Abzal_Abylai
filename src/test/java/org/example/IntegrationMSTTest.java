package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.io.InputReader;
import org.example.graph.Graph;
import org.example.algorithms.PrimAlgorithm;
import org.example.algorithms.KruskalAlgorithm;
import org.example.model.MSTResult;

public class IntegrationMSTTest {

    @Test
    public void testJsonInputComparison() throws Exception {
        Graph g = InputReader.loadGraph("src/main/resources/input.json");

        PrimAlgorithm prim = new PrimAlgorithm();
        KruskalAlgorithm kruskal = new KruskalAlgorithm();

        MSTResult r1 = prim.run(g);
        MSTResult r2 = kruskal.run(g);

        System.out.printf(
                "Prim: cost=%d ops=%d time=%d ms%n",
                r1.totalCost, r1.operations, r1.timeMs
        );
        System.out.printf(
                "Kruskal: cost=%d ops=%d time=%d ms%n",
                r2.totalCost, r2.operations, r2.timeMs
        );

        assertEquals(r1.totalCost, r2.totalCost, "MST total cost must match");
    }
}
