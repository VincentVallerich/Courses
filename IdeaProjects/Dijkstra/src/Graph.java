import java.util.*;


public class Graph {
   ArrayList<Node>  nodes;
   int n;

   public Graph(int n, double d) {
      this.n=n;
      //Random rand = new Random();
      nodes=new ArrayList<>();
      for (int i =0; i<n;i++){
         nodes.add(new Node());
      }
      Random rand = new Random();
      int number = (int) (n*(n-1)*d);
      while(number!=0){
         boolean done=false;
         while(!done){
            int from=rand.nextInt(n-1);
            int to=rand.nextInt(n-1);
            if(to==from)continue;
            Node f=nodes.get(from);
            Node t=nodes.get(to);
            List<Ark> voisins=f.getVoisins();
            if(f.hasVoisin(t))
               continue;
            nodes.get(from).voisins.add(new Ark(nodes.get(to),rand.nextInt(50)+1));
            done=true;
         }
         number--;
      }
   }

   int[] tabDijkstra(Node s){
      int indiceofs=nodes.indexOf(s);
      ArrayList<Node> fifo=new ArrayList<>();
      copyNodes(fifo);
      int[] d=new int[n];
      int inf=getInf();
      for(int i=0;i<n;i++){
         d[i]=inf;
      }
      d[indiceofs]=0;
      while( ! isFifoEmpty(fifo)){
         Node min=extractMin(d,fifo);
         int u=nodes.indexOf(min);
         for(Ark a: nodes.get(u).getVoisins()){
            int v=nodes.indexOf(a.to);
            if(d[v]>d[u]+a.getWeight())d[v]=d[u]+a.getWeight();
         }

      }
      System.out.println(d.toString());
      return d;
   }

   int getInf(){
      /*
      int max=0;
      for(Node s:nodes){
         int otrosMax=s.voisins.stream().max((a)->{return a.getWeight();});
         max=Math.max(max,otrosMax);
      }
      return max*n+1;*/
      return Integer.MAX_VALUE;
   }

   private void copyNodes(ArrayList<Node> tab){
      for(int i=0; i<nodes.size();i++)
         tab.add(nodes.get(i));
   }

   /*Node extractMin(int[] d,ArrayList<Node> fifo){
      Node deleted=fifo.get(0);
      int min=getInf();
      for(Node no: fifo){
         if(d[nodes.indexOf(no)]<=min)
            deleted=no;
         else{
            System.out.println(min+" is less than "+d[nodes.indexOf(no)]);
         }
      }
      if(deleted!=null)
         fifo.remove(nodes.indexOf(deleted));
      return deleted;
   }*/

   Node extractMin(int[] d,ArrayList<Node> fifo){
      Node buff=null;
      int dmin=getInf();
      for(Node no: fifo){
         if(no==null)continue;
         if(d[fifo.indexOf(no)]<=dmin){
            buff = no;
            dmin = d[fifo.indexOf(no)];
         }
      }
      if(buff==null)throw new Error("buff==null unable to extract min");
      fifo.set(fifo.indexOf(buff),null);
      return buff;
   }


   boolean isFifoEmpty(ArrayList<Node> fifo){
      for(Node n:fifo) {
         if(n!=null)
            return false;
      }
      return true;
   }

   @Override
   public String toString() {
      String ret=" {\n";
      for(Node node : nodes){
         ret+=" node "+node+" : ";
         for(Ark a:node.getVoisins()){
            ret += a.to+" "+ a.weight+" , ";
         }
         ret+="\n";
      }
      ret+="}\n";
      return ret;
   }
}
