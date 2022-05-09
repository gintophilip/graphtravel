import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestGraph {
    Graph< Nodet, DefaultEdge> graph = new DirectedAcyclicGraph<>(DefaultEdge.class);
    Nodet start;

    void  creategraph(){
         Nodet  Nodet1=new  Nodet("1");
         Nodet  Nodet2= new  Nodet("2");
         Nodet  Nodet3= new  Nodet("3");
         Nodet  Nodet4= new  Nodet("4");
         Nodet  Nodet5= new  Nodet("5");

        graph.addVertex( Nodet1);
        graph.addVertex( Nodet2);
        graph.addVertex( Nodet3);
        graph.addVertex( Nodet4);
        graph.addVertex( Nodet5);

        graph.addEdge( Nodet1, Nodet2 );
        graph.addEdge( Nodet1, Nodet3 );
        graph.addEdge(Nodet2,Nodet3);
        graph.addEdge( Nodet3, Nodet4 );
        graph.addEdge( Nodet3, Nodet5 );
        graph.addEdge( Nodet4, Nodet5 );
start= Nodet1;
    }
    HashMap< Nodet, List< Nodet>> adjacency=new HashMap<>();
    public void printPaths() {
        DepthFirstIterator<Nodet, DefaultEdge> di = new DepthFirstIterator<>(graph);

        List<Nodet> l = null;
        while (di.hasNext()) {
            Nodet n = di.next();
            l = Graphs.successorListOf(graph, n);
            adjacency.put(n, l);
//            System.out.println("node " + n.operationName);
//            for (Nodet item :
//                    l) {
//                System.out.println("  " + item.operationName);
//            }
        }
        List<Nodet> k=new ArrayList<>();
        k.add(start);
        findpaths(adjacency, k,start);
    }
    List<Nodet> p1=new ArrayList<>();

void findpaths( HashMap<Nodet, List<Nodet>> adjacency, List<Nodet>k,Nodet n){
    System.out.println(k.toString());
    //System.out.println(n.operationName);
    if(adjacency.containsKey(n)){
       List<Nodet> value = adjacency.get(n);
//       p1.add(n);
        System.out.println(p1.toString());
       List<Nodet> p=new ArrayList<>();
       for (Nodet t :
               value) {
           k.add(t);
           findpaths(adjacency,p,t);

        //   System.out.println( p.toString());
       }
       
   }else{

   }
}
}
class   Nodet{
    String operationName="";

    public   Nodet() {
    }

    public   Nodet(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public String toString() {
        return ""+operationName
                ;
    }
}
class  main2{
    public static void main(String[] args) {
        TestGraph g=new TestGraph();
        g.creategraph();
        g.printPaths();
    }
}