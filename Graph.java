//w1867645-Thushani Vasanthan

// A Java Program to detect cycle in a graph
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Graph {

    private final int V;
    private final List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

// First iteration

    // A = [B,C]
    // B = [C,D,E]
    // C = [F]
    // D = [E]
    // E = [C, F]
    // F = []

// Second iteration

    // A = [B,C]
    // B = [C,D,E]
    // C = []
    // D = [E]
    // E = [C]
    // F = []


    public int sinkElimination() {

        // Looping through graph to get nodes
        int i;
        for (i = 0; i < V; i++) {
            int numberOfSinks = 0;

            // Checking if node is a sink i.e. no outward edges
            if (adj.size() == 0) {

                // Removing sink node as a child from all other nodes
                for (int j = 0; i < V; j++) {
                    // If other nodes contains sink node - removing it
                    if (adj.get(j).contains(i)) {
                        adj.get(j).remove(i);
                        return j;
                    }
                }
            }
        }
        return i;
    }


        public void addEdge ( int source, int dest){
            adj.get(source).add(dest);
        }

        public boolean isCyclicUtil ( int i, boolean[] visited,
        boolean[] recStack)
        {
            if (recStack[i])
                return true;

            if (visited[i])
                return false;

            visited[i] = true;

            recStack[i] = true;
            List<Integer> children = adj.get(i);

            for (Integer c : children)
                if (isCyclicUtil(c, visited, recStack))
                    return true;

            recStack[i] = false;

            return false;
        }


        public boolean isACyclicGraph ()
        {

            // Mark all the vertices as not visited and
            // not part of recursion stack
            boolean[] visited = new boolean[V];
            boolean[] recStack = new boolean[V];


            // Call the recursive helper function to
            // detect cycle in different DFS trees
            for (int i = 0; i < V; i++)
                if (isCyclicUtil(i, visited, recStack))
                    return true;

            return false;
        }


    }


