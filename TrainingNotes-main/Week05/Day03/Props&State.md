In React, `props` and `state` are two fundamental concepts used to manage data and control how components render and behave. Understanding the differences and when to use each is crucial for building React applications efficiently.

### Props

**Props (short for "properties")** are data passed from a parent component to a child component. They are immutable and are used to customize or configure a child component when it is created. Here’s how props work:

1. **Passing Props**: Props are passed from parent to child components in JSX attributes.

   ```jsx
   // ParentComponent.js
   import React from 'react';
   import ChildComponent from './ChildComponent';

   function ParentComponent() {
     const name = 'John';
     return <ChildComponent name={name} />;
   }

   export default ParentComponent;
   ```

   ```jsx
   // ChildComponent.js
   import React from 'react';

   function ChildComponent(props) {
     return <h1>Hello, {props.name}!</h1>;
   }

   export default ChildComponent;
   ```

2. **Immutable**: Props cannot be modified by the child component; they are read-only.

3. **Functionality**: Props are typically used to pass data and event handlers from parent to child components, allowing customization and reusability.

### State

**State** is managed within a component and represents mutable data that affects the rendering of the component. State allows React components to have dynamic behavior and interactive features. Here’s how state works:

1. **Declaring State**: State is initialized in a class component using the `state` property or in a functional component using the `useState` hook.

   ```jsx
   // Class Component with State
   import React, { Component } from 'react';

   class Counter extends Component {
     constructor(props) {
       super(props);
       this.state = {
         count: 0
       };
     }

     render() {
       return (
         <div>
           <p>Count: {this.state.count}</p>
           <button onClick={() => this.setState({ count: this.state.count + 1 })}>
             Increment
           </button>
         </div>
       );
     }
   }

   export default Counter;
   ```

   ```jsx
   // Functional Component with State using Hooks
   import React, { useState } from 'react';

   function Counter() {
     const [count, setCount] = useState(0);

     return (
       <div>
         <p>Count: {count}</p>
         <button onClick={() => setCount(count + 1)}>
           Increment
         </button>
       </div>
     );
   }

   export default Counter;
   ```

2. **Updating State**: State should be updated using the `setState` method (for class components) or the function returned by `useState` (for functional components). Directly modifying state via `this.state` or `useState` setter outside of these methods can lead to bugs.

3. **Local to Component**: State is local and specific to each component instance. Changes to state trigger re-renders, updating the UI to reflect the new state.

4. **Lifting State Up**: When multiple components need access to the same state or need to share state, it’s lifted up to the nearest common ancestor (usually a parent component) that manages the state and passes it down as props.

### When to Use Props vs State

- **Props** are used to pass data from parent to child components and are immutable within the child component. They are suitable for configuring and customizing child components based on parent data.

- **State** is used to manage dynamic data within a component. It is mutable and triggers re-renders when updated. State is typically used for user input, UI state (like toggling a modal), and other dynamic behaviors within a component.

### Conclusion

Understanding how to use props and state effectively is essential for building React applications. By using props to pass data and state to manage dynamic behavior, you can create flexible and interactive user interfaces that respond dynamically to user input and external data changes.