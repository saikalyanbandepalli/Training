import React, { useContext } from 'react';
import { ExpenseContext } from './ExpenseContext';

const Dashboard = () => {
  const { expenses, userSettings } = useContext(ExpenseContext);

  const totalExpenses = expenses.reduce((total, expense) => total + parseFloat(expense.amount), 0);

  return (
    <div>
      <h2>Dashboard</h2>
      <p>Total Expenses: {userSettings.currency} {totalExpenses.toFixed(2)}</p>
    </div>
  );
};

export default Dashboard;
