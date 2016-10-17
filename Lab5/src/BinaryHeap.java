
public class BinaryHeap {

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
        heap.enqueue(new Node("e", 5));
        heap.enqueue(new Node("j", 1));
        heap.enqueue(new Node("s", 3));
        heap.enqueue(new Node("p", 8));
        heap.enqueue(new Node("m", 2));
        heap.enqueue(new Node("f", 2));
        heap.enqueue(new Node("l", 1));
        heap.enqueue(new Node("x", 6));
        heap.print();
    }

    private Node[] arr;
    private int size;

    public BinaryHeap() {
        size = 0;
        arr = new Node[10];

    }

    public void enqueue(Node element) {
        int index = size + 1;
        arr[index] = element;

        while (index > 1 && arr[index / 2].compareTo(element) == -1) {
            arr[0] = arr[index / 2];
            arr[index / 2] = element;
            arr[index] = arr[0];
            index /= 2;
        }

        size++;
    }

    public Node dequeue() {
        Node value = arr[1];
        arr[1] = arr[size];
        arr[size] = null;
    }

    public int size() {
        return this.size;

    }

    public void print() {
        for (int i = 1; i < size + 1; i++) {
            System.out.print(arr[i].toString() + ", ");
        }
    }

}
