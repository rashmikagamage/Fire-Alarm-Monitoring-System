import React from "react";
import {
	MDBRow,
	MDBCol,
	MDBCard,
	MDBCardBody,
	MDBIcon,
	MDBBtn,
} from "mdbreact";

const Sensor = (props) => {
	const { item } = props; // extract the props data

	console.log("item", item);

	/*
  this component is for get the sensor details and show them in a card view.
  use conditional rendering for the changing colors of sensors.
  */

	if ((item.smokeLevel > 5 || item.co2Level > 5) && item.active === true) {
		// check smokelevel or co2 level is above 5
		return (
			<MDBCol lg="4" md="12" className="mb-lg-0 mb-4">
				<MDBCard className="red">
					{" "}
					{/* set color to red */}
					<MDBCardBody className="white-text">
						<h5 className="mb-4">sensor id : {item.id}</h5>
						<div className="d-flex justify-content-center">
							<div className="card-circle d-flex justify-content-center align-items-center">
								<MDBIcon icon="users" className="light-blue-text" />
							</div>
						</div>
						<h2 className="font-weight-bold my-4">
							smoke level : {item.smokeLevel}
						</h2>
						<h2 className="font-weight-bold my-4">
							co2 level : {item.co2Level}
						</h2>
						<h5 className="font-weight-bold my-4">location</h5>
						<h5 className="mb-4">
							floor no : {item.floorNo} room no : {item.roomNo}
						</h5>
						{item.active ? (
							<h5 className="font-weight-bold my-4">status : active</h5>
						) : (
							<h5 className="font-weight-bold my-4">status : not active</h5>
						)}
					</MDBCardBody>
				</MDBCard>
				<br></br>
			</MDBCol>
		);
	} else if (!item.active) {
		// check sensor is active or not
		return (
			<MDBCol lg="4" md="12" className="mb-lg-0 mb-4">
				<MDBCard className="green">
					{" "}
					{/* set color to green */}
					<MDBCardBody className="white-text">
						<h5 className="mb-4">sensor id : {item.id}</h5>
						<div className="d-flex justify-content-center">
							<div className="card-circle d-flex justify-content-center align-items-center">
								<MDBIcon icon="users" className="light-blue-text" />
							</div>
						</div>
						<h2 className="font-weight-bold my-4">smoke level : 0</h2>
						<h2 className="font-weight-bold my-4">co2 level : 0</h2>
						<h5 className="font-weight-bold my-4">location</h5>
						<h5 className="mb-4">
							floor no : {item.floorNo} room no : {item.roomNo}
						</h5>
						{item.active ? (
							<h5 className="font-weight-bold my-4">status : active</h5>
						) : (
							<h5 className="font-weight-bold my-4">status : not active</h5>
						)}
					</MDBCardBody>
				</MDBCard>
				<br></br>
			</MDBCol>
		);
	} else {
		return (
			<MDBCol lg="4" md="12" className="mb-lg-0 mb-4">
				<MDBCard className="indigo">
					{" "}
					{/* set color to indigo if smoke level or co2 level less than 5 and active */}
					<MDBCardBody className="white-text">
						<h5 className="mb-4">sensor id : {item.id}</h5>
						<div className="d-flex justify-content-center">
							<div className="card-circle d-flex justify-content-center align-items-center">
								<MDBIcon icon="users" className="light-blue-text" />
							</div>
						</div>
						<h2 className="font-weight-bold my-4">
							smoke level : {item.smokeLevel}
						</h2>
						<h2 className="font-weight-bold my-4">
							co2 level : {item.co2Level}
						</h2>
						<h5 className="font-weight-bold my-4">location</h5>
						<h5 className="mb-4">
							floor no : {item.floorNo} room no : {item.roomNo}
						</h5>
						{item.active ? (
							<h5 className="font-weight-bold my-4">status : active</h5>
						) : (
							<h5 className="font-weight-bold my-4">status : not active</h5>
						)}
					</MDBCardBody>
				</MDBCard>
				<br></br>
			</MDBCol>
		);
	}
};

export default Sensor;
