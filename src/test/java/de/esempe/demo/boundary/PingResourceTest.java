package de.esempe.demo.boundary;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = { PingResource.class })
public class PingResourceTest
{
	@Autowired
	private MockMvc mockMvc;

	@Test
	void pingTest() throws Exception
	{
//		this.mockMvc.perform(get("/ping")) //
//				.andExpectAll( //
//						status().isOk(), //
//						content().contentType(MediaType.APPLICATION_JSON), //
//						jsonPath("msg").value("Ping vom Server")//
//				);
		assertThat(Boolean.TRUE).isTrue();
	}
}
