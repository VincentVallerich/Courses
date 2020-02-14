package com.company;

public class Tuple implements Comparable<Tuple> {
    int node;
    int depthFromFirst;

    public Tuple(int node, int depthFromFirst) {
        this.node = node;
        this.depthFromFirst = depthFromFirst;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public void setDepthFromFirst(int depthFromFirst) {
        this.depthFromFirst = depthFromFirst;
    }

    public int getNode() {
        return node;
    }

    public int getDepthFromFirst() {
        return depthFromFirst;
    }

    @Override
    public int compareTo(Tuple tuple) {
        return getDepthFromFirst()-tuple.getDepthFromFirst() ;
    }
}
