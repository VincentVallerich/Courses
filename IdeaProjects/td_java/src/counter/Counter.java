package counter;

public class Counter {
    private int value;
    private final String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name+"(" + value +')';
    }

    public Counter(Counter c1) {
        this(c1.getName(),c1.getValue());
    }

    public Counter(String name) {
        this.name = name;
    }

    public Counter( String name, int value) {
        this.value = value;
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


    public void increment(){
        setValue(getValue()+1);
    }

    public void decrement(){
        setValue(getValue()-1);
    }
}
