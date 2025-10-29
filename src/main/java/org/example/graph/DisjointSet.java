package org.example.graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private final Map<String, String> parent = new HashMap<>();
    private final Map<String, Integer> rank = new HashMap<>();

    public long finds = 0;
    public long unions = 0;
    public long pathCompressions = 0;

    public void makeSet(Iterable<String> items) {
        for (String x : items) {
            parent.put(x, x);
            rank.put(x, 0);
        }
    }

    public String find(String x) {
        finds++;
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x)));
            pathCompressions++;
        }
        return parent.get(x);
    }

    public boolean union(String a, String b) {
        unions++;
        String ra = find(a);
        String rb = find(b);
        if (ra.equals(rb)) return false;

        int rka = rank.get(ra), rkb = rank.get(rb);
        if (rka < rkb) {
            parent.put(ra, rb);
        } else if (rka > rkb) {
            parent.put(rb, ra);
        } else {
            parent.put(rb, ra);
            rank.put(ra, rka + 1);
        }
        return true;
    }
}
