package com.company;

public class Main {

    public static void main(String[] args) {
        Graph g=new Graph(5,0.5);
        System.out.println(g);
        printTab(g.tabDijkstra(0));
        printTab(g.queueDijkstra(0));
    }

    private static void printTab(int[] tab) {
        System.out.print("[ ");
        for(int i:tab){
            System.out.print(" "+i+", ");
        }
        System.out.println("]");
    }
}
