package com.example.app.dag;

public class Edge {
    Vertex from;
    Vertex to;
    int weight;

    public Edge(Vertex from, Vertex to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    
    public int getWeight() {
    	return this.weight;
    }
    public Vertex getFrom() {
    	return from;
    }
    public Vertex getTo() {
    	return to;
    }
}
