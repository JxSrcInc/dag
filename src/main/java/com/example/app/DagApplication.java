package com.example.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.app.dag.Edge;
import com.example.app.dag.LongestPathDAG;
import com.example.app.dag.Vertex;

@SpringBootApplication
public class DagApplication {

	public static void main(String[] args) {
		SpringApplication.run(DagApplication.class, args);
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        List<Vertex> vertices = new ArrayList<>();
        Collections.addAll(vertices, v0, v1, v2, v3, v4, v5);

        Edge e01 = new Edge(v0, v1, 5);
        Edge e02 = new Edge(v0, v2, 3);
        Edge e13 = new Edge(v1, v3, 6);
        Edge e12 = new Edge(v1, v2, 2);
        Edge e23 = new Edge(v2, v3, 7);
        Edge e24 = new Edge(v2, v4, 4);
        Edge e25 = new Edge(v2, v5, 2);
        Edge e35 = new Edge(v3, v5, 1);
        Edge e34 = new Edge(v3, v4, 1);
        Edge e45 = new Edge(v4, v5, 2);

        List<Edge> edges = new ArrayList<>();
        Collections.addAll(edges, e01, e02, e13, e12, e24, e25, e23, e35, e34, e45);

        LongestPathDAG graph = new LongestPathDAG(vertices, edges);

        int startVertexIndex = 1; // Index of the starting vertex in the vertices list
        graph.longestPath(vertices.get(startVertexIndex));

   	}

}
