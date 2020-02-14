package com.company;

public class Ark {
    int to;
    int weight;

    public Ark(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Ark{" +
                "to=" + to +
                ", weight=" + weight +
                '}';
    }
}
