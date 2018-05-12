package no.boerta.intervju.lanSoknad;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class SoknadIT {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testSoknad() throws Exception {
		String content=
				"{\n" +
				"  \"lanetakere\": [{ \"fnr\" : \"01056000069\", \"navn\" : \"Kari Nordmann\" } , { \"fnr\" : \"01056000301\", \"navn\" : \"Ola Nordmann\" }],\n" +
				"  \"lanebelop\": 2450000,\n" +
				"  \"behov\": \"Vi skal låne penger til........\"\n" +
				"}";
		MvcResult result = mockMvc.perform(post("/lan/soknad")
					.contentType(MediaType.APPLICATION_JSON)
					.content(content)
				.accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andReturn();

		String soknadsnummer = result.getResponse().getContentAsString();

		mockMvc.perform(get("/lan/status")
				.contentType(MediaType.TEXT_PLAIN)
				.content(soknadsnummer)
				.accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("Mottatt søknad"));
	}

	@Test
	public void testStatus() throws Exception {
		String UUID = "1243";

		mockMvc.perform(get("/lan/status")
				.param("soknadsnummer", "1234")
				.contentType(MediaType.TEXT_PLAIN)
				.accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("Ukjent"));
	}
}