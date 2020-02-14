import java.awt.*;

public class Main {
    public static void main(String[] args ){
        Graph g=new Graph(3,0.5);
        System.out.println("made Graph");
        System.out.println(g);
        for(int i :g.tabDijkstra(g.nodes.get(0)))
            System.out.print(i+",");
    }
}
