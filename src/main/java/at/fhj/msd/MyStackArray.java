package at.fhj.msd;

import java.nio.channels.Pipe.SourceChannel;

public class MyStackArray<E> {
  private E[] stack;
  int n;
  int top;
  int size;

  public MyStackArray(int size) { // Wir übergeben eine Größe
    n = size; // Die größe wird in n gespeichert
    stack = (E[]) new Object[n + 1]; // es wird ein neues array mit der größe größe +1 erstellt
    top = 0; // Das Array ist leer zu beginn
  }

  public boolean isEmpty() {
    return top == 0;
  }

  public int size() {
    return size;
  }

  public void push(E x) {
    if (top == stack.length) {
      throw new RuntimeException("Overflow");
    }
    stack[top] = x;
    top++;
    size++;
  }

  public E pop() {
    if (top == 0) {
      throw new RuntimeException("Underflow");
    }
    top = top - 1;
    E item = stack[top];
    stack[top] = null; 
    return item;

//     public E pop() {
//     if (top == 0) {
//         throw new RuntimeException("Underflow");
//     }
//     top = top - 1;
//     size--;
//     return stack[top];
// }


  }

}
