import React, { useState } from 'react';

const Register = () => {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

  
    if (formData.name.trim().length < 5) {
      alert("Name should have at least 5 characters.");
      return;
    }

    if (!formData.email.includes('@') || !formData.email.includes('.')) {
      alert("Email should contain '@' and '.'");
      return;
    }

    if (formData.password.length < 8) {
      alert("Password should have at least 8 characters.");
      return;
    }

    alert(`Thanks ${formData.name}, you've registered successfully!`);
    console.log("Form submitted:", formData);
  };

  return (
    <div
      style={{
        width: '100%',
        height: '100vh',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'bisque',
      }}
    >
      <form 
        style={{ width: '50%', height: 'auto' }}
        onSubmit={handleSubmit}
      >
        <fieldset
          style={{
            padding: '2rem',
            border: '1px solid white',
            borderRadius: '10px',
            display: 'flex',
            flexDirection: 'column',
            justifyContent: 'center',
            alignItems: 'center',
            gap: '1rem',
          }}
        >
          <legend style={{ color: 'black', fontWeight: 'bold' }}>Hello Form</legend>
          <input type="text" name="name" onChange={handleChange} placeholder="Enter your name" />
          <input type="email" name="email" onChange={handleChange} placeholder="Enter your email" />
          <input type="password" name="password" onChange={handleChange} placeholder="Enter your password" />
          <button type="submit">Submit</button>
        </fieldset>
      </form>
    </div>
  );
};

export default Register;
