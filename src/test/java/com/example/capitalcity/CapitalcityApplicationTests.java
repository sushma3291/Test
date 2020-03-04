package com.example.capitalcity;

import java.net.URISyntaxException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // for restTemplate
class CapitalcityApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void countryNameWithSingleResult() throws URISyntaxException, JSONException {
		String response = this.restTemplate.getForObject("/capital/lanka", String.class);

		JSONAssert.assertEquals("[\"Colombo\"]",response, false);
	}
	
	@Test
	void countryNameWithNoResult() throws URISyntaxException, JSONException {
		String response = this.restTemplate.getForObject("/capital/xyz", String.class);

		JSONAssert.assertEquals("[]",response, false);
	}
	
	@Test
	void countryNameWithMoreThanOneResult() throws URISyntaxException, JSONException {
		String response = this.restTemplate.getForObject("/capital/ind", String.class);

		JSONAssert.assertEquals("[\"New Delhi\",\"Diego Garcia\",\"Jakarta\"]",response, false);
	}
	
	@Test
	void countryCodeWithSingleResult() throws URISyntaxException, JSONException {
		String response = this.restTemplate.getForObject("/capital/AFG", String.class);

		JSONAssert.assertEquals("[\"Kabul\"]",response, false);
	}
	
	@Test
	void countryCodeWithNoResult() throws URISyntaxException, JSONException {
		String response = this.restTemplate.getForObject("/capital/XYZ", String.class);

		JSONAssert.assertEquals("[]",response, false);
	}
	
	@Test
	void countryCodeWithMoreThanOneResult() throws URISyntaxException, JSONException {
		String response = this.restTemplate.getForObject("/capital/AF", String.class);

		JSONAssert.assertEquals("[\"Bangui\",\"Pretoria\",\"Marigot\",\"Kabul\"]",response, false);
	}
}
