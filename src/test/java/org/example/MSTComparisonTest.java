package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.example.graph.Graph;
import org.example.algorithms.PrimAlgorithm;
import org.example.algorithms.KruskalAlgorithm;
import org.example.model.MSTResult;

public class MSTComparisonTest {
@Test
public void testSameMSTCost() {
    Graph g = new Graph();
    g.addEdge("A","B",3);
    g.addEdge("A","C",1);
    g.addEdge("B","C",2);

    PrimAlgorithm prim = new PrimAlgorithm();
    KruskalAlgorithm kruskal = new KruskalAlgorithm();
    MSTResult r1 = prim.run(g);
    MSTResult r2 = kruskal.run(g);

    assertEquals(r1.totalCost, r2.totalCost, "MST total cost must be equal");
    }
}