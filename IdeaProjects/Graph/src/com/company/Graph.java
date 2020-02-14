package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Graph {

    public ArrayList<ArrayList<Ark>> graph=new ArrayList<>();
    int numerOfNode;

    public Graph(int numberOfNode,double density){
        this.numerOfNode=numberOfNode;
        int numberOfArk=0;
        //crate nodes
        for(int i=0;i<numberOfNode;i++){
            graph.add(new ArrayList<>());
        }

        //add arks
        Random rand = new Random(4);
        while (((numberOfArk*1.0)/(numberOfNode*(numberOfNode-1)))<=density){
            int r1 = rand.nextInt(numberOfNode);
            int r2 = rand.nextInt(numberOfNode);
            if( r1 == r2 )continue;
            if(isIn(r1,r2))continue;
            int weight = rand.nextInt(100);
            graph.get(r1).add(new Ark(r2,weight));
            numberOfArk++;
        }
    }

    boolean isIn(int r1,int r2){
        for(Ark a: graph.get(r1)){
            if(a.to==r2)return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s="[\n";
        for(ArrayList<Ark> l:graph){
            s+="#node ";
            for(Ark a:l){
                s+=a.toString()+" ,";
            }
            s+="#\n";
        }
        return s+"]\n";
    }

    int[] tabDijkstra(int s){
        int[] fifo = createFifo(graph.size());
        int[] d = new int[fifo.length];
        for(int i:fifo) d[i] = getInfinity();
        d[s] = 0;
        while( ! fifoIsEmpty(fifo) ){
            int fifomin = extract_min(fifo,d);
            for(Ark a : graph.get(fifomin)){
                if( d[a.to] > d[fifomin] + a.weight)
                    d[a.to] = d[fifomin] + a.weight;
            }
        }
        return d;
    }

    private int getInfinity() {
        return numerOfNode*numerOfNode*100;
    }

    private int extract_min(int[] fifo,int[] d) {
        int dmin = Integer.MAX_VALUE;
        int fifomin = -1;
        for(int i : fifo){
            if(i<0)continue;
            if(d[i]<=dmin){
                dmin = d[i];
                fifomin = i;
            }
        }
        fifo[fifomin] = -1;//suppression de fifo
        return fifomin;
    }

    private boolean fifoIsEmpty(int[] fifo) {
        for(int i:fifo){
            if(i>=0) return false;
        }
        return true;
    }

    private int[] createFifo(int size) {
        int[] fifo=new int[size];
        for(int i=0; i<size; i++) fifo[i]=i;
        return fifo;
    }

    int[] queueDijkstra(int s){

        PriorityQueue<Tuple> fifo = new PriorityQueue<>(graph.size());
        Tuple tuples[] = new Tuple[graph.size()];
        boolean done[]=new boolean[graph.size()];

        for(int i=0;i<graph.size();i++) {
            tuples[i] = new Tuple(i, i==s?0:getInfinity());
            fifo.add(tuples[i]);
            done[i]=false;
        }


        while( ! doneIsAllTrue(done) ){

            Tuple fifomin = fifo.remove();
            if(done[fifomin.getNode()]!=false)continue;
            done[fifomin.getNode()] = true;

            System.out.println(fifomin.node+" "+fifomin.getDepthFromFirst());

            for(Ark a : graph.get(fifomin.node)){
                if((tuples[a.to].getDepthFromFirst() > tuples[fifomin.getNode()].getDepthFromFirst() + a.weight) &&( ! done[a.to])) {
                    tuples[a.to] = new Tuple(a.to, tuples[fifomin.getNode()].getDepthFromFirst() + a.weight);
                    fifo.add(tuples[a.to]);
                }
            }

        }
        int[] res=new int[graph.size()];
        for(int i=0;i<graph.size();i++){
            res[i] = tuples[i].getDepthFromFirst();
        }
        return res;
    }

    private boolean doneIsAllTrue(boolean[] done) {
        for(boolean b:done){
            if( ! b )return b;
        }
        return true;
    }
}
