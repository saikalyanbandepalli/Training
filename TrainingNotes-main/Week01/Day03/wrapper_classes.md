
### Wrapper Classes

Wrapper classes in Java provide a way to use primitive data types (int, char, etc.) as objects. Each primitive data type has a corresponding wrapper class in the `java.lang` package:

- `byte` -> `Byte`

- `short` -> `Short`

- `int` -> `Integer`

- `long` -> `Long`

- `float` -> `Float`

- `double` -> `Double`

- `char` -> `Character`

- `boolean` -> `Boolean`

These classes encapsulate a primitive type value in an object. Wrapper classes are useful in several scenarios such as working with collections (like `ArrayList`) that cannot store primitive types directly, needing to convert primitives to strings, or using methods that require objects.

### Autoboxing

Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. For example, converting an `int` to an `Integer`, a `double` to a `Double`, and so on. This feature was introduced in Java 5.

Here's an example of autoboxing:

```java

int num = 10;

Integer numObj = num; // Autoboxing: int to Integer

```

### Unboxing

Unboxing is the reverse process where the Java compiler automatically converts an object of a wrapper class to its corresponding primitive type. For example, converting an `Integer` to an `int`, a `Double` to a `double`, and so on.

Here's an example of unboxing:

```java

Integer numObj = 10;

int num = numObj; // Unboxing: Integer to int

```

### Examples

Here are a few examples demonstrating autoboxing and unboxing:

1\. **Autoboxing with Collections:**

```java

   import java.util.ArrayList;

   public class AutoboxingExample {

       public static void main(String[] args) {

           ArrayList<Integer> list = new ArrayList<>();

           list.add(10); // Autoboxing: int to Integer

           list.add(20);

           System.out.println(list);

       }

   }

```

2\. **Unboxing in Expressions:**

```java

   public class UnboxingExample {

       public static void main(String[] args) {

           Integer numObj = 10;

           int num = numObj; // Unboxing: Integer to int

           int result = numObj + 5; // Unboxing: Integer to int during addition

           System.out.println(result);

       }

   }

```

3\. **Autoboxing and Unboxing in Methods:**

```java

   public class BoxingUnboxingExample {

       public static void main(String[] args) {

           int num = 10;

           Integer numObj = box(num); // Autoboxing

           int result = unbox(numObj); // Unboxing

           System.out.println("Boxed: " + numObj);

           System.out.println("Unboxed: " + result);

       }

       public static Integer box(int num) {

           return num; // Autoboxing

       }

       public static int unbox(Integer numObj) {

           return numObj; // Unboxing

       }

   }

```

### Performance Considerations

While autoboxing and unboxing provide a convenient way to work with primitives and their wrapper classes, they come with some performance overhead due to the additional object creation and the possibility of `NullPointerException` if the wrapper class object is null during unboxing.

Therefore, it's important to be mindful of these aspects, especially in performance-critical sections of code.

### Summary

- **Wrapper Classes:** Provide object representation for primitive data types.

- **Autoboxing:** Automatic conversion from a primitive type to its corresponding wrapper class.

- **Unboxing:** Automatic conversion from a wrapper class to its corresponding primitive type.

These features make it easier to work with collections and APIs that require objects, while still allowing you to use primitive types for their performance benefits.
