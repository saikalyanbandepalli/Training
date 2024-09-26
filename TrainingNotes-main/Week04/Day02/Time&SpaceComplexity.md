### Big O Notation

Big O notation is a mathematical representation used to describe the efficiency of an algorithm. It provides an upper bound on the time or space complexity of an algorithm in the worst-case scenario. Big O notation focuses on the growth rate of an algorithm's resource consumption (time or space) as the input size increases.

### Time Complexity

Time complexity measures the amount of time an algorithm takes to complete as a function of the size of the input. Common time complexities include:

#### Constant Time: O(1)
The execution time remains constant regardless of the input size.

```python
def constant_time_example(array):
    return array[0]  # Accessing the first element of an array
```

#### Logarithmic Time: O(log n)
The execution time increases logarithmically as the input size increases. Algorithms that repeatedly divide the input size by a constant factor (e.g., binary search) exhibit logarithmic time complexity.

```python
def binary_search(array, target):
    left, right = 0, len(array) - 1
    while left <= right:
        mid = (left + right) // 2
        if array[mid] == target:
            return mid
        elif array[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1
```

#### Linear Time: O(n)
The execution time increases linearly with the input size.

```python
def linear_time_example(array):
    for element in array:
        print(element)  # Printing all elements of an array
```

#### Linearithmic Time: O(n log n)
The execution time increases linearithmically as the input size increases. Many efficient sorting algorithms (e.g., merge sort, quicksort) have linearithmic time complexity.

```python
def merge_sort(array):
    if len(array) > 1:
        mid = len(array) // 2
        left_half = array[:mid]
        right_half = array[mid:]
        merge_sort(left_half)
        merge_sort(right_half)
        i = j = k = 0
        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                array[k] = left_half[i]
                i += 1
            else:
                array[k] = right_half[j]
                j += 1
            k += 1
        while i < len(left_half):
            array[k] = left_half[i]
            i += 1
            k += 1
        while j < len(right_half):
            array[k] = right_half[j]
            j += 1
            k += 1
```

#### Quadratic Time: O(n²)
The execution time increases quadratically as the input size increases. Algorithms with nested loops over the input (e.g., bubble sort) often exhibit quadratic time complexity.

```python
def bubble_sort(array):
    n = len(array)
    for i in range(n):
        for j in range(0, n-i-1):
            if array[j] > array[j+1]:
                array[j], array[j+1] = array[j+1], array[j]
```

#### Cubic Time: O(n³)
The execution time increases cubically as the input size increases. Algorithms with three nested loops over the input can exhibit cubic time complexity.

```python
def cubic_time_example(matrix):
    n = len(matrix)
    for i in range(n):
        for j in range(n):
            for k in range(n):
                matrix[i][j] += matrix[j][k]  # Example operation on a matrix
```

#### Exponential Time: O(2^n)
The execution time doubles with each additional element in the input. Algorithms that solve problems by recursively breaking them down into smaller subproblems (e.g., the naive solution to the Traveling Salesman Problem) can have exponential time complexity.

```python
def fibonacci_exponential(n):
    if n <= 1:
        return n
    else:
        return fibonacci_exponential(n-1) + fibonacci_exponential(n-2)
```

#### Factorial Time: O(n!)
The execution time grows factorially with the input size. Algorithms that generate all permutations of an input set can have factorial time complexity.

```python
def factorial_time_example(n):
    if n == 0:
        return 1
    else:
        return n * factorial_time_example(n-1)
```

### Space Complexity

Space complexity measures the amount of memory an algorithm uses as a function of the input size. It includes both the memory needed for the input and any additional memory the algorithm requires.

#### Constant Space: O(1)
The algorithm uses a fixed amount of memory regardless of the input size.

```python
def constant_space_example(array):
    sum = 0
    for element in array:
        sum += element  # The space used does not depend on the input size
    return sum
```

#### Linear Space: O(n)
The memory usage grows linearly with the input size.

```python
def linear_space_example(n):
    array = []
    for i in range(n):
        array.append(i)  # The space used grows linearly with n
    return array
```

#### Quadratic Space: O(n²)
The memory usage grows quadratically with the input size.

```python
def quadratic_space_example(n):
    matrix = [[0] * n for _ in range(n)]  # The space used grows quadratically with n
    return matrix
```

### Summary

- **Big O Notation**: Describes the upper bound of the time or space complexity of an algorithm.
- **Time Complexity**: Measures how the runtime of an algorithm scales with the size of the input.
  - Common complexities: O(1), O(log n), O(n), O(n log n), O(n²), O(n³), O(2^n), O(n!).
- **Space Complexity**: Measures how the memory usage of an algorithm scales with the size of the input.
  - Common complexities: O(1), O(n), O(n²).

Understanding Big O notation, time complexity, and space complexity helps in analyzing and comparing the efficiency of different algorithms, enabling the selection of the most appropriate algorithm for a given problem.