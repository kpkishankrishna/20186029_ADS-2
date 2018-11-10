import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * main function to handle the testcases.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    // Self loops are not allowed...
    // Parallel Edges are allowed...
    // Take the Graph input here...
    Scanner sc = new Scanner(System.in);
    int vertices = Integer.parseInt(sc.nextLine());
    int edges = Integer.parseInt(sc.nextLine());
    EdgeWeightedGraph ewg = new EdgeWeightedGraph(vertices);
    while (edges > 0) {
      String[] tokens = sc.nextLine().split(" ");
      int c = Integer.parseInt(tokens[0]);
      int r = Integer.parseInt(tokens[1]);
      double weight = Double.parseDouble(tokens[2]);
      Edge e = new Edge(c, r, weight);
      ewg.addEdge(e);
      edges--;
    }
    String caseToGo = sc.nextLine();
    switch (caseToGo) {
    case "Graph":
      //Print the Graph Object.
      System.out.println(ewg);
      break;

    case "DirectedPaths":
      // Handle the case of DirectedPaths, where two integers are given.
      // First is the source and second is the destination.
      // If the path exists print the distance between them.
      // Other wise print "No Path Found."
      String[] tokens = sc.nextLine().split(" ");
      int source = Integer.parseInt(tokens[0]);
      int destination = Integer.parseInt(tokens[1]);
      DijkstraUndirectedSP objectDSP =
        new DijkstraUndirectedSP(ewg, source);
      if (objectDSP.hasPathTo(destination)) {
        System.out.println(objectDSP.distTo(destination));
      } else {
        System.out.println("No Path Found.");
      }
      break;
    case "ViaPaths":
      // Handle the case of ViaPaths, where three integers are given.
      // First is the source and second is the via is
      // the one where path should pass through.
      // third is the destination.
      // If the path exists print the distance between them.
      // Other wise print "No Path Found."
      String[] token = sc.nextLine().split(" ");
      int source1 = Integer.parseInt(token[0]);
      int via = Integer.parseInt(token[1]);
      int destination1 = Integer.parseInt(token[2]);
      DijkstraUndirectedSP objectDSP1 = new DijkstraUndirectedSP(ewg, source1);
      if (objectDSP1.hasPathTo(destination1)) {
        System.out.println(objectDSP1.distTo(destination1));
      } else {
        System.out.println("No Path Found.");
      }
      break;

    default:
      break;
    }

  }
}

