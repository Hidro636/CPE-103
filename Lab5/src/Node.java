
public class Node implements Comparable<Object> {

    private final String value;
    private int freq;

    public Node(String value, int freq) {
        this.value = value;
        this.freq = freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public int getFreq() {
        return this.freq;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public int compareTo(Object t) {
        if (this.freq > ((Node) t).freq) {
            return 1;
        } else if (this.freq < ((Node) t).freq) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.value + ": " + this.freq;
    }

}
