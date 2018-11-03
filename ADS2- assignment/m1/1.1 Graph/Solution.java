import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**
     * main method.
     *Time complexity : O(N^2)
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String method = scan.nextLine();
        int vertices = Integer.parseInt(scan.nextLine());
        int edges = Integer.parseInt(scan.nextLine());
        Graph g = new Graph(vertices);
        String[] inputs = scan.nextLine().split(",");
        if (inputs.length > 2) {
            for (int i = 0; i < edges; i++) {
                String[] tokens = scan.nextLine().split(" ");
                g.addEdge(Integer.parseInt(tokens[0]),
                 Integer.parseInt(tokens[1]));
            }
        }
        System.out.println(g.v() + " vertices, " + g.e() + " edges");
        if (inputs.length < 2) {
            System.out.println("No edges");
            return;
        }
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
    }
}



