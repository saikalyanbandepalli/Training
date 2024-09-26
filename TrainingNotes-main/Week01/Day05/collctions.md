In Java, collections are used to group multiple elements into a single unit. They provide a way to store, retrieve, and manipulate data efficiently. Java's collections framework includes several interfaces and classes that represent different types of collections, each serving a specific purpose. Here's an overview of Java collections with examples:

### Interfaces in Java Collections Framework

1\. **List**:

   - Ordered collection (elements are stored in insertion order).

   - Allows duplicate elements.

   - Examples: `ArrayList`, `LinkedList`.

```java

   // ArrayList example

   import java.util.ArrayList;

   import java.util.List;

   public class ListExample {

       public static void main(String[] args) {

           List<String> list = new ArrayList<>();

           list.add("Apple");

           list.add("Banana");

           list.add("Orange");

           for (String fruit : list) {

               System.out.println(fruit);

           }

       }

   }

```

2\. **Set**:

   - Unordered collection (no guarantee of order).

   - Does not allow duplicate elements.

   - Examples: `HashSet`, `TreeSet`.

```java

   // HashSet example

   import java.util.HashSet;

   import java.util.Set;

   public class SetExample {

       public static void main(String[] args) {

           Set<String> set = new HashSet<>();

           set.add("Apple");

           set.add("Banana");

           set.add("Orange");

           for (String fruit : set) {

               System.out.println(fruit);

           }

       }

   }

```

3\. **Map**:

   - Key-value pair collection.

   - Each key is unique.

   - Examples: `HashMap`, `TreeMap`.

```java

   // HashMap example

   import java.util.HashMap;

   import java.util.Map;

   public class MapExample {

       public static void main(String[] args) {

           Map<String, Integer> map = new HashMap<>();

           map.put("Apple", 10);

           map.put("Banana", 5);

           map.put("Orange", 8);

           for (Map.Entry<String, Integer> entry : map.entrySet()) {

               System.out.println(entry.getKey() + " -> " + entry.getValue());

           }

       }

   }

```

4\. **Queue**:

   - Represents a collection designed for holding elements before processing.

   - Generally follows FIFO (First-In-First-Out) order.

   - Examples: `LinkedList`, `PriorityQueue`.

```java

   // Queue example

   import java.util.LinkedList;

   import java.util.Queue;

   public class QueueExample {

       public static void main(String[] args) {

           Queue<String> queue = new LinkedList<>();

           queue.add("Task1");

           queue.add("Task2");

           queue.add("Task3");

           while (!queue.isEmpty()) {

               System.out.println(queue.poll());

           }

       }

   }

```

5\. **Deque**:

   - Double-ended queue that supports element insertion and removal at both ends.

   - Examples: `ArrayDeque`, `LinkedList`.

```java

   // Deque example

   import java.util.ArrayDeque;

   import java.util.Deque;

   public class DequeExample {

       public static void main(String[] args) {

           Deque<String> deque = new ArrayDeque<>();

           deque.addFirst("First");

           deque.addLast("Last");

           System.out.println("First element: " + deque.getFirst());

           System.out.println("Last element: " + deque.getLast());

       }

   }

```

### Common Operations on Collections

- **Adding elements**: `add()`, `addAll()`

- **Removing elements**: `remove()`, `clear()`

- **Accessing elements**: `get()`, `iterator()`, `forEach()`

- **Checking size**: `size()`, `isEmpty()`

- **Searching**: `contains()`, `indexOf()`, `containsKey()`, `containsValue()`

- **Sorting**: `Collections.sort()` (for `List`), `TreeMap` (for `Map`)

### Collections Utility Class

Java also provides a `Collections` class in `java.util` package that contains various static methods to operate on collections:

```java

// Sorting example using Collections class

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

public class CollectionsExample {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(5);

        numbers.add(2);

        numbers.add(7);

        Collections.sort(numbers);

        for (int num : numbers) {

            System.out.println(num);

        }

    }

}

```

### Benefits of Using Java Collections

- **Efficient data storage and retrieval**: Collections provide optimized data structures for specific needs.

- **Built-in algorithms**: Many operations like sorting and searching are readily available.

- **Type safety**: Generics ensure type safety, preventing runtime errors.

Java's collections framework is versatile and widely used in various applications due to its efficiency, flexibility, and comprehensive set of features for managing and manipulating data structures.