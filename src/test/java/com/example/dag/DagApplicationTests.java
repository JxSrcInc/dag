package com.example.dag;

import com.example.app.dag.Edge;
import com.example.app.dag.LongestPathDAG;
import com.example.app.dag.Vertex;

import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
import org.jgrapht.Graph;
import org.jgrapht.alg.cycle.CycleDetector;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import static org.junit.jupiter.api.Assertions.*;
import com.example.app.dag.ScaleDAGGenerator;

import java.util.ArrayList;
import java.util.List;
//@SpringBootTest
class DagApplicationTests {

	@Test
	void contextLoads() {
	}

    void testLongestPathInDAG(int numVertices, int expectedLongestPathLength) {
        // Create a sample DAG
        Graph<Vertex, Edge> randomDAG = ScaleDAGGenerator.generateRandomDAG(numVertices);
        List<Vertex> vertices = new ArrayList<>(randomDAG.vertexSet());
        List<Edge> edges = new ArrayList<>(randomDAG.edgeSet());

        // Calculate the longest path
        LongestPathDAG longestPathDAG = new LongestPathDAG(vertices, edges);
        int startVertexIndex = 0; // Index of the starting vertex in the vertices list
        longestPathDAG.longestPath(vertices.get(startVertexIndex));
        int longestPathLength = longestPathDAG.longestDistance;

        // Assert that the calculated longest path length matches the expected length
        assertEquals(expectedLongestPathLength, longestPathLength, "Incorrect longest path length");
    }

    @Test
    void testCase1() {
    	testLongestPathInDAG(10,28);
    }

    @Test
    void testCase2() {
    	testLongestPathInDAG(100,70);
    }

    @Test
    void testCase3() {
    	testLongestPathInDAG(1000,1821);
    }

}
