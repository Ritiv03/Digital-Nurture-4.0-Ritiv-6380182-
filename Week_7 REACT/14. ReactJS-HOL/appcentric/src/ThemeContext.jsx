import React, { createContext, useState } from 'react'

export const ThemeProvider=createContext();
 
const ThemeContext = ({children}) => {
     const [theme, setTheme] = useState('light');
  const obj={
    theme,
    setTheme
  }
  return (
    <ThemeProvider.Provider value={obj}>
        {children}
    </ThemeProvider.Provider>
  )
}

export default ThemeContext