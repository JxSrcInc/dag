package com.example.app;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.alg.cycle.CycleDetector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.app.dag.Edge;
import com.example.app.dag.LongestPathDAG;
import com.example.app.dag.ScaleDAGGenerator;
import com.example.app.dag.Vertex;

@SpringBootApplication
public class DagApplication {

	public static void main(String[] args) {
		SpringApplication.run(DagApplication.class, args);

        int numVertices = 10000;
        Graph<Vertex, Edge> randomDAG = ScaleDAGGenerator.generateRandomDAG(numVertices);
        CycleDetector<Vertex, Edge> cycleDetector = new CycleDetector<>(randomDAG);
        if(!cycleDetector.detectCycles()) {
        	System.out.println("Graph should be a DAG");
        }
        //Graph<Integer, DefaultEdge> randomDAG = generateRandomDAG(numVertices);
        List<Vertex> vertices = new ArrayList<>(randomDAG.vertexSet());
        List<Edge> edges = new ArrayList<>(randomDAG.edgeSet());
        // Print some information about the generated DAG
        System.out.println("Number of vertices: " + vertices.size());
        System.out.println("Number of edges: " + edges.size());

        LongestPathDAG graph = new LongestPathDAG(vertices, edges);

        int startVertexIndex = 0; // Index of the starting vertex in the vertices list
        graph.longestPath(vertices.get(startVertexIndex));
        System.out.println("Longest Distance: "+graph.longestDistance);
        System.out.println("number of Vertex on the Longest Path: "+graph.longestPath.size());

   	}

}
