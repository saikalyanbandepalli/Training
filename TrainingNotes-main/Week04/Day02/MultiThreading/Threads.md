In Java, there are two primary ways to create and work with threads: by extending the `Thread` class and by implementing the `Runnable` interface. Both approaches allow you to define the code that will run concurrently within a separate thread of execution. Here's how each method works and when you might choose one over the other:

### Extending the `Thread` Class

When you extend the `Thread` class, you create a subclass that directly inherits from `Thread`. This subclass overrides the `run()` method to define the code that the thread will execute. Here's a step-by-step explanation:

1. **Create a Thread Subclass**: Define a new class that extends `Thread` and override the `run()` method with the code you want to run in parallel.

   ```java
   public class MyThread extends Thread {
       @Override
       public void run() {
           System.out.println("Thread is running");
       }
   }
   ```

2. **Instantiate and Start the Thread**: Create an instance of your custom thread class and call `start()` to begin its execution.

   ```java
   public class Main {
       public static void main(String[] args) {
           MyThread thread = new MyThread();
           thread.start(); // Start the thread
       }
   }
   ```

### Implementing the `Runnable` Interface

Implementing the `Runnable` interface separates the thread's behavior from the thread itself. You define a class that implements `Runnable` and pass an instance of this class to a `Thread` object's constructor. Here's how you can do it:

1. **Create a Runnable Class**: Implement the `Runnable` interface and override its `run()` method with the thread's logic.

   ```java
   public class MyRunnable implements Runnable {
       @Override
       public void run() {
           System.out.println("Runnable thread is running");
       }
   }
   ```

2. **Create a Thread and Start It**: Create a `Thread` object, passing an instance of your `Runnable` class to its constructor, and then call `start()`.

   ```java
   public class Main {
       public static void main(String[] args) {
           MyRunnable myRunnable = new MyRunnable();
           Thread thread = new Thread(myRunnable);
           thread.start(); // Start the thread
       }
   }
   ```

### Choosing Between Extending Thread and Implementing Runnable

- **Extending `Thread`**:
  - Provides a simpler approach when you need to define a thread with specific behavior directly.
  - Less flexible because Java does not support multiple inheritance, limiting the subclass from extending other classes.

- **Implementing `Runnable`**:
  - Allows your class to extend another class or implement multiple interfaces, promoting better object-oriented design.
  - Promotes separation of concerns by separating thread logic from thread management (via `Thread`).

### Thread Lifecycle

Regardless of whether you extend `Thread` or implement `Runnable`, threads follow the same lifecycle (new, runnable, running, blocked, terminated). The `start()` method begins execution, and the `run()` method contains the thread's code. Other methods (`sleep()`, `join()`, etc.) are used similarly in both approaches to manage thread behavior.

### Example: Combined Approach

You can also combine the two approaches by extending `Thread` and implementing `Runnable` for added flexibility:

```java
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
```

In this combined example, `MyThread` extends `Thread` and overrides `run()` to define the thread's behavior directly.

### Summary

- **Extending `Thread`**: Directly subclass `Thread`, overriding `run()` to define thread behavior. Simple but limits class inheritance.
- **Implementing `Runnable`**: Implement `Runnable`, passing an instance to a `Thread` object. Promotes better design and flexibility.

Both methods are essential for managing threads in Java, allowing you to implement concurrent programming effectively based on your application's requirements and design preferences.