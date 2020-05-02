import React, { Component } from "react";
import { MDBBtn, MDBCol, MDBContainer, MDBRow } from "mdbreact";
import "./index.css";
//import logo from "./logo.png";
import Sensors from "./components/sensors"; //import the sensors grid component

class App extends Component {
	render() {
		return <Sensors></Sensors>;
	}
}

export default App;
