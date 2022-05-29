package graphtraveltest;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import java.util.*;

public class GraphTest {
    final Graph<Vertex, DefaultEdge> graph = new DirectedAcyclicGraph<>(DefaultEdge.class);
    Set<Vertex> sources = new HashSet<>();
    Set<Vertex> targets = new HashSet<>();
    Vertex start;

    void createGraph() {
//        create vertexes
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        Vertex vertex6 = new Vertex(6);
        Vertex vertex7 = new Vertex(7);
        Vertex vertex8 = new Vertex(8);
        Vertex vertex9 = new Vertex(9);
        Vertex vertex10 = new Vertex(10);
        Vertex vertex11 = new Vertex(11);
//add vertexex to graph
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addVertex(vertex6);
        graph.addVertex(vertex7);
        graph.addVertex(vertex8);
        graph.addVertex(vertex9);
        graph.addVertex(vertex10);
        graph.addVertex(vertex11);

        //connect vertexes thriugh edges

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex3);
        graph.addEdge(vertex2, vertex3);
        graph.addEdge(vertex3, vertex4);
        graph.addEdge(vertex3, vertex5);
        graph.addEdge(vertex4, vertex5);
        Vertex[] v = {vertex1};
        Vertex[] v2 = {vertex5};
        sources = new HashSet<>(Arrays.asList(v));
        targets = new HashSet<>(Arrays.asList(v2));

        start = vertex1;
        //getAllPathsfromSinglesource();
    }

    void createGraph2() {
//        create vertexes
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        Vertex vertex6 = new Vertex(6);
        Vertex vertex7 = new Vertex(7);
        Vertex vertex8 = new Vertex(8);
        Vertex vertex9 = new Vertex(9);
        Vertex vertex10 = new Vertex(10);
        Vertex vertex11 = new Vertex(11);
//add vertexex to graph
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addVertex(vertex6);
        graph.addVertex(vertex7);
        graph.addVertex(vertex8);
        graph.addVertex(vertex9);
        graph.addVertex(vertex10);
        graph.addVertex(vertex11);

        //connect vertexes thriugh edges

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex2, vertex3);
        graph.addEdge(vertex1, vertex4);
        graph.addEdge(vertex4, vertex5);
        graph.addEdge(vertex5, vertex7);
        graph.addEdge(vertex7, vertex8);
        graph.addEdge(vertex5, vertex9);
        graph.addEdge(vertex9, vertex11);
        graph.addEdge(vertex5, vertex10);
        graph.addEdge(vertex1, vertex6);
        graph.addEdge(vertex6, vertex5);
        graph.addEdge(vertex10, vertex11);


        start = vertex1;

        // getAllPathsfromSinglesource();
    }

    void createGraph3() {
//        create vertexes
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        Vertex vertex6 = new Vertex(6);
        Vertex vertex7 = new Vertex(7);
        Vertex vertex8 = new Vertex(8);
        Vertex vertex9 = new Vertex(9);
        Vertex vertex10 = new Vertex(10);
        Vertex vertex11 = new Vertex(11);
        Vertex vertex12 = new Vertex(12);
        Vertex vertex13 = new Vertex(13);
//add vertexex to graph
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addVertex(vertex6);
        graph.addVertex(vertex7);
        graph.addVertex(vertex8);
        graph.addVertex(vertex9);
        graph.addVertex(vertex10);
        graph.addVertex(vertex11);
        graph.addVertex(vertex12);
        graph.addVertex(vertex13);

        //connect vertexes thriugh edges

        graph.addEdge(vertex1, vertex4);
        graph.addEdge(vertex4, vertex2);
        graph.addEdge(vertex1, vertex5);
        graph.addEdge(vertex5, vertex6);
        graph.addEdge(vertex5, vertex9);
        graph.addEdge(vertex6, vertex7);
        graph.addEdge(vertex6, vertex8);
        graph.addEdge(vertex8, vertex9);
        graph.addEdge(vertex9, vertex10);
        graph.addEdge(vertex1, vertex3);
        graph.addEdge(vertex12, vertex2);
        graph.addEdge(vertex12, vertex8);
        graph.addEdge(vertex13, vertex5);

        Vertex[] v = {vertex1, vertex5, vertex12, vertex13};
        Vertex[] v2 = {vertex10, vertex3};

        start = vertex1;
        sources = new HashSet<>(Arrays.asList(v));
        targets = new HashSet<>(Arrays.asList(v2));
        //getAllPathsfromSinglesource();
    }


    //*******************************************************************************************************//
    public void getAllPathsFromSingleSource() {
        Vertex n = start;

        if (!Graphs.vertexHasPredecessors(graph, n)) {
            List<Vertex> list = Graphs.successorListOf(graph, n);
            List<Vertex> k = new ArrayList<>();
            k.add(n);
            if (list.size() != 0) {
                for (Vertex item :
                        list) {
                    List<Vertex> p = new ArrayList<>(k);
                    p.add(item);
                    findpaths(item, p);
                }
            }
        }

        int i = 1;
        for (List<Vertex> item :
                pathsFromSingleSource) {
            System.out.print("(" + i + ") ");
            System.out.println(item);
            i++;
        }
    }
    void findpaths(Vertex n, List<Vertex> plist) {
        if (graph.outgoingEdgesOf(n).size() > 0) {
            List<Vertex> v = new ArrayList<>(Graphs.successorListOf(graph, n));
            for (Vertex item :
                    v) {
                List<Vertex> newpath = new ArrayList<>(plist);
                newpath.add(item);
                findpaths(item, newpath);
            }
        } else {
            pathsFromSingleSource.add(plist);
        }
    }

    //*******************************************************************************************************//
    /* method to get all paths from a graph modified dfs using recursion.
        the dfs iterartor provides visited nodes. check for if it have any predecessor.
         if not process the node,until termination node reaches.
    * */
    public void getAllPossiblepaths() {
        DepthFirstIterator<Vertex, DefaultEdge> di = new DepthFirstIterator<>(graph);

        while (di.hasNext()) { 
            Vertex n = di.next();

            if (!Graphs.vertexHasPredecessors(graph, n)) {
                List<Vertex> list = Graphs.successorListOf(graph, n);
                List<Vertex> k = new ArrayList<>();
                k.add(n);
                if (list.size() != 0) {
                    for (Vertex item :
                            list) {
                        List<Vertex> p = new ArrayList<>(k);
                        p.add(item);
                        process(item, p);
                    }
                }
            }
        }
        int i = 1;
        for (List<Vertex> v :
                allPossiblePaths) {
            System.out.print("(" + i + ") ");
            System.out.println(v);
            i++;
        }
    }
    List<List<Vertex>> allPossiblePaths = new ArrayList<>();
    private void process(Vertex n, List<Vertex> plist) {
        if (graph.outgoingEdgesOf(n).size() > 0) {
            List<Vertex> v = new ArrayList<>(Graphs.successorListOf(graph, n));
            for (Vertex item :
                    v) {
                List<Vertex> newpath = new ArrayList<>(plist);
                newpath.add(item);
                process(item, newpath);
            }
        } else {
            allPossiblePaths.add(plist);
        }
    }
    List<List<Vertex>> pathsFromSingleSource = new ArrayList<>();

