
public class TestConsole {

    public static void main(String[] args) {
        CircularQueue<Integer> q = new CircularQueue<Integer>(13);

        for (int i = 0; i < 3; i++) {
            q.enqueue(i);
        }
        for (int i = 0; i < 2; i++) {
            q.dequeue();
        }
        
        
        for (int i = 0; i < 100; i++) {
            q.enqueue(i);
        }
        q.debug();
        q.dequeue();
        for (int i = 0; i < 100; i++) {
            System.out.println(q.dequeue());
        }
    }

}
