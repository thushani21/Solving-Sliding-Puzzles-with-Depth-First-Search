//w1867645-Thushani Vasanthan

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        File myObj = new File("/Users/thushanivasanthan/Desktop/Main/src/a_10240_0.txt");
        Scanner myReader = new Scanner(myObj);

        List<String> nodeDes = new ArrayList<>();
        while (myReader.hasNextLine()) {
            nodeDes.add(myReader.nextLine());
            //String data = myReader.nextLine();
            //System.out.println(data);
        }
        int no_of_nodes = Integer.parseInt(nodeDes.get(0));
        Graph graph = new Graph(no_of_nodes);
        int i;
        for (i = 1; i < nodeDes.size(); i++) {
            String[] connections = nodeDes.get(i).split(" ");
            graph.addEdge(Integer.parseInt(connections[0]), Integer.parseInt(connections[1]));
        }

        if (graph.isACyclicGraph()) {

            System.out.println("\nYes, It's a cyclic graph");
        } else {

            System.out.println("\nNo, It's not a cyclic graph");
        }


        graph.sinkElimination();
        if (graph.isACyclicGraph()) {
            System.out.println("No Sink" );
        } else {
            System.out.println("Sink found at vertex "
                    + (i+ 1));
        }
    }
}

