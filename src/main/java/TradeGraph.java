import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TradeGraph {
    Graph<Node, PathIdentifier> graph = new SimpleGraph<>(PathIdentifier.class);

    void  creategraph(){
       Node node1=new Node("node1");
       Node node2= new Node("node2");
       Node node3= new Node("node3");
       Node node4= new Node("node4");
       Node node5= new Node("node5");

       graph.addVertex(node1);
       graph.addVertex(node2);
       graph.addVertex(node3);
       graph.addVertex(node4);
       graph.addVertex(node5);

       graph.addEdge(node1,node2,new PathIdentifier("not-travelled"));
       graph.addEdge(node1,node3,new PathIdentifier("not-travelled"));
       graph.addEdge(node2,node4,new PathIdentifier("not-travelled"));
       graph.addEdge(node2,node5,new PathIdentifier("not-travelled"));
       graph.addEdge(node3,node5,new PathIdentifier("not-travelled"));
       graph.addEdge(node5,node4,new PathIdentifier("not-travelled"));

    }
void begintravel(Node[] nodes){
        // n1 n2 n5
       Set<Node> vertexset= graph.vertexSet();
       //node for trade1
    Node[] nodes1=new Node[nodes.length];
    List<PathIdentifier> edgelist=new ArrayList<>();
    for(int i=0;i<nodes.length-1;i++){
        Set<PathIdentifier> p= graph.getAllEdges(nodes[i],nodes[i+1]);
        for(PathIdentifier p1:p){
            p1.label="travelled";
        }
    }
    printgraph();
}

    private void printgraph() {
for(PathIdentifier p:graph.edgeSet()){
    Node n1=graph.getEdgeSource(p);
    Node n2=graph.getEdgeTarget(p);
   // if(p.label.equalsIgnoreCase("travelled")){
        System.out.println(n1.operationName+" "+p.label+" "+n2.operationName);
  //  }else{
     //   System.out.println(n1.operationName+" "+p.label+" "+n2.operationName);

    }
}

    public Set<Node> getVertexes() {
      return  graph.vertexSet();
    }
}
class PathIdentifier extends DefaultEdge{
    String label;

    public PathIdentifier(String label) {
        this.label = label;
    }


}
class Node{
    String operationName="";

    public Node() {
    }

    public Node(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "operationName='" + operationName + '\'' +
                '}';
    }
}
 class Driver{
    public static void main(String[] args) {
        TradeGraph tg=new TradeGraph();
        tg.creategraph();
       List<Node> nodelist=new ArrayList<Node>(tg.getVertexes());
       for(Node elem:nodelist){
           System.out.println(elem.operationName);
       }
       Node[] nodearray={nodelist.get(0),nodelist.get(1),nodelist.get(4)};
        tg.begintravel(nodearray);
    }
}
