package com.assessment.rest.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


@SpringBootTest
@AutoConfigureMockMvc
class RestApiApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void getPrimes() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/primes/10")
								.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals (content, "{\"algorithmName\":\"Square Root\",\"initial\":10,\"primes\":[2,3,5,7]}");
	}
	
	@Test
	void selectAlgorithm() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/primes/10?algorithm=2")
								.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals (content, "{\"algorithmName\":\"Sieve of Erastosthene\",\"initial\":10,\"primes\":[2,3,5,7]}");
	}
	
	
	@Test
	void errorTest() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/primes/10O")
								.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
	}

}
