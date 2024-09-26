import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import { ExpenseProvider } from './ExpenseContext';
import ExpenseForm from './ExpenseForm';
import ExpenseList from './ExpenseList';
import Dashboard from './Dashboard';

const App = () => {
  return (
    <Router>
      <ExpenseProvider>
        <nav>
          <ul>
            <li><Link to="/">Dashboard</Link></li>
            <li><Link to="/add-expense">Add Expense</Link></li>
            <li><Link to="/expenses">View Expenses</Link></li>
          </ul>
        </nav>
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/add-expense" element={<ExpenseForm />} />
          <Route path="/expenses" element={<ExpenseList />} />
        </Routes>
      </ExpenseProvider>
    </Router>
  );
};

export default App;
