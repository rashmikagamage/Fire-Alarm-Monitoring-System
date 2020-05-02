	import React, { Component } from "react";
	import {
		MDBRow,
		MDBCol,
		MDBCard,
		MDBCardBody,
		MDBIcon,
		MDBBtn,
	} from "mdbreact";
	import Sensor from "./sensor";
	const axios = require("axios"); // use axios for connect to an API

	class Sensors extends Component {
		constructor(props) {
			super(props);
			this.state = {
				sensors: [], // initially keep an empty sensors array in the state
			};
		}

		/*
	use async await for handle asynchronous calls.
	For send api requests  use componentDidMount lifecyle method.
	componentDidMount() method is the perfect place, where  call the setState() method to
	change the state of sensors and render() the updated data loaded JSX.
	For example, we are going to fetch any data from an API then API call
	should be placed in this lifecycle method, and then we get the response,
	we can call the setState() method and render the element with updated data.
	*/

		async componentDidMount() {
			try {
				const resInitial = await axios.get("http://localhost:4000/getAllSensors");
				/*
			Initial get request calls to API and this method executes only once.
			Without this method first 40 seconds not any get request called to an API
		  */
				console.log("response initial", resInitial.data);

				this.setState(
					{
						sensors: resInitial.data, // Initially set the sensors array with response data
					},
					() => {
						console.log("this state initial ", this.state);
					}
				);

				setInterval(async () => {
					/* The setInterval() method calls a function or evaluates an expression at specified intervals (in milliseconds).
			  The JS setInterval() method will keep calling the specified function until clearInterval() method is called
			*/
					const response = await axios.get("http://localhost:4000/getAllSensors");
					// send a request to API for get all sensor details

					this.setState(
						{
							sensors: response.data, // set the sensors array with response data
						},
						() => {
							console.log("this state ", this.state);
						}
					);
				}, 40000); // pass 40000 milli secs (40 seconds) --> every 40 seconds send an API request
			} catch (e) {
				console.log(e); // log the errors
			}
		}

		render() {
			const { sensors } = this.state; // extract the sensors details

			console.log("sensors", sensors);

			// use a grid view for view the sensors

			return (
				<section className="text-center my-5">
					<h2 className="h1-responsive font-weight-bold text-center my-5">
						Sensor Information
					</h2>
					<img
						src="https://media.giphy.com/media/3ohs7UjgdqCnkEYcsE/giphy.gif"
						width="5%"
					></img>
					<br></br>
					<br></br>

					<MDBRow>
						{sensors.map((item) => {
							{
								/* traverse through the sensors array */
							}
							return (
								<Sensor item={item}>
									{/* pass each  arry item data to senor item component for using props */}
								</Sensor>
							);
						})}
					</MDBRow>
				</section>
			);
		}
	}

	export default Sensors;
