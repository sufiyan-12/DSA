package graph;

import java.util.Scanner;

public class ProgramRunner {

	public static void main(String[] args) {
		// start point for all programs

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter vertices: ");
		int vertices = sc.nextInt();
		System.out.println("Enter edges: ");
		int edges = sc.nextInt();
		
//		// creating graph obj for matrix
//		StoreGraph graph = new StoreGraph(vertices, edges, true, false);
		
		// store adjacency matrix
//		for(int i=0; i<edges; ++i) {
//			System.out.print("Enter u: ");
//			int u = sc.nextInt();
//			System.out.print("Enter v: ");
//			int v = sc.nextInt();
//			System.out.println();
//
//			// add node
//			graph.addNode(u, v);
//		}

		
		// creating graph obj for matrix
		StoreGraph graph = new StoreGraph(vertices, edges, false, false);
		
		// store adjacency list
		for (int i = 0; i < edges; ++i) {
			System.out.print("Enter u: ");
			int u = sc.nextInt();
			System.out.print("Enter v: ");
			int v = sc.nextInt();
			System.out.println();

			// add node
			graph.addNode(u, v);
		}
		
		GraphUtil.print(graph.getList());
		
		System.out.println("size: "+ graph.getList().size());
		
		System.out.println("BFS of this graph: ");
		GraphUtil.printList(GraphUtil.bfsOfGraph(vertices+1, graph.getList()));
		System.out.println("DFS of this graph: ");
		GraphUtil.printList(GraphUtil.dfsOfGraph(vertices+1, graph.getList()));
		
		sc.close();
	}

}
