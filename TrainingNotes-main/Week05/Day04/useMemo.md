The `useMemo` hook in React is used to memoize the result of a computation and recompute it only when one of its dependencies changes. This can improve performance by avoiding expensive calculations on every render.

### Syntax

```javascript
const memoizedValue = useMemo(() => computeExpensiveValue(a, b), [a, b]);
```

- The first argument is a function that computes the memoized value.
- The second argument is an array of dependencies. The memoized value will only be recomputed if one of these dependencies changes.

### When to Use `useMemo`

1. **Expensive Calculations**: If you have a function that performs a heavy computation, you can use `useMemo` to memoize the result so it doesn’t have to be recalculated on every render.
2. **Referential Equality**: When passing objects or arrays to child components, `useMemo` can help ensure that the reference to the object/array remains stable across renders unless the contents change.

### Example: Expensive Calculation

Consider a component that performs a computationally expensive operation.

```jsx
import React, { useMemo, useState } from 'react';

function ExpensiveComponent({ num }) {
  const calculateFactorial = (n) => {
    console.log('Calculating factorial...');
    return n <= 0 ? 1 : n * calculateFactorial(n - 1);
  };

  const factorial = useMemo(() => calculateFactorial(num), [num]);

  return (
    <div>
      <p>Factorial of {num} is {factorial}</p>
    </div>
  );
}

function App() {
  const [num, setNum] = useState(5);

  return (
    <div>
      <ExpensiveComponent num={num} />
      <button onClick={() => setNum(num + 1)}>Increment</button>
    </div>
  );
}

export default App;
```

In this example:
- The `calculateFactorial` function is expensive, so we use `useMemo` to memoize the result.
- The factorial is only recalculated when `num` changes.

### Example: Referential Equality

When passing objects to child components, `useMemo` can ensure that the reference remains the same unless the contents change.

```jsx
import React, { useMemo, useState } from 'react';

function ChildComponent({ config }) {
  console.log('Child component re-rendered');
  return <div>Configuration: {JSON.stringify(config)}</div>;
}

function ParentComponent() {
  const [count, setCount] = useState(0);

  const config = useMemo(() => ({ color: 'blue' }), []);

  return (
    <div>
      <ChildComponent config={config} />
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
}

export default ParentComponent;
```

In this example:
- The `config` object is memoized using `useMemo`.
- The `ChildComponent` only re-renders when `config` changes, which it doesn’t in this case, because the dependencies array is empty.

### Performance Considerations

- **Cost of Memoization**: Memoization itself has a cost. Using `useMemo` unnecessarily can lead to overhead. Use it when you have a genuine performance bottleneck due to expensive calculations or when referential equality is critical.
- **Dependencies Array**: Ensure that the dependencies array accurately reflects all values that the memoized function depends on. Incorrect dependencies can lead to stale values or unnecessary recalculations.

### Common Pitfalls

1. **Incorrect Dependencies**: If you omit a dependency that changes, `useMemo` will not recompute the value when needed, leading to bugs.
2. **Overuse**: Applying `useMemo` to simple calculations or components that already render quickly can add unnecessary complexity without a real performance benefit.

### Conclusion

The `useMemo` hook is a powerful tool for optimizing performance in React applications by memoizing expensive computations and ensuring referential equality. Use it judiciously to avoid unnecessary recalculations and re-renders in your components.