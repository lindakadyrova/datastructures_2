package at.fhj.msd;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
MyQueueList<String> queue = new MyQueueList<>();
queue.put("Ae");
queue.put("Be");
queue.put("Bd");
queue.put("Bc");
System.out.println(queue.get()); // A
System.out.println(queue.size()); // 1

}}
