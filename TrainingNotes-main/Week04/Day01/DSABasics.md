Data Structures and Algorithms (DSA) form the foundation of computer science and software development. Understanding these concepts is crucial for writing efficient and optimized code. Here's a detailed overview of the basics of DSA:

### Data Structures

Data structures are ways to organize and store data so that it can be accessed and modified efficiently. The choice of a data structure directly affects the performance of an algorithm.

#### 1. Arrays
**Definition:** A collection of elements identified by index or key.
**Properties:**
- Fixed size
- Random access time is O(1)
**Example:**

```java
int[] arr = new int[5];
arr[0] = 1;
arr[1] = 2;
```

#### 2. Linked List
**Definition:** A linear collection of elements where each element points to the next.
**Types:**
- Singly Linked List
- Doubly Linked List
**Example (Singly Linked List):**

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
}
```

#### 3. Stack
**Definition:** A collection of elements that follows the Last In, First Out (LIFO) principle.
**Operations:**
- Push
- Pop
- Peek
**Example:**

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.pop();
```

#### 4. Queue
**Definition:** A collection of elements that follows the First In, First Out (FIFO) principle.
**Operations:**
- Enqueue
- Dequeue
- Peek
**Example:**

```java
import java.util.LinkedList;
import java.util.Queue;

Queue<Integer> queue = new LinkedList<>();
queue.add(1);
queue.add(2);
queue.remove();
```

#### 5. HashMap
**Definition:** A collection of key-value pairs with average O(1) time complexity for insertions and lookups.
**Example:**

```java
import java.util.HashMap;

HashMap<String, Integer> map = new HashMap<>();
map.put("one", 1);
map.put("two", 2);
int value = map.get("one");
```

#### 6. Trees
**Definition:** A hierarchical structure with a root node and child nodes.
**Types:**
- Binary Tree
- Binary Search Tree (BST)
- AVL Tree
- Red-Black Tree
**Example (Binary Search Tree):**

```java
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

    BinaryTree() {
        root = null;
    }

    void insert(int data) {
        root = insertRec(root, data);
    }

    TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }
}
```

#### 7. Graphs
**Definition:** A collection of nodes (vertices) and edges.
**Types:**
- Directed Graph (Digraph)
- Undirected Graph
**Representation:**
- Adjacency Matrix
- Adjacency List
**Example (Adjacency List):**

```java
import java.util.LinkedList;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
```

### Algorithms

Algorithms are step-by-step procedures or formulas for solving problems. Efficiency of an algorithm is measured in terms of time complexity and space complexity.

#### 1. Sorting Algorithms
**Definition:** Algorithms to arrange data in a particular order.
**Types:**
- Bubble Sort
- Selection Sort
- Insertion Sort
- Merge Sort
- Quick Sort
**Example (Bubble Sort):**

```java
public class BubbleSort {
    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - 1 - i; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}
```

#### 2. Search Algorithms
**Definition:** Algorithms to find an element in a data structure.
**Types:**
- Linear Search
- Binary Search
**Example (Binary Search):**

```java
public class BinarySearch {
    int binarySearch(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }
}
```

#### 3. Recursive Algorithms
**Definition:** Algorithms that call themselves with a subset of the original problem.
**Example (Factorial):**

```java
public class Factorial {
    int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }
}
```

#### 4. Graph Algorithms
**Definition:** Algorithms to solve problems on graphs.
**Types:**
- Depth-First Search (DFS)
- Breadth-First Search (BFS)
- Dijkstra's Algorithm
- Prim's Algorithm
**Example (Depth-First Search):**

```java
class Graph {
    private LinkedList<Integer> adj[];

    Graph(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[adj.length];
        DFSUtil(v, visited);
    }
}
```

### Conclusion

Understanding these fundamental data structures and algorithms is essential for solving complex problems efficiently. Mastery of these concepts will provide a strong foundation for more advanced topics in computer science and software development.