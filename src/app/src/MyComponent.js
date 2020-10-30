import React from 'react';

import Product from './Product';
import AddProduct from './AddProduct';

class MyComponent extends React.Component {
  
    state = {
        products: [],
        currencies: []
      }

  componentDidMount() {
    let apiUrl = 'http://localhost:8080/product';
    fetch(apiUrl)
      .then((response) => response.json())
      .then((data) => this.setState({products: data})).catch(console.log);
    apiUrl = 'http://localhost:8080/currency';
    fetch(apiUrl)
      .then((response) => response.json())
      .then((data) => this.setState({currencies: data})).catch(console.log);
      
  }
  render() {
    return (
    
        <div className="App">
           
        <header className="App-header">
        <h2>Product amount calculator</h2>

        <Product products={this.state.products} currencies={this.state.currencies}/>
        <hr/>
        <hr/>
        <hr/>

        <h2>Add a new product</h2>
        <AddProduct></AddProduct>
  
      
  
        </header>
        
        
      </div>
    )

  }
}
export default MyComponent;