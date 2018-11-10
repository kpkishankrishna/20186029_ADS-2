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
		while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            Edge e = new Edge(Integer.parseInt(line[0]),
                Integer.parseInt(line[1]), Double.parseDouble(line[2]));
            wg.addEdge(e);
        }



		String caseToGo = null;
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			System.out.println(wg.toString());
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