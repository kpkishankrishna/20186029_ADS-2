import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
/**
 *the graph is send to page rank class.
 *first of all I am building a hashMap which is having.
 *all the vertices inlinks.
 *form that iam going to find out the rank of each vertex
 *for every iteration.
 *initially the pagerank value will be 1/ vertices.
 *it is iteration is done for 1000 times.
 */
/**
 *page rank class is for calculating.
 *page rank of each web page.
 */
class PageRank {
    /**
     *the vertices of graph.
     */
    private int vertices;
    /**
     *the map object to store the.
     *each web page vertex and page rank.
     */
    private HashMap<Integer, Double> map;
    // HashMap<Integer, ArrayList<Integer>> inLinks;
    /**
    *graph object.
    */
    private DiGraph graph;
    /**
     *the reverse graph object.
     */
    private DiGraph revGraph;
    /**
     *constructor to initialize.
     *
     * @param      g graph object
     */
    PageRank(final DiGraph g) {
        graph = g;
        vertices = graph.vertices();
        map = new HashMap<Integer, Double>();
        // inLinks = new HashMap<Integer, ArrayList<Integer>>();
        revGraph = graph.reverse();
    }
    /**
     *calculate page rank.
     *of each web page.
     *time complexity is O()
     */
    public void calculatePR() {
        Double sum = 0.0;
        int count = 0;
        ArrayList<Integer> list;
        double temp = (double) vertices;
        double initialPR = (1 / temp);
        for (int i = 0; i < vertices; i++) {
            if (graph.indegree[i] == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, initialPR);
            }
        }
        // for (int i = 0; i < vertices; i++) {
        //  for (int w : graph.adj[i]) {
        //      list = new ArrayList<Integer>();
        //      if (inLinks.containsKey(w)) {
        //          ArrayList<Integer> tempList = inLinks.get(w);
        //          tempList.add(i);
        //          inLinks.put(w, tempList);
        //      } else {
        //          list.add(i);
        //          inLinks.put(w, list);
        //      }
        //  }
        // }
        final int thousand = 1000;
        double[] tempArray = new double[graph.vertices()];
        for (int j = 0; j < thousand; j++) {
            for (int i = 0; i < vertices; i++) {
                sum = 0.0;
                for (int each : revGraph.adj(i)) {
                    double value = map.get(each);
                    sum += ((double) value / (double) graph.outdegree(each));
                }
                tempArray[i] = sum;
            }
            for (int i = 0; i < vertices; i++) {
                map.put(i, tempArray[i]);
            }
        }
    }
    /**
     *this method is to print the
     *vertex and its page rank.
     */
    public void print() {
        for (int i = 0; i < map.size(); i++) {
            System.out.println(i + " - " + map.get(i));
        }
    }
}
/**
 *class for main method.
 */
public final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {

    }
    /**
     *main method is  for user input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // read the first line of the input to get the number of vertices
        Scanner scan = new Scanner(System.in);
        DiGraph graph = new DiGraph(scan);
        System.out.println(graph);
        for (int i = 0; i < graph.vertices(); i++) {
            if (graph.outdegree(i) == 0) {
                for (int k = 0; k < graph.vertices(); k++) {
                    if (k != i) {
                        graph.addEdge(i, k);
                    }
                }
            }
        }
        // iterate count of vertices times
        // to read the adjacency list from std input
        // and build the graph
        // Create page rank object and pass the graph object to the constructor
        PageRank prObj = new PageRank(graph);
        prObj.calculatePR();
        prObj.print();
        // print the page rank object

        // This part is only for the final test case

        // File path to the web content
        // String file = "WebContent.txt";

        // instantiate web search object
        // and pass the page rank object and the file path to the constructor

        // read the search queries from std in
        // remove the q= prefix and extract the search word
        // pass the word to iAmFeelingLucky method of web search
        // print the return value of iAmFeelingLucky
    }
}
