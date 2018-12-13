package com.qa.data;

//pojo - plain old java object
public class Users {

	String broker;
	String deviceFamily;
	String name;
	String serialNumber;
	String type;
	String deviceID;
	String message;
	String user;

	public Users() {

	}

	public Users(String broker, String deviceFamily, String name, String serialNumber, String type) {
		this.broker = broker;
		this.deviceFamily = deviceFamily;
		this.name = name;
		this.serialNumber = serialNumber;
		this.type = type;
	}

	public Users(String message ) {
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	// getters and setters methods:
	public String getBroker() {
		return broker;
	}

	public void setBroker(String broker) {
		this.broker = broker;
	}

	public String getDeviceFamily() {
		return deviceFamily;
	}

	public void setDeviceFamily(String deviceFamily) {
		this.deviceFamily = deviceFamily;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
