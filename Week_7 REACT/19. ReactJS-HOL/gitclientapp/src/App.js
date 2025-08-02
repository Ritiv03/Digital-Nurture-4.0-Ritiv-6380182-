import React, { useEffect, useState } from 'react'
import GitClient from './GitClient';

const App = () => {
  const [repository,setRepository]=useState([]);
  

  useEffect(()=>{
    GitClient.getRepository("Papun1111").then(r=>setRepository(r.data));

  },[])
  return (
    <div>
<h1>Git repo of Papun1111</h1>
{
  repository.map((data,key)=>{
    return (
      <div key={key}>
       <p> {data.name}</p>
      </div>
    )
  })
}
    </div>
  )
}

export default App