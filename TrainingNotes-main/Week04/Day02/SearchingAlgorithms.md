### Linear Search in Java

Linear search, also known as sequential search, is a simple searching algorithm that checks every element in a list until the desired element is found or the list ends. It is straightforward but not very efficient for large datasets.

#### Linear Search Algorithm
1. Start from the first element.
2. Compare the current element with the target element.
3. If the current element matches the target, return the index.
4. If the current element does not match the target, move to the next element.
5. Repeat steps 2-4 until the end of the list is reached.
6. If the end of the list is reached without finding the target, return a value indicating the target is not found (e.g., -1).

#### Linear Search Implementation in Java

```java
public class LinearSearch {
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;  // Return the index of the target element
            }
        }
        return -1;  // Return -1 if the target element is not found
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int target = 30;
        int index = linearSearch(numbers, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
```

### Binary Search in Java

Binary search is a more efficient algorithm that works on sorted arrays. It uses a divide-and-conquer approach to reduce the search space by half with each iteration. Binary search has a time complexity of O(log n), making it much faster than linear search for large datasets.

#### Binary Search Algorithm
1. Find the middle element of the array.
2. Compare the middle element with the target element.
3. If the middle element matches the target, return the index.
4. If the middle element is greater than the target, repeat the process for the left half of the array.
5. If the middle element is less than the target, repeat the process for the right half of the array.
6. If the subarray reduces to zero size without finding the target, return a value indicating the target is not found (e.g., -1).

#### Binary Search Implementation in Java

##### Iterative Version

```java
public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is present at mid
            if (array[mid] == target) {
                return mid;  // Return the index of the target element
            }

            // If target is greater, ignore the left half
            if (array[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        return -1;  // Return -1 if the target element is not found
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int target = 30;
        int index = binarySearch(numbers, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
```

##### Recursive Version

```java
public class BinarySearchRecursive {
    public static int binarySearch(int[] array, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is present at mid
            if (array[mid] == target) {
                return mid;  // Return the index of the target element
            }

            // If target is greater, ignore the left half
            if (array[mid] < target) {
                return binarySearch(array, target, mid + 1, right);
            }

            // If target is smaller, ignore the right half
            return binarySearch(array, target, left, mid - 1);
        }

        return -1;  // Return -1 if the target element is not found
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int target = 30;
        int index = binarySearch(numbers, target, 0, numbers.length - 1);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
```

### Comparison of Linear Search and Binary Search

- **Time Complexity**:
  - Linear Search: O(n)
  - Binary Search: O(log n)
- **Data Requirement**:
  - Linear Search: Can work on unsorted data.
  - Binary Search: Requires sorted data.
- **Implementation**:
  - Linear Search: Simple and straightforward.
  - Binary Search: Slightly more complex, especially the recursive version.
- **Use Cases**:
  - Linear Search: Suitable for small or unsorted datasets.
  - Binary Search: Preferred for large, sorted datasets due to its efficiency.