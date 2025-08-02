import logo from './logo.svg';
import './App.css';
import { EmployeesData } from './Employee';
import EmployeesList from './EmployeesList';
import { useContext, useState } from 'react';
import { ThemeProvider } from './ThemeContext';
function App() {
  const Employees = EmployeesData;
  const {setTheme}=useContext(ThemeProvider);
  return (
    <>
      <div>
        <label>SELECT A THEME </label>
        <select onChange={(e) => setTheme(e.target.value)}>
          <option value='light'>Light</option>
          <option value='dark'>Dark</option>
        </select>

      </div>
      <EmployeesList employees={Employees} />
    </>
  );
}

export default App;


