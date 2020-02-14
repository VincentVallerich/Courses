import java.util.Objects;

public class Ark {
    Node to;
    int weight;

    public Ark(Node to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    public Node getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ark ark = (Ark) o;
        return Objects.equals(to, ark.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, weight);
    }
}
