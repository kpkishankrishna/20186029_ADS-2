import java.util.*;
class PageRank {
	
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Scanner sc = new Scanner(System.in);
		String file = "WebContent.txt";
        String method = sc.nextLine();
        int vertices = Integer.parseInt(sc.nextLine());
        int edges = Integer.parseInt(sc.nextLine());
        Graph g = new Graph(vertices);
        String[] inputs = sc.nextLine().split(",");
        // if (inputs.length > 2) {
            
        // }
        for (int i = 0; i < edges; i++) {
                String[] tokens = sc.nextLine().split(" ");
                g.addEdge(Integer.parseInt(tokens[0]),
                 Integer.parseInt(tokens[1]));
            }
        System.out.println(g.v() + " vertices, " + g.e() + " edges");
        // if (inputs.length < 2) {
        //     System.out.println("No edges");
        //     return;
        // }
        switch (method) {
        case "Matrix":
            Bag<Integer>[] adj = g.matrix();
            int[][] matrix = new int[vertices][vertices];
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (g.hasEdge(i, j)) {
                        matrix[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            break;
        case "List":
            g.list();
            adj = g.list();
            for (int v = 0; v < vertices; v++) {
                System.out.print((inputs[v] + ": "));
                for (int w : adj[v]) {
                    System.out.print((inputs[w] + " "));
                }
                System.out.print("\n");
            }
            break;
        default:
        }
		// read the first line of the input to get the number of vertices
		
		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		
		
		// Create page rank object and pass the graph object to the constructor
		
		// print the page rank object
		
		// This part is only for the final test case
		
		// File path to the web content
		
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
	}
		
	
}
