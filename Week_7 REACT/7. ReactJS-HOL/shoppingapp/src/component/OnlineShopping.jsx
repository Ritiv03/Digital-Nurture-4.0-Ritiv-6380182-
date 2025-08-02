import React from "react";
import Cart from "./Cart";

class OnlineShopping extends React.Component {
  render() {
    const CartInfo = [
      { itemname: "Laptop", price: 65000 },
      { itemname: "Headphones", price: 2500 },
      { itemname: "Keyboard", price: 1500 },
      { itemname: "Mouse", price: 700 },
      { itemname: "Monitor", price: 12000 }
    ];

    const containerStyle = {
      padding: "20px",
      maxWidth: "600px",
      margin: "0 auto",
      backgroundColor: "#f9f9f9",
      borderRadius: "10px",
      boxShadow: "0 2px 8px rgba(0,0,0,0.1)",
      fontFamily: "Arial, sans-serif"
    };

    const headingStyle = {
      fontSize: "24px",
      fontWeight: "bold",
      color: "#333",
      paddingBottom: "10px",
      borderBottom: "2px solid #ddd"
    };

    return (
      <div style={containerStyle}>
        <h1 style={headingStyle}>Items Ordered:</h1>
        <Cart items={CartInfo} />
      </div>
    );
  }
}

export default OnlineShopping;
