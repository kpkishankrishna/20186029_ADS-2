import java.util.Stack;
/**.
 * Class for dijkstra sp.
 */
class DijkstraSP {
    /**.
     * { var_description }
     */
    private double[] distTo;
    /**.
     * { var_description }
     */
    private Edge[] edgeTo;
    /**.
     * { var_description }
     */
    private IndexMinPQ<Double> pq;

    /**.
     * Computes a shortest-paths tree from the
     * source vertex {@code s} to every
     * other vertex in the edge-weighted digraph {@code G}.
     * Complexity: O(E.log(V)).
     *
     * @param      graph  The graph
     * @param      s      the source vertex
     * @throws     IllegalArgumentException  if an edge weight is negative
     * @throws     IllegalArgumentException  unless {@code 0 <= s < V}
     */
    DijkstraSP(final EdgeWeightedGraph graph, final int s) {
        for (Edge e : graph.edges()) {
            if (e.weight() < 0) {
                throw new IllegalArgumentException(
                    "edge " + e + " has negative weight");
            }
        }

        distTo = new double[graph.vert()];
        edgeTo = new Edge[graph.vert()];

        validateVertex(s);

        for (int v = 0; v < graph.vert(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        // relax vertices in order of distance from s
        pq = new IndexMinPQ<Double>(graph.vert());
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (Edge e : graph.adj(v)) {
                relax(e, v);
            }
        }
    }

    // relax edge e and update pq if changed
    /**.
     * { function_description }
     * Complexity: O(1).
     *
     * @param      e     { parameter_description }
     * @param      v     { parameter_description }
     */
    private void relax(final Edge e, final int v) {
        int w = e.other(v);
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) {
                pq.decreaseKey(w, distTo[w]);
            } else {
                pq.insert(w, distTo[w]);
            }
        }
    }

    /**.
     * Returns the length of a shortest path from the
     * source vertex {@code s} to vertex {@code v}.
     *
     * Complexity: O(1).
     *
     * @param  v the destination vertex
     * @return the length of a shortest path from the
     * source vertex {@code s} to vertex {@code v};
     *         {@code Double.POSITIVE_INFINITY} if no such path
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public double distTo(final int v) {
        validateVertex(v);
        return distTo[v];
    }

    /**.
     * Returns true if there is a path from the source vertex to vertex
     *
     * Complexity: O(1).
     *
     * @param  v the destination vertex
     * @return {@code true} if there is a path from the source vertex
     *         {@code s} to vertex {@code v}; {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(final int v) {
        validateVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**.
     * Returns a shortest path from the source vertex to vertex
     * Complexity: O(log(E)).
     *
     * @param  v the destination vertex
     * @return a shortest path from the source vertex to other vertex
     *         as an iterable of edges, and {@code null} if no such path
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Edge> pathTo(final int v) {
        validateVertex(v);
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Edge> path = new Stack<Edge>();
        int x = v;
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[x]) {
            path.push(e);
            x = e.other(x);
        }
        return path;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    /**.
     * { function_description }
     * Complexity: O(1).
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        int vert = distTo.length;
        if (v < 0 || v >= vert) {
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (
                    vert - 1));
        }
    }
}
