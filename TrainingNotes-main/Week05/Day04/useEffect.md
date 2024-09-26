The `useEffect` hook in React is used to handle side effects in function components. Side effects are operations that affect something outside the scope of the function being executed, such as fetching data, subscribing to events, or manually changing the DOM.

### Basic Usage

Here's the basic syntax of `useEffect`:

```jsx
import React, { useEffect, useState } from 'react';

function ExampleComponent() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    // Code to run on component mount
    document.title = `You clicked ${count} times`;

    // Cleanup function to run on component unmount
    return () => {
      // Cleanup code (if necessary)
    };
  }, [count]); // Dependency array

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>Click me</button>
    </div>
  );
}

export default ExampleComponent;
```

### Detailed Explanation

1. **Running Effects**:
   - `useEffect` runs after the render is committed to the screen. By default, it runs both after the initial render and after every update.

2. **Dependency Array**:
   - The second argument to `useEffect` is an array of dependencies. If any of the values in this array change, the effect will run again. If you pass an empty array (`[]`), the effect will run only once, similar to `componentDidMount` in class components.
   - If you omit the dependency array, the effect runs after every render.

3. **Cleanup Function**:
   - The function returned from the `useEffect` hook is the cleanup function. It runs before the effect is re-executed due to dependencies changing and before the component unmounts. This is useful for cleaning up subscriptions, timers, or other side effects to prevent memory leaks.

### Example Scenarios

#### 1. Fetching Data

```jsx
import React, { useState, useEffect } from 'react';

function DataFetchingComponent() {
  const [data, setData] = useState(null);

  useEffect(() => {
    async function fetchData() {
      const response = await fetch('https://api.example.com/data');
      const result = await response.json();
      setData(result);
    }

    fetchData();
  }, []); // Empty array means this effect runs once on mount

  return (
    <div>
      {data ? <p>{JSON.stringify(data)}</p> : <p>Loading...</p>}
    </div>
  );
}

export default DataFetchingComponent;
```

#### 2. Subscribing to Events

```jsx
import React, { useState, useEffect } from 'react';

function EventListeningComponent() {
  const [windowWidth, setWindowWidth] = useState(window.innerWidth);

  useEffect(() => {
    const handleResize = () => setWindowWidth(window.innerWidth);
    window.addEventListener('resize', handleResize);

    return () => {
      window.removeEventListener('resize', handleResize); // Cleanup on unmount
    };
  }, []); // Empty array means this effect runs once on mount

  return (
    <div>
      <p>Window width: {windowWidth}</p>
    </div>
  );
}

export default EventListeningComponent;
```

### Combining Multiple Effects

You can use multiple `useEffect` hooks in a single component to handle different side effects independently:

```jsx
import React, { useState, useEffect } from 'react';

function MultipleEffectsComponent() {
  const [count, setCount] = useState(0);
  const [data, setData] = useState(null);

  // Effect for updating the document title
  useEffect(() => {
    document.title = `You clicked ${count} times`;
  }, [count]);

  // Effect for fetching data
  useEffect(() => {
    async function fetchData() {
      const response = await fetch('https://api.example.com/data');
      const result = await response.json();
      setData(result);
    }

    fetchData();
  }, []);

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>Click me</button>
      <div>
        {data ? <p>{JSON.stringify(data)}</p> : <p>Loading...</p>}
      </div>
    </div>
  );
}

export default MultipleEffectsComponent;
```

### Common Pitfalls

1. **Missing Dependencies**: Always include all state and props used inside the effect in the dependency array. Otherwise, you might encounter stale closures, leading to bugs.
   
2. **Infinite Loops**: Avoid causing infinite loops by correctly setting the dependency array. If your effect runs too often, check if the dependencies are changing unintentionally.

3. **Race Conditions**: When dealing with asynchronous effects like data fetching, ensure that you handle potential race conditions by tracking if the component is still mounted or using state management libraries.

### Conclusion

The `useEffect` hook is a powerful way to manage side effects in functional components. By understanding and properly using the dependency array and cleanup functions, you can handle a wide range of use cases effectively and efficiently.