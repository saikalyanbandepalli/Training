Higher-Order Components (HOCs) are an advanced technique in React for reusing component logic. HOCs are not part of the React API. They are a pattern that emerges from React’s compositional nature.

### What is a Higher-Order Component?

A higher-order component is a function that takes a component and returns a new component. HOCs can be used to add additional props, state, or behavior to the original component.

### Syntax of Higher-Order Components

Here is the basic syntax of an HOC:

```jsx
function withExtraProps(WrappedComponent) {
  return function EnhancedComponent(props) {
    return <WrappedComponent extraProp="someValue" {...props} />;
  };
}
```

### Example of Higher-Order Component

Let's create a simple example where we use an HOC to add authorization logic to a component.

1. **Create the HOC**

   ```jsx
   // src/withAuth.js
   import React from 'react';

   function withAuth(Component) {
     return function AuthComponent(props) {
       const isAuthenticated = true; // Replace with real authentication logic

       if (!isAuthenticated) {
         return <p>You need to be logged in to view this content.</p>;
       }

       return <Component {...props} />;
     };
   }

   export default withAuth;
   ```

2. **Create a Protected Component**

   ```jsx
   // src/ProtectedComponent.js
   import React from 'react';

   function ProtectedComponent() {
     return <h1>This is a protected component.</h1>;
   }

   export default ProtectedComponent;
   ```

3. **Wrap the Component with the HOC**

   ```jsx
   // src/App.js
   import React from 'react';
   import withAuth from './withAuth';
   import ProtectedComponent from './ProtectedComponent';

   const ProtectedComponentWithAuth = withAuth(ProtectedComponent);

   function App() {
     return (
       <div>
         <h1>App</h1>
         <ProtectedComponentWithAuth />
       </div>
     );
   }

   export default App;
   ```

### Key Points to Remember

1. **Pure Functions**: HOCs should be pure functions. They should not modify the original component, but rather return a new component with enhanced behavior.
2. **Static Methods**: Static methods on the wrapped component are not automatically copied to the enhanced component. You might need to manually copy them.
3. **Refs**: HOCs don’t work with refs in the same way. If you need to pass refs, you might want to use `React.forwardRef` to forward the ref through the HOC.
4. **Naming Conventions**: It’s common to prefix HOCs with `with`, like `withAuth` or `withLoading`, to indicate that they add some behavior to the wrapped component.

### Conclusion

Higher-Order Components are a powerful pattern for reusing component logic in React. They allow you to add additional props, state, or behavior to existing components without modifying them directly. By following best practices, you can create reusable and composable components that make your React applications more maintainable and scalable.