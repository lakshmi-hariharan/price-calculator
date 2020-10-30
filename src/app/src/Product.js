import { Button } from "react-bootstrap";
import React from "react";


class Product extends React.Component {
  constructor(props) {
    super(props);
    this.state = { username: "" };
    this.submitHandler = this.submitHandler.bind(this);
    this.handleSelect = this.handleSelect.bind(this);
    if (props && props.products && props.products[0]) {
      this.state.product = props.products[0].itemID;
    }
    if (props && props.currencies && props.currencies[0]) {
      this.state.currency = props.currencies[0].currencyAlpha;
    }
  }

  submitHandler = async (event) => {
    event.preventDefault();
    console.log(this.state.currency, this.state.product);

    const rawResponse = await fetch("http://localhost:8080/calculateAmount", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        itemID: parseInt(this.menu.value, 10),
        currencyAlpha: this.currency.value,
      }),
    });
    console.log(rawResponse);
    const content = await rawResponse.json();
    console.log(content);
    this.setState({ productValue: content });
    //this.state.productValue = content;
  };

  handleSelect = (event) => {
    this.setState({ product: event.target.value });
  };
  handleCurrencySelect = (event) => {
    this.setState({ currency: event.target.value });
  };
  render() {
    return (
      <div className="container">
        <form onSubmit={this.submitHandler.bind(this)} className="form-horizontal">
          <div className="row justify-content-center">
            <label className="control-label col-sm-2" htmlFor="product">
              Product:
            </label>
            <div className="col-sm-4">
              <select className="form-control"
                name="product"
                onChange={this.handleSelect}
                ref={(input) => (this.menu = input)}
              >
                {this.props.products.map((product) => (
                  <option value={product.itemID} key={product.itemID}>
                    {product.itemName}
                  </option>
                ))}
              </select>
            </div>
          </div>
          <div className="row justify-content-center">
            <label className="control-label col-sm-2" htmlFor="currency">
              Currency:
            </label>
            <div className="col-sm-4">
              <select className="form-control"
                name="currency"
                onChange={this.handleCurrencySelect}
                ref={(input) => (this.currency = input)}
              >
                {this.props.currencies.map((currency) => (
                  <option
                    value={currency.currencyAlpha}
                    key={currency.currencyAlpha}
                  >
                    {currency.currencyAlpha}
                  </option>
                ))}
              </select>
            </div>
          </div>
          <div className="row justify-content-center">
          <Button className="btn bg-primary" variant="primary" type="button" onClick={this.submitHandler}>
            Calculate
          </Button>
          </div>
          <div className="row justify-content-center">
            <h3>Amount is : {this.state.productValue}</h3>
          </div>
        </form>
      </div>
    );
  }
}

export default Product;
