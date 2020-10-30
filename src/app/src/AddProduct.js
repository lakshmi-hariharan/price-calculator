import React from "react";


class AddProduct extends React.Component {
  constructor(props) {
    super(props);
    this.submitHandler = this.submitHandler.bind();
  }

  submitHandler = async (event) => {
    event.preventDefault();
    const data = new FormData(event.target);
    const rawResponse = await fetch("http://localhost:8080/product", {
      method: "POST",
      headers: {
        Accept: "application/json",
      },
      body: data,
    });
    const response = await rawResponse.json();
    if (response === true) {
      alert("Product saved successfully");
    }

    window.location.reload();
  };

  render() {
    return (
      <div className="container">
        <form onSubmit={this.submitHandler} className="form-horizontal">
          
          <div className="row justify-content-center">
            <label className="control-label col-sm-2" htmlFor="lineItemId">
              ItemID:
            </label>
            <div className="col-sm-4">
              <input name="itemID"></input>
            </div>
          </div>
          <div className="row justify-content-center">
            <label className="control-label col-sm-2" htmlFor="lineItemId">
              Name:
            </label>

            <div className="col-sm-4">
              <input name="itemName"></input>
            </div>
          </div>
          <div className="row justify-content-center">
            <label className="control-label col-sm-2" htmlFor="lineItemId">
              Cost:
            </label>

            <div className="col-sm-4">
              <input name="itemCost"></input>
            </div>
          </div>
          <div className="row justify-content-center" style={{color:"white"}}>
          <button className="btn bg-primary" variant="primary" >
            Add Product
          </button>
          </div>
         
        </form>
      </div>
    );
  }
}

export default AddProduct;
