package org.example.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.graph.Graph;
import org.example.model.MSTResult;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class OutputWriter {
    public static void saveResult(String path, Graph inputGraph,
                                  MSTResult prim, MSTResult kruskal) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> root = new HashMap<>();

        Map<String, Object> inputStats = new HashMap<>();
        inputStats.put("vertices", inputGraph.vertexCount());
        inputStats.put("edges", inputGraph.edgeCountUndirected());
        root.put("input_stats", inputStats);

        Map<String, Object> primMap = new HashMap<>();
        primMap.put("total_cost", prim.totalCost);
        primMap.put("operations", prim.operations);
        primMap.put("time_ms", prim.timeMs);
        primMap.put("mst_edges", prim.mstEdges);
        root.put("prim", primMap);

        Map<String, Object> kruskalMap = new HashMap<>();
        kruskalMap.put("total_cost", kruskal.totalCost);
        kruskalMap.put("operations", kruskal.operations);
        kruskalMap.put("time_ms", kruskal.timeMs);
        kruskalMap.put("mst_edges", kruskal.mstEdges);
        root.put("kruskal", kruskalMap);

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), root);
    }
}
