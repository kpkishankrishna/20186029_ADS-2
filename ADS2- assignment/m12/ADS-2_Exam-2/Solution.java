import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph wg = new EdgeWeightedGraph(vertices);
		while (edges > 0) {
            String[] tokens = sc.nextLine().split(" ");
      		int a = Integer.parseInt(tokens[0]);
      		int b = Integer.parseInt(tokens[1]);
      		double weight = Double.parseDouble(tokens[2]);
      		Edge e = new Edge(a, b, weight);
      		wg.addEdge(e);
      		edges--;
        }



		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			System.out.println(wg);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			KruskalMST k = new KruskalMST(wg);
        	System.out.format("%.5f", k.weight());
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}