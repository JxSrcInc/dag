package com.example.app.dag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestPathDAG {
    private List<Vertex> vertices;
    private List<Edge> edges;

    public LongestPathDAG(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void longestPath(Vertex start) {
        int[] dist = new int[vertices.size()];
        Arrays.fill(dist, Integer.MIN_VALUE);

        dist[vertices.indexOf(start)] = 0;

        // Perform topological sort
        List<Vertex> topOrder = topologicalSort();

        // Process vertices in topological order
        for (Vertex vertex : topOrder) {
            for (Edge edge : edges) {
                if (edge.from.equals(vertex) && dist[vertices.indexOf(vertex)] != Integer.MIN_VALUE &&
                        dist[vertices.indexOf(vertex)] + edge.weight > dist[vertices.indexOf(edge.to)]) {
                    dist[vertices.indexOf(edge.to)] = dist[vertices.indexOf(vertex)] + edge.weight;
                }
            }
        }

        // Print the longest path distances
        for (int i = 0; i < vertices.size(); i++) {
        	if(dist[i] == Integer.MIN_VALUE)
        		continue;
            System.out.println("Longest path to vertex " + vertices.get(i).id + ": " + dist[i]);
        }
    }

    private List<Vertex> topologicalSort() {
        List<Vertex> result = new ArrayList<>();
        boolean[] visited = new boolean[vertices.size()];

        for (Vertex vertex : vertices) {
            if (!visited[vertices.indexOf(vertex)]) {
                topologicalSortUtil(vertex, visited, result);
            }
        }

        Collections.reverse(result);
        return result;
    }

    private void topologicalSortUtil(Vertex v, boolean[] visited, List<Vertex> result) {
        visited[vertices.indexOf(v)] = true;
        for (Edge edge : edges) {
            if (edge.from.equals(v) && !visited[vertices.indexOf(edge.to)]) {
                topologicalSortUtil(edge.to, visited, result);
            }
        }
        result.add(v);
    }


}
