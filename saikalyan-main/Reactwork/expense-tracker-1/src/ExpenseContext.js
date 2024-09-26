import React, { createContext, useState, useEffect } from 'react';

export const ExpenseContext = createContext();

export const ExpenseProvider = ({ children }) => {
  const [expenses, setExpenses] = useState([]);
  const [categories, setCategories] = useState(['Food', 'Transport', 'Entertainment']);
  const [userSettings, setUserSettings] = useState({
    theme: 'light',
    currency: 'USD',
  });

  useEffect(() => {
    const storedExpenses = JSON.parse(localStorage.getItem('expenses')) || [];
    const storedCategories = JSON.parse(localStorage.getItem('categories')) || ['Food', 'Transport', 'Entertainment'];
    const storedUserSettings = JSON.parse(localStorage.getItem('userSettings')) || { theme: 'light', currency: 'USD' };

    setExpenses(storedExpenses);
    setCategories(storedCategories);
    setUserSettings(storedUserSettings);
  }, []);

  useEffect(() => {
    localStorage.setItem('expenses', JSON.stringify(expenses));
  }, [expenses]);

  useEffect(() => {
    localStorage.setItem('categories', JSON.stringify(categories));
  }, [categories]);

  useEffect(() => {
    localStorage.setItem('userSettings', JSON.stringify(userSettings));
  }, [userSettings]);

  return (
    <ExpenseContext.Provider value={{ expenses, setExpenses, categories, setCategories, userSettings, setUserSettings }}>
      {children}
    </ExpenseContext.Provider>
  );
};


export default ExpenseContext;
