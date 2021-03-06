/**.
 * Class for uf.
 */
class UF {
    /**.
     * { var_description }
     */
    private int[] parent;  // parent[i] = parent of i
    /**.
     * { var_description }
     */
    private byte[] rank;   // rank[i] = rank of subtree
    //rooted at i (never more than 31)
    /**.
     * { var_description }
     */
    private int count;     // number of components

    /**.
     * Initializes an empty union–find data structure with {@code n} sites
     * {@code 0} through {@code n-1}. Each site is initially in its own
     * component.
     *
     * Complexity: O(N)
     *
     * @param  n the number of sites
     * @throws IllegalArgumentException if {@code n < 0}
     */
    UF(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    /**.
     * Returns the component identifier for the component containing site {@code
     * p}.
     *
     * Complexity: O(path), path denotes paths.
     *
     * @param      path  The path
     * @return     the component identifier for the component containing site
     *             {@code p}
     * @throws     IllegalArgumentException  unless {@code 0 <= p < n}
     */
    public int find(final int path) {
        int p = path;
        validate(p);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }

    /**.
     * Returns the number of components.
     *
     * Complexity: O(1)
     *
     * @return the number of components (between {@code 1} and {@code n})
     */
    public int count() {
        return count;
    }

    /**.
     * Returns true if the the two sites are in the same component.
     *
     * Complexity: O(1)
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @return {@code true} if the two sites
     * {@code p} and {@code q} are in the same component;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public boolean connected(final int p, final int q) {
        return find(p) == find(q);
    }

    /**.
     * Merges the component containing site {@code p} with the
     * the component containing site {@code q}.
     *
     * Complexity: O(1)
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(final int p, final int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        // make root of smaller rank point to root of larger rank
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }


    // validate that p is a valid index
    /**.
     * { function_description }
     *
     * Complexity: O(1)
     *
     * @param      p     { parameter_description }
     */
    private void validate(final int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException(
                "index " + p + " is not between 0 and " + (n - 1));
        }
    }
}
