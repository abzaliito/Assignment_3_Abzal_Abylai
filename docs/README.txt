# Assignment 3 — Optimization of a City Transportation Network (Minimum Spanning Tree)

**Student:** Abzal and Abylai
**Group:** SE-2414
**Language:** Java (Maven project)
**Date:** October 2025

---

## 1. Introduction

The goal of this assignment was to model a **city transportation network** as a weighted graph and find the **minimum set of roads** that connect all districts with the lowest total cost.
This is a classic problem known as the **Minimum Spanning Tree (MST)**.

To solve it, I implemented and compared two algorithms:
- **Prim’s algorithm**
- **Kruskal’s algorithm**

Both algorithms should produce the same total cost of the MST, although the structure (the exact edges) might differ.
After implementing them, I measured:
- Total construction cost (sum of MST edge weights)
- Number of operations (as a simple measure of algorithmic effort)
- Execution time in milliseconds
- Number of vertices and edges in the original graph

---

## 2. Problem Description

The city network is represented as a **weighted undirected graph**, where:
- Each **vertex** represents a city district
- Each **edge** represents a potential road
- Each **weight** represents the cost of constructing that road

The aim is to connect all districts such that:
1. Every district is reachable from every other.
2. The total construction cost is minimal.

---

## 3. Project Structure and Tools

** Language & tools:**
- Java 19
- Maven (for dependency management)
- JUnit 5 (for testing)
- Jackson (for reading and writing JSON files)


## 4. Implementation Details

### 4.1 Prim’s Algorithm
Prim’s algorithm builds the MST **incrementally**, starting from any vertex and always selecting the **smallest edge** that connects a visited vertex to an unvisited one.
It uses:
- A **Priority Queue (Min-Heap)** to efficiently choose the next minimum edge.
- A **visited set** to avoid cycles.

During execution, I counted key operations:
- Pushing and popping from the priority queue
- Checking visited vertices
I also measured the total time using `System.currentTimeMillis()`.

### 4.2 Kruskal’s Algorithm
Kruskal’s algorithm sorts all edges by weight and **adds them one by one**, as long as they don’t form a cycle.
It uses:
- **Disjoint Set (Union–Find)** structure to detect cycles quickly.
- Sorting of all edges before processing.

Here, I counted operations such as:
- Edge comparisons
- Union and Find calls in the Disjoint Set
- Path compression operations

Like in Prim’s, execution time was measured in milliseconds.

### 4.3 Data Handling
Input data was read from `input.json` using Jackson.
The structure includes multiple graphs; for this assignment I used the first one.
After both algorithms run, their results are written to `output.json`:
```json
{
  "input_stats": { "vertices": 4, "edges": 5 },
  "prim":     { "total_cost": 6, "operations": 42, "time_ms": 2 },
  "kruskal":  { "total_cost": 6, "operations": 37, "time_ms": 1 }
}

### 5. Example input
{
  "graphs": [
    {
      "id": 1,
      "nodes": ["A", "B", "C", "D"],
      "edges": [
        {"from": "A", "to": "B", "weight": 4},
        {"from": "A", "to": "C", "weight": 1},
        {"from": "B", "to": "C", "weight": 2},
        {"from": "B", "to": "D", "weight": 5},
        {"from": "C", "to": "D", "weight": 3}
      ]
    }
  ]
}

6. Results and Metrics
6.1 Manual Test Graph (A–D)
Algorithm	Total Cost	Operations	Time (ms)	MST Edges
Prim	6	42	2	A–C(1), C–B(2), C–D(3)
Kruskal	6	37	1	A–C(1), C–B(2), C–D(3)

Both algorithms produced the same total MST cost.
Slight difference in operation count is expected due to algorithmic differences.

6.2 JSON Graph (from input.json)
Algorithm	Total Cost	Operations	Time (ms)
Prim	16	125	3
Kruskal	16	110	2

Same total cost again — correctness confirmed.
Kruskal required fewer operations and was slightly faster.

7. Compare

Both algorithms successfully generated a valid MST with the same total cost.
However, they differ in how they build the tree and how efficiently they handle different graph types.

Aspect	Prim’s Algorithm	Kruskal’s Algorithm
Approach	Grows MST vertex by vertex	Sorts and merges edges
Data Structure	Priority Queue	Disjoint Set (Union–Find)
Time Complexity	O(E log V)	O(E log E)
Suitable for	Dense graphs	Sparse graphs
Memory usage	Slightly higher (stores PQ)	Lower
Implementation complexity	Moderate	Simple and compact

In practice:

Prim is efficient when there are many edges (dense graphs).

Kruskal performs better when the graph is sparse or when sorting edges is simple.

During my tests, the operation count and execution time showed Kruskal was slightly more efficient, but both worked correctly.

8. Conclusion

This project helped me better understand how minimum spanning trees are formed and the differences between edge-based and vertex-based approaches.

Main takeaways:

Both algorithms always produce the same total cost, confirming correctness.

Kruskal tends to perform slightly better in sparse networks due to fewer comparisons.

Prim is more suitable for dense graphs, especially with a good priority queue implementation.

Measuring operations and execution time helped me visualize algorithmic efficiency beyond just the final result.

Overall, both implementations worked as expected, and all results were successfully exported to output.json.

9. References

Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2009). Introduction to Algorithms (3rd ed.). MIT Press.

GeeksForGeeks. Difference Between Prim’s and Kruskal’s Algorithm.

Course materials – Assignment 3: Optimization of a City Transportation Network.

10.  Reflection

While coding this assignment, I had to carefully think about how to structure the graph and handle the data flow between algorithms, I/O, and result storage.
I also realized how helpful it is to measure not only the correctness of the algorithm but also its performance through simple metrics (operations and time).
Overall, I gained a clearer understanding of how MST algorithms work internally, and now I can easily choose which one to use depending on the graph structure.
