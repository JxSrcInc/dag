# Directed Acyclic Graph (DAG) Demo

## Installation and Run
This demo is a Spring Boot application without the default web starter, and it utilizes Maven to manage Java dependencies.

To run this application, follow these steps:
1. Import the project into Eclipse.
2. Run it as a Java application.

## Define DAG Graph
Create a DAG graph by specifying vertex and edge sets in DagApplication.java. Ensure that there are no cycles or closed paths in the graph.

Specify the start vertex in the same file.

View the longest path in the console output.

## Large Scale Branch
Add RandomDAGGenerator to create large DAG.
Add unit test 

## Questions and Answers

Q: Does the solution work for larger graphs? 

A: Yes, the solution is designed to work for graphs of various sizes. It is also tested on a large DAG of 10000 vertices created by using ScaleDAGGenerator. 

Q: Can you think of any optimizations? 

A: While optimizations are undeniably crucial, they often involve intricate analyses in topology and mathematics, which fall beyond the scope of a project primarily centered on the practical aspects of application development from an engineering perspective.

Q: What’s the computational complexity of your solution? 

A: The computational complexity is influenced by the algorithm used to compute the longest path. It would depend on factors such as the size and structure of the graph.

Q: Are there any unusual cases that aren't handled?

A: The solution assumes that the input graph is a Directed Acyclic Graph (DAG). If the graph contains cycles, the output becomes unpredictable. Ensuring the graph is acyclic is crucial for accurate results.
