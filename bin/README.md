# datastructures_2

Member 1: Linda Kadyrova\
Member 2: Marcha Tuzaeva

## Indroduction
In the second Assignment in database and algorithms we have to implement 

* a Stack Array
* a Stack List
* a Queue Array
* a Queue List

## MyStackArray 


**MyStackArray** is a simple generic stack implementation using an array.

### Features

* Supports generic types (`<E>`)
* Fixed size (set via constructor)
* Methods: `push()`, `pop()`, `isEmpty()`, `size()`
* Throws `RuntimeException` on overflow or underflow

### Example

```java
MyStackArray<Integer> stack = new MyStackArray<>(5);
stack.push(10);
stack.push(20);
System.out.println(stack.pop()); // 20
```

## MyQueueList

**MyQueueList** is a generic queue implementation using a doubly linked list.

### Features

* Supports generic types (`<E>`)
* Dynamic size (grows with elements)
* Methods: `put()`, `get()`, `isEmpty()`, `size()`
* `get()` returns `null` if queue is empty

### Example

```java
MyQueueList<String> queue = new MyQueueList<>();
queue.put("A");
queue.put("B");
System.out.println(queue.get()); // A
System.out.println(queue.size()); // 1
```