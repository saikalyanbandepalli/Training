### Installation

First, install React Router DOM using npm or yarn:

```bash
npm install react-router-dom
```

or

```bash
yarn add react-router-dom
```

### Basic Setup

1. **Setting up the Router**: Wrap your application in a `Router` component (`BrowserRouter` in this case).

```jsx
// App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './Home';
import About from './About';
import Contact from './Contact';
import Dashboard from './Dashboard';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/dashboard/*" element={<Dashboard />} /> {/*dashboard followed by any path params*/}
        <Route path="/users/:username" element={<Profile />} /> {/*Passing path params to component*/}
      </Routes>
    </Router>
  );
}

export default App;
```

### Nested Routes

2. **Nested Routes**: Create a component with nested routes using the `Routes` and `Route` components.

```jsx
// Dashboard.js
import React from 'react';
import { Routes, Route, Link, Outlet } from 'react-router-dom';
import Profile from './Profile';
import Settings from './Settings';

function Dashboard() {
  return (
    <div>
      <h2>Dashboard</h2>
      <nav>
        <ul>
          <li><Link to="profile">Profile</Link></li>
          <li><Link to="settings">Settings</Link></li>
        </ul>
      </nav>
      <Routes>
        <Route path="profile" element={<Profile />} />
        <Route path="settings" element={<Settings />} />
      </Routes>
      <Outlet /> {/* This will render nested routes */}
    </div>
  );
}

export default Dashboard;
```

### Using useParams

3. **Using `useParams`**: Access URL parameters within a component using the `useParams` hook.

```jsx
// Profile.js
import React from 'react';
import { useParams } from 'react-router-dom';

function Profile() {
  let { username } = useParams();
  return <h2>Profile Page of {username}</h2>;
}

export default Profile;
```

### Using useNavigate

4. **Using `useNavigate`**: Programmatically navigate to different routes using the `useNavigate` hook.

```jsx
// Navigation.js
import React from 'react';
import { Link, useNavigate } from 'react-router-dom';

function Navigation() {
  let navigate = useNavigate();

  function handleClick() {
    navigate('/about'); // Navigate to /about route
  }

  return (
    <nav>
      <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/about">About</Link></li>
        <li><button onClick={handleClick}>Go to About</button></li>
      </ul>
    </nav>
  );
}

export default Navigation;
```

### Protecting Routes

5. **Protecting Routes**: Conditionally render routes based on authentication status using a custom `PrivateRoute` component.

```jsx
// PrivateRoute.js
import React from 'react';
import { Route, Navigate } from 'react-router-dom';

function PrivateRoute({ element: Component, ...rest }) {
  const isAuthenticated = // ... your authentication logic

  return isAuthenticated ? <Route {...rest} element={<Component />} /> : <Navigate to="/login" />;
}

export default PrivateRoute;
```

### Lazy Loading

6. **Lazy Loading**: Use `React.lazy` and `Suspense` for lazy loading components.

```jsx
// LazyLoadedComponent.js
import React from 'react';

function LazyLoadedComponent() {
  return <h2>Lazy Loaded Component</h2>;
}

export default LazyLoadedComponent;
```

```jsx
// App.js
import React, { Suspense } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

const LazyLoadedComponent = React.lazy(() => import('./LazyLoadedComponent'));

function App() {
  return (
    <Router>
      <Suspense fallback={<div>Loading...</div>}>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/lazy" element={<LazyLoadedComponent />} />
        </Routes>
      </Suspense>
    </Router>
  );
}

export default App;
```

### Key Points

- **Router Setup**: Wrap your application in `Router` (e.g., `BrowserRouter`) at the top level.
- **Nested Routes**: Use `Routes` and `Route` components for nested routing.
- **URL Parameters**: Access URL parameters using the `useParams` hook.
- **Programmatic Navigation**: Use the `useNavigate` hook to navigate programmatically.
- **Protecting Routes**: Conditionally render routes using a custom `PrivateRoute` component.
- **Lazy Loading**: Use `React.lazy` and `Suspense` for lazy loading components to improve performance.

By following these steps and incorporating these hooks and concepts, you can effectively use React Router DOM in your applications with nested routes, parameter handling, and more advanced navigation features.