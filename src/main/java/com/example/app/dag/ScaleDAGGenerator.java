package com.example.app.dag;

import org.jgrapht.Graph;
import org.jgrapht.alg.cycle.CycleDetector;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScaleDAGGenerator {

    public static Graph<Vertex, Edge> generateRandomDAG(int numVertices) {
        Graph<Vertex, Edge> dag = new DefaultDirectedGraph<>(Edge.class);
        long seed = 123456789L;
        Random random = new Random(seed);

        // Add vertices
        List<Vertex> vertecise = new ArrayList<>();
        for (int i = 1; i <= numVertices; i++) {
        	Vertex vertex = new Vertex(i);
        	vertecise.add(vertex);
            //dag.addVertex(new Vertex(i));
            dag.addVertex(vertex);
        }

        // Add directed edges to create a DAG
        for (int v = 1; v <= numVertices; v++) {
            // Randomly choose the number of outgoing edges for each vertex
            int numOutgoingEdges = random.nextInt(Math.min(5, numVertices - (int) v) + 1);

            // Randomly choose vertices to connect to
            for (int j = 0; j < numOutgoingEdges; j++) {
                int u = v + 1 + random.nextInt(numVertices - (int) v);
                Vertex vVertex = vertecise.get(v-1);
                Vertex uVertex = vertecise.get(u-1);
                dag.addEdge(vVertex, uVertex, new Edge(vVertex, uVertex, 1));
            }
        }

        return dag;
    }

    public static Graph<Integer, DefaultEdge> _generateRandomDAG(int numVertices) {
        Graph<Integer, DefaultEdge> dag = new DefaultDirectedGraph<>(DefaultEdge.class);
        Random random = new Random();

        // Add vertices
        for (int i = 1; i <= numVertices; i++) {
            dag.addVertex(i);
        }

        // Add directed edges to create a DAG
        for (int v = 1; v <= numVertices; v++) {
            // Randomly choose the number of outgoing edges for each vertex
            int numOutgoingEdges = random.nextInt(Math.min(5, numVertices - v) + 1);

            // Randomly choose vertices to connect to
            for (int j = 0; j < numOutgoingEdges; j++) {
                int u = v + 1 + random.nextInt(numVertices - v);
                dag.addEdge(v, u);
            }
        }

        // Check if the graph is a DAG
        CycleDetector<Integer, DefaultEdge> cycleDetector = new CycleDetector<>(dag);
        if (cycleDetector.detectCycles()) {
            throw new RuntimeException("Generated graph is not a DAG.");
        }

        return dag;
    }

    public static void main(String[] args) {
        int numVertices = 10000;
        Graph<Vertex, Edge> randomDAG = generateRandomDAG(numVertices);
        //Graph<Integer, DefaultEdge> randomDAG = generateRandomDAG(numVertices);
        List<Vertex> vertices = new ArrayList<>(randomDAG.vertexSet());
        List<Edge> edges = new ArrayList<>(randomDAG.edgeSet());
        // Print some information about the generated DAG
        System.out.println("Number of vertices: " + vertices.size());
        System.out.println("Number of edges: " + edges.size());
        // Ensure that the graph is a DAG
        CycleDetector<Vertex, Edge> cycleDetector = new CycleDetector<>(randomDAG);
        if(!cycleDetector.detectCycles()) {
        	System.out.println("Graph should be a DAG");
        }
    }
}