package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

public class DevicesTest extends TestBase {
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closebaleHttpResponse;
	String deviceID;
	Object commentID;

	@Test(priority = 10)
	public void CreateNewDevices() throws JsonGenerationException, JsonMappingException, IOException {
		restClient = new RestClient();
		testBase = new TestBase();
		url = prop.getProperty("URL") + prop.getProperty("serviceURL");
		Users users = new Users("3", "2736", "Device_10", "657473920192837", "lora-gateway");

		// jackson API:
		ObjectMapper mapper = new ObjectMapper();

		// java object to json in String:
		String usersJsonString = mapper.writeValueAsString(users);
		// System.out.println(usersJsonString);

		closebaleHttpResponse = restClient.post(url, usersJsonString, headersConfiguration());

		// validate response from API:
		// 1. status code:
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_200);

		// 2. JsonString:
		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");

		JSONObject responseJson = new JSONObject(responseString);
		deviceID = (String) responseJson.get("deviceId");

		assert users.getName().equalsIgnoreCase(responseJson.getString("name"));
	}

	@Test(priority = 20)
	public void getCreateddevice() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		testBase = new TestBase();
		url = prop.getProperty("URL") + prop.getProperty("getDeviceURL") + deviceID;

		closebaleHttpResponse = restClient.get(url, headersConfiguration());

		// a. Status Code:
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		assert statusCode == RESPONSE_STATUS_CODE_200;

		// b. Json String:
		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		String getDeviceId = (String) responseJson.get("deviceId");
		assert getDeviceId.equals(deviceID);
	}

	@Test(priority = 30)
	public void updateCreatedDevice() throws JsonGenerationException, JsonMappingException, IOException {
		restClient = new RestClient();
		testBase = new TestBase();
		url = prop.getProperty("URL") + prop.getProperty("getDeviceURL") + deviceID;

		ObjectMapper mapper = new ObjectMapper();
		Users users = new Users("31", "2736", "Device_10", "657473920192877", "lora-gateway");

		String usersJsonString = mapper.writeValueAsString(users);
		// System.out.println("user json String -" + usersJsonString);

		closebaleHttpResponse = restClient.put(url, usersJsonString, headersConfiguration());
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_200);

		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");

		JSONObject responseJson = new JSONObject(responseString);
		assert users.getSerialNumber().equalsIgnoreCase(responseJson.getString("serialNumber"));
	}

	@Test(priority = 40, enabled = false)
	public void deleteCreatedDevice() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		testBase = new TestBase();
		url = prop.getProperty("URL") + prop.getProperty("getDeviceURL") + deviceID;

		closebaleHttpResponse = restClient.delete(url, headersConfiguration());

		// a. Status Code:
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		assert statusCode == RESPONSE_STATUS_CODE_204;
	}

	@Test(priority = 50, enabled = false)
	public void getallDevices() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		testBase = new TestBase();
		url = prop.getProperty("URL") + prop.getProperty("getDeviceURL");

		closebaleHttpResponse = restClient.get(url, headersConfiguration());

		// a. Status Code:
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		assert statusCode == RESPONSE_STATUS_CODE_200;

		Object totalDevices = 66;
		// b. Json String:
		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString);

		assert responseJson.get("total").equals(totalDevices);
	}

	@Test(priority = 11)
	public void createCommentForDevice() throws JsonGenerationException, JsonMappingException, IOException {

		restClient = new RestClient();
		testBase = new TestBase();
		url = prop.getProperty("URL") + prop.getProperty("getDeviceURL") + deviceID + prop.getProperty("getCommentURL");

		// jackson API:
		ObjectMapper mapper = new ObjectMapper();
		Users users1 = new Users("Testing");

		// java object to json in String:
		String usersJsonString = mapper.writeValueAsString(users1);
		System.out.println(usersJsonString);
		closebaleHttpResponse = restClient.post(url, usersJsonString, headersConfiguration());

		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_200);

		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");

		JSONObject responseJson = new JSONObject(responseString);
		assert users1.getMessage().equalsIgnoreCase(responseJson.getString("message"));
		commentID = responseJson.get("commentId");
	}

	@Test(priority = 12)
	public void updateCommentForDevice() throws JsonGenerationException, JsonMappingException, IOException {
		restClient = new RestClient();
		testBase = new TestBase();
		url = prop.getProperty("URL") + prop.getProperty("getDeviceURL") + deviceID + prop.getProperty("getCommentURL")
				+ commentID;

		ObjectMapper mapper = new ObjectMapper();
		Users users = new Users("Testing purpose");

		// java object to json in String:
		String usersJsonString = mapper.writeValueAsString(users);
		System.out.println(usersJsonString);
		closebaleHttpResponse = restClient.put(url, usersJsonString, headersConfiguration());
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_200);

		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		assert users.getMessage().equalsIgnoreCase(responseJson.getString("message"));
	}

}
