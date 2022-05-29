import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TradeGraph {
    //graph with custom Edge as PathIdentifier
  final  Graph<Vertex, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
    List<DefaultEdge> edges;
    List<DefaultEdge> visited=new ArrayList<>();
    void createGraph() {
//        create vertexes
        Vertex vertex1 = new Vertex("node-1");
        Vertex vertex2 = new Vertex("node-2");
        Vertex vertex3 = new Vertex("node-3");
        Vertex vertex4 = new Vertex("node-4");
        Vertex vertex5 = new Vertex("node-5");
//add vertexex to graph
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);

        //connect vertexes thriugh edges
        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex3);
        graph.addEdge(vertex2, vertex4);
        graph.addEdge(vertex2, vertex5);
        graph.addEdge(vertex3, vertex5);
        graph.addEdge(vertex5, vertex4);
edges=new ArrayList<>(graph.edgeSet());
    }

    // method to travel through vertexes . vertex is given in an array
    void begintravel(Vertex[] vertices) {
        for (int i = 0; i < vertices.length - 1; i++) {
            //get edges of two vertexes
            Set<DefaultEdge> edges = graph.getAllEdges(vertices[i], vertices[i + 1]);
            for (DefaultEdge p1 : edges) {
                //change edge labe to travelled to indicate that the given path is travelled
                Vertex v1 = graph.getEdgeSource(p1);
                Vertex v2 = graph.getEdgeTarget(p1);
                visited.add(p1);
            }
        }
      //  printPath();
    }
    public Set<Vertex> getVertexes() {
        return graph.vertexSet();
    }
    void getTravelledPaths(){
        System.out.println("******************Travelled Paths**************************");
        for (DefaultEdge edge : visited) {
            Vertex v1 = graph.getEdgeSource(edge);
            Vertex v2 = graph.getEdgeTarget(edge);
            System.out.println(v1.operationName + " travelled-to " + v2.operationName+"\n----------");
        }
        System.out.println("****************************************\n");

    }
    void getNotTravelledPaths(){
        System.out.println("************Paths Not Travelled**********************");
        List<DefaultEdge> notTravelled= edges.stream().filter(elem -> !visited.contains(elem)).toList();
        for (DefaultEdge edge : notTravelled) {
            Vertex v1 = graph.getEdgeSource(edge);
            Vertex v2 = graph.getEdgeTarget(edge);
            System.out.println(v1.operationName + " not-travelled-to " + v2.operationName+"\n----------");
        }
        System.out.println("******************************************");
    }
}
// custom edge class
class CustomEdge1 extends DefaultEdge {
    String label;

    public CustomEdge1(String label) {
        this.label = label;
    }


}

class Vertex {
    String operationName = "";

    public Vertex() {
    }

    public Vertex(String operationName) {
        this.operationName = operationName;
    }

}

class Main {
    public static void main(String[] args) {
        TradeGraph tg = new TradeGraph();
        tg.createGraph();
        List<Vertex> vertexList = new ArrayList<>(tg.getVertexes());
        Vertex[] vertexesToTravel = {vertexList.get(0), vertexList.get(2), vertexList.get(4)};
        tg.begintravel(vertexesToTravel);

        tg.getTravelledPaths();//get travelled paths

        tg.getNotTravelledPaths(); //get paths not travelled
    }
}
//this class records the transactions
