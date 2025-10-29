package org.example;

import org.example.algorithms.KruskalAlgorithm;
import org.example.algorithms.PrimAlgorithm;
import org.example.graph.Graph;
import org.example.io.InputReader;
import org.example.io.OutputWriter;
import org.example.model.MSTResult;

public class Main {
    public static void main(String[] args) throws Exception {
        Graph manualGraph = new Graph();
        manualGraph.addEdge("A", "B", 4);
        manualGraph.addEdge("A", "C", 1);
        manualGraph.addEdge("B", "C", 2);
        manualGraph.addEdge("B", "D", 5);
        manualGraph.addEdge("C", "D", 3);

        PrimAlgorithm primAlgo = new PrimAlgorithm();
        KruskalAlgorithm kruskalAlgo = new KruskalAlgorithm();

        MSTResult manualPrim = primAlgo.run(manualGraph);
        MSTResult manualKruskal = kruskalAlgo.run(manualGraph);

        System.out.println("==== Manual Graph ====");
        System.out.println("Prim:    cost=" + manualPrim.totalCost +
                " ops=" + manualPrim.operations +
                " ms=" + manualPrim.timeMs);
        System.out.println("Kruskal: cost=" + manualKruskal.totalCost +
                " ops=" + manualKruskal.operations +
                " ms=" + manualKruskal.timeMs);
        System.out.println("Prim MST: " + manualPrim.mstEdges);
        System.out.println("Kruskal MST: " + manualKruskal.mstEdges);
        System.out.println();

        Graph jsonGraph = InputReader.loadGraph("src/main/resources/input.json");

        MSTResult jsonPrim = primAlgo.run(jsonGraph);
        MSTResult jsonKruskal = kruskalAlgo.run(jsonGraph);

        System.out.println("==== JSON Graph ====");
        System.out.println("Prim:    cost=" + jsonPrim.totalCost +
                " ops=" + jsonPrim.operations +
                " ms=" + jsonPrim.timeMs);
        System.out.println("Kruskal: cost=" + jsonKruskal.totalCost +
                " ops=" + jsonKruskal.operations +
                " ms=" + jsonKruskal.timeMs);
        System.out.println("Prim MST: " + jsonPrim.mstEdges);
        System.out.println("Kruskal MST: " + jsonKruskal.mstEdges);
        System.out.println();

        OutputWriter.saveResult(
                "src/main/resources/output.json",
                jsonGraph,
                jsonPrim,
                jsonKruskal
        );
        System.out.println("✅ Results saved to output.json");

    }
}
