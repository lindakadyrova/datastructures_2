package at.fhj.msd;

/**
 * A generic stack implementation using an array.
 *
 * @param <E> the type of elements held in this stack
 */
public class MyStackArray<E> {
  private E[] stack;
  int n;
  int top;
  int size;

  /**
   * Constructs a new stack with the given maximum size.
   *
   * @param size the maximum number of elements the stack can hold
   */
  public MyStackArray(int size) {
    n = size;
    stack = (E[]) new Object[n + 1];
    top = 0;
  }

  /**
   * Checks if the stack is empty.
   *
   * @return {@code true} if the stack is empty, {@code false} otherwise
   */
  public boolean isEmpty() {
    return top == 0;
  }

  /**
   * Returns the current number of elements in the stack.
   *
   * @return the size of the stack
   */
  public int size() {
    return size;
  }

  /**
   * Pushes an element onto the stack.
   *
   * @param x the element to be pushed
   * @throws RuntimeException if the stack is full (overflow)
   */
  public void push(E x) {
    if (top == stack.length) {
      throw new RuntimeException("Overflow");
    }
    stack[top] = x;
    top++;
    size++;
  }

  /**
   * Pops the top element from the stack.
   *
   * @return the element removed from the top of the stack
   * @throws RuntimeException if the stack is empty (underflow)
   */
  public E pop() {
    if (top == 0) {
      throw new RuntimeException("Underflow");
    }
    top = top - 1;
    size--;
    return stack[top];
  }
}
