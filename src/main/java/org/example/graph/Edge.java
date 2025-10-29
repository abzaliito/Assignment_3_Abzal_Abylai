package org.example.graph;

import java.util.Objects;

public class Edge implements Comparable<Edge> {
    public final String from;
    public final String to;
    public final int weight;

    public Edge(String from, String to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }

    public String ukey() {
        String a = from.compareTo(to) <= 0 ? from : to;
        String b = from.compareTo(to) <= 0 ? to   : from;
        return a + "—" + b + ":" + weight;
    }

    @Override
    public String toString() {
        return from + "-" + to + "(" + weight + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Edge)) return false;
        Edge e = (Edge) o;
        boolean samePair = (Objects.equals(from, e.from) && Objects.equals(to, e.to))
                || (Objects.equals(from, e.to)   && Objects.equals(to, e.from));
        return samePair && weight == e.weight;
    }

    @Override
    public int hashCode() {
        String a = from.compareTo(to) <= 0 ? from : to;
        String b = from.compareTo(to) <= 0 ? to   : from;
        return Objects.hash(a, b, weight);
    }
}
