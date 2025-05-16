package at.fhj.msd;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
MyStackArray<String> ar = new MyStackArray<>(6);
ar.push("0");
ar.push("22");
ar.push("24");
ar.push("23");
ar.push("3");
ar.push("1");

System.out.println(ar.pop());
System.out.println(ar.pop());
}
}
