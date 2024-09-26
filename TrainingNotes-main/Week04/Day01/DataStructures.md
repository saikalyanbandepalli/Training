### 1. Arrays

Arrays in Java are fixed-size data structures that store elements of the same type in contiguous memory locations.

**Example:**

```java
// Declaration and initialization
int[] arr = new int[5]; // Creates an array of size 5

// Assigning values
arr[0] = 1;
arr[1] = 2;
arr[2] = 3;
arr[3] = 4;
arr[4] = 5;

// Accessing elements
System.out.println(arr[2]); // Output: 3

// Iterating over array
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

### 2. Queue

Queue is a linear data structure that follows the First In, First Out (FIFO) principle, where elements are added at the rear and removed from the front.

**Example using `LinkedList` as a Queue:**

```java
import java.util.LinkedList;
import java.util.Queue;

// Creating a Queue
Queue<Integer> queue = new LinkedList<>();

// Adding elements to the Queue
queue.add(1);
queue.add(2);
queue.add(3);

// Removing elements from the Queue
int removedElement = queue.remove(); // Removes and returns the head of the Queue
System.out.println("Removed Element: " + removedElement);

// Peek at the front element
int frontElement = queue.peek(); // Returns but does not remove the head of the Queue
System.out.println("Front Element: " + frontElement);

// Iterating over Queue (using enhanced for-loop)
for (Integer element : queue) {
    System.out.println(element);
}
```

### 3. Deque (Double-ended Queue)

Deque is a linear data structure that allows elements to be added or removed from both ends (front and rear). In Java, `ArrayDeque` and `LinkedList` can be used to implement a Deque.

**Example using `ArrayDeque`:**

```java
import java.util.ArrayDeque;
import java.util.Deque;

// Creating a Deque
Deque<Integer> deque = new ArrayDeque<>();

// Adding elements at the tail
deque.addLast(1);
deque.addLast(2);
deque.addLast(3);

// Adding elements at the head
deque.addFirst(4);
deque.addFirst(5);

// Removing elements from the tail
int removedTail = deque.removeLast();
System.out.println("Removed from tail: " + removedTail);

// Removing elements from the head
int removedHead = deque.removeFirst();
System.out.println("Removed from head: " + removedHead);

// Iterating over Deque (using enhanced for-loop)
for (Integer element : deque) {
    System.out.println(element);
}
```

### 4. Singly Linked List

Singly Linked List is a linear data structure where each element (node) contains data and a reference to the next node in the sequence.

**Example:**

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Traverse and print elements
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtBeginning(0);

        list.printList(); // Output: 0 1 2
    }
}
```

### 5. Doubly Linked List

Doubly Linked List is a linear data structure where each node contains data and references to both the next and previous nodes.

**Example:**

```java
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        Node last = head;
        newNode.next = null;
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    }

    // Traverse and print elements
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtBeginning(0);

        list.printList(); // Output: 0 1 2
    }
}
```

### Conclusion

These examples provide a basic understanding and implementation of arrays, queues, dequeues, singly linked lists, and doubly linked lists in Java. Each data structure has its characteristics and use cases, and understanding them is crucial for designing efficient and scalable solutions in programming.