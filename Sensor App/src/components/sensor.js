import React, { Component } from "react";
const axios = require("axios");

export class sensor extends Component {
	// method use to update levels in the 1st sensor
	async updateSensor1() {
		try {
			const smokeLevel = Math.floor(Math.random() * 10) + 1; // get a random value for smokelevel
			const co2Level = Math.floor(Math.random() * 10) + 1; // get a random value for co2Level
			const reqBody = { smokeLevel, co2Level }; // create object and store levels
			const id = 11; // id of the sensor
			console.log("body sensor 1", reqBody);

			const response = await axios // axios POST request for update the sensor 01
				.request({
					method: "POST",
					url: `http://localhost:4000/updateSensorOnlyLevels/${id}`,
					headers: {
						"Content-Type": "application/json;charset=UTF-8",
						"Access-Control-Allow-Origin": "*",
					},
					data: JSON.stringify(reqBody), //  converts JavaScript objects into strings. When sending data to a web server the data has to be a string.
				});

			const resData = await response;

			console.log("responsee sensor 1", resData); // log the response
		} catch (e) {
			console.log(e);
		}
	}

	// method use to update levels in the 2nd sensor
	async updateSensor2() {
		try {
			const smokeLevel = Math.floor(Math.random() * 10) + 1; // get a random value for smokelevel
			const co2Level = Math.floor(Math.random() * 10) + 1; // get a random value for co2Level
			const reqBody = { smokeLevel, co2Level }; // create object and store levels
			const id = 12; // id of the sensor
			console.log("body sensor 2", reqBody);

			const response = await axios // axios POST request for update the sensor 01
				.request({
					method: "POST",
					url: `http://localhost:4000/updateSensorOnlyLevels/${id}`,
					headers: {
						"Content-Type": "application/json;charset=UTF-8",
						"Access-Control-Allow-Origin": "*",
					},
					data: JSON.stringify(reqBody), //  converts JavaScript objects into strings. When sending data to a web server the data has to be a string.
				});

			const resData = await response;

			console.log("responsee sensor 2", resData);
		} catch (e) {
			console.log(e);
		}
	}

	async updateSensor3() {
		try {
			const smokeLevel = Math.floor(Math.random() * 10) + 1; // get a random value for smokelevel
			const co2Level = Math.floor(Math.random() * 10) + 1; // get a random value for co2Level
			const reqBody = { smokeLevel, co2Level }; // create object and store levels
			const id = 21; // id of the sensor
			console.log("body sensor 3", reqBody);

			const response = await axios // axios POST request for update the sensor 01
				.request({
					method: "POST",
					url: `http://localhost:4000/updateSensorOnlyLevels/${id}`,
					headers: {
						"Content-Type": "application/json;charset=UTF-8",
						"Access-Control-Allow-Origin": "*",
					},
					data: JSON.stringify(reqBody), //  converts JavaScript objects into strings. When sending data to a web server the data has to be a string.
				});

			const resData = await response;

			console.log("responsee sensor 3", resData);
		} catch (e) {
			console.log(e);
		}
	}

	async updateSensor4() {
		try {
			const smokeLevel = Math.floor(Math.random() * 5) + 1; // get a random value for smokelevel
			const co2Level = Math.floor(Math.random() * 5) + 1; // get a random value for co2Level
			const reqBody = { smokeLevel, co2Level }; // create object and store levels
			const id = 22; // id of the sensor
			console.log("body sensor 4", reqBody);

			const response = await axios // axios POST request for update the sensor 01
				.request({
					method: "POST",
					url: `http://localhost:4000/updateSensorOnlyLevels/${id}`,
					headers: {
						"Content-Type": "application/json;charset=UTF-8",
						"Access-Control-Allow-Origin": "*",
					},
					data: JSON.stringify(reqBody), //  converts JavaScript objects into strings. When sending data to a web server the data has to be a string.
				});

			const resData = await response;

		} catch (e) {
			console.log(e);
		}
	}

	async updateSensor5() {
		try {
			const smokeLevel = Math.floor(Math.random() * 10) + 1; // get a random value for smokelevel
			const co2Level = Math.floor(Math.random() * 10) + 1; // get a random value for co2Level
			const reqBody = { smokeLevel, co2Level }; // create object and store levels
			const id = 31; // id of the sensor
			console.log("body sensor 5", reqBody);

			const response = await axios // axios POST request for update the sensor 01
				.request({
					method: "POST",
					url: `http://localhost:4000/updateSensorOnlyLevels/${id}`,
					headers: {
						"Content-Type": "application/json;charset=UTF-8",
						"Access-Control-Allow-Origin": "*",
					},
					data: JSON.stringify(reqBody), //  converts JavaScript objects into strings. When sending data to a web server the data has to be a string.
				});

			const resData = await response;

			console.log("responsee sensor 5", resData);
		} catch (e) {
			console.log(e);
		}
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
			/*
        Initial update request calls to API and this methods executes only once.
        Without this method first 10 seconds not any get request called to an API
      */
			this.updateSensor1();
			this.updateSensor2();
			this.updateSensor3();
			this.updateSensor4();
			this.updateSensor5();

			setInterval(async () => {
				/* The setInterval() method calls a function or evaluates an expression at specified intervals (in milliseconds).
          The JS setInterval() method will keep calling the specified function until clearInterval() method is called
        */

				this.updateSensor1(); // call the update methods and this will send update requests to API
				this.updateSensor2();
				this.updateSensor3();
				this.updateSensor4();
				this.updateSensor5();
			}, 10000); // pass 10000 mili secs (10 seconds) --> every 10 seconds send an API requests
		} catch (e) {
			console.log(e); // log errors
		}
	}

	render() {
		return (
			<div>
				<h1>Sensor Working</h1>
			</div>
		);
	}
}

export default sensor;