//**********************************************************************************//

    /*
        list all possible paths from sources to destination
     */
    void alldirectedPaths() {
        AllDirectedPaths<Vertex, DefaultEdge> allDirectedPaths = new AllDirectedPaths<>(graph);


        List<GraphPath<Vertex, DefaultEdge>> paths = allDirectedPaths.getAllPaths(sources, targets, false, 100);
        int i = 1;
        for (GraphPath<Vertex, DefaultEdge> v : paths) {
            //System.out.println(v);
            System.out.print("(" + i + ") ");
            System.out.println(v.getVertexList());
            i++;
        }
    }

}

class Vertex {
    int nodenum;

    public Vertex(int nodenum) {
        this.nodenum = nodenum;
    }

    @Override
    public String toString() {
        return "V-" + nodenum;
    }
}


class Main {
    public static void main(String[] args) {
        GraphTest g = new GraphTest();
        //g.createGraph();
        //g.createGraph2();
        g.createGraph3();
        System.out.println("------All directed paths from sources to destinations in DAG-------");
        g.alldirectedPaths();
        System.out.println("**********************************************************\n");
        System.out.println("------all path from single source in DAG-------");
        g.getAllPathsFromSingleSource();
        System.out.println("**********************************************************\n");
        System.out.println("--------all possible paths in a graph in DAG-------");
        g.getAllPossiblepaths();
        System.out.println("**********************************************************");
    }
}
