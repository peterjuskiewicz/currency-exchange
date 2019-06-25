package com.juskiewicz.currencyexchange;

import com.juskiewicz.currencyexchange.model.Exchange;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyExchangeApplicationTests {

	@Test
	public void testExchangePositive() {
		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/exchange/gbp-to-usd/";

		ResponseEntity<Exchange> exchange = restTemplate.getForEntity(url + "1", Exchange.class);


		assertEquals(exchange.getStatusCode(), HttpStatus.OK);
		assertEquals(exchange.getBody().getUsd(), exchange.getBody().getExchangeRate(), 0.001);


	}

	@Test
	public void testExchangePositiveDecimal() {

		double value = 12.34;

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/exchange/gbp-to-usd/";

		ResponseEntity<Exchange> exchange = restTemplate.getForEntity(url + value, Exchange.class);


		assertEquals(exchange.getStatusCode(), HttpStatus.OK);
		assertEquals(exchange.getBody().getUsd(), exchange.getBody().getExchangeRate() * value, 0.001);


	}



	@Test
	public void testExchangeEmpty() {
		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/exchange/gbp-to-usd/";

		try {

			ResponseEntity<Object> exchange = restTemplate.getForEntity(url, Object.class);
			fail();

		} catch (HttpClientErrorException e) {

			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());

		}
	}

	@Test
	public void testExchangeNegative() {
		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/exchange/gbp-to-usd/";

		try {

			ResponseEntity<Object> exchange = restTemplate.getForEntity(url + "-1", Object.class);
			fail();

		} catch (HttpClientErrorException e) {

			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());

		}

	}

	@Test
	public void testExchangeInvalidInput() {
		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/exchange/gbp-to-usd/";

		try {

			ResponseEntity<Object> exchange = restTemplate.getForEntity(url + "a", Object.class);
			fail();

		} catch (HttpClientErrorException e) {

			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());

		}

	}

}
