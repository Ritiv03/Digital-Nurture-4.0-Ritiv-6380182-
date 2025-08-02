import React from "react";

class Cart extends React.Component {
  render() {
    const tableStyle = {
      width: "100%",
      borderCollapse: "collapse",
      marginTop: "15px"
    };

    const thStyle = {
      border: "1px solid #ccc",
      padding: "10px",
      backgroundColor: "#eaeaea",
      textAlign: "left"
    };

    const tdStyle = {
      border: "1px solid #ccc",
      padding: "10px",
      textAlign: "left"
    };

    return (
      <table style={tableStyle}>
        <thead>
          <tr>
            <th style={thStyle}>Item Name</th>
            <th style={thStyle}>Price (₹)</th>
          </tr>
        </thead>
        <tbody>
          {this.props.items.map((item, index) => (
            <tr key={index}>
              <td style={tdStyle}>{item.itemname}</td>
              <td style={tdStyle}>{item.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    );
  }
}

export default Cart;
