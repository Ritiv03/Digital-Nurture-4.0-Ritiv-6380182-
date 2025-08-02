import React, { useState } from 'react';

const ComplaintRegister = () => {
    const [formData,setFormData]=useState({
        name:"",
        complain:"",
        numHolder:1
    });
    const handleSubmit=(e)=>{
        e.preventDefault();
        alert(`Thanks ${formData.name} Your complain ${formData.complain} was sucessfully submitted Your id is ${formData.numHolder}`);
        setFormData((prev)=>({...prev,numHolder:prev.numHolder+1}));
    }
  return (
    <div
      style={{
        width: '100%',
        height: '100vh',
        display: 'flex',
        justifyContent: 'center',
        backgroundColor: 'bisque',
      }}
    >
      <form 
        style={{ width: '80%', height: '80%' }}
        action=""
        onSubmit={handleSubmit}
      >
        <fieldset
          style={{
            height: '100%',
            border: '1px solid white',
            display: 'flex',
            flexDirection: 'column',
            justifyContent: 'center',
            alignItems: 'center',
            gap: '1rem',
          }}
        >
          <legend style={{ color: 'white' }}>Hello Form</legend>
          <input value={formData.name} onChange={(e)=>setFormData({...formData,name:e.target.value})} type="text" name='name' placeholder="Enter your name employee" />
          <textarea onChange={(e)=>setFormData({
            ...formData,complain:e.target.value
          })} name="complain" >{formData.complain}</textarea>
          <button type="submit">Submit</button>
        </fieldset>
      </form>
    </div>
  );
};

export default ComplaintRegister;
