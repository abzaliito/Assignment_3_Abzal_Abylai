package org.example.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.graph.*;

import java.io.File;

public class InputReader {

    public static Graph loadGraph(String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Читаем обёртку с полем "graphs"
        InputData data = mapper.readValue(new File(path), InputData.class);

        // Берём первый граф (если их несколько)
        GraphData gdata = data.graphs.get(0);

        // Преобразуем GraphData → Graph
        return gdata.toGraph();
    }
}
