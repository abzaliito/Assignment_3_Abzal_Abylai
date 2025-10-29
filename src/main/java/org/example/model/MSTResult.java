package org.example.model;

import org.example.graph.Edge;
import java.util.List;

public class MSTResult {
    public final List<Edge> mstEdges;
    public final int totalCost;
    public final long operations; 
    public final long timeMs;

    public MSTResult(List<Edge> mstEdges, int totalCost, long operations, long timeMs) {
        this.mstEdges = mstEdges;
        this.totalCost = totalCost;
        this.operations = operations;
        this.timeMs = timeMs;
    }
}
