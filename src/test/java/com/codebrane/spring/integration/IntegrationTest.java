package com.codebrane.spring.integration;

import org.junit.Test;
import static org.junit.Assert.*;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;

public class IntegrationTest {
	@Test
	public void pageTitles() {
		try {
			WebClient webClient = new WebClient();
			HtmlPage page = (HtmlPage)webClient.getPage("http://localhost:8080/spring-template");
			assertEquals("Spring Template : Testing : root", page.getTitleText());
			page = (HtmlPage)webClient.getPage("http://localhost:8080/spring-template/modeltest?firstAttributeValue=123&secondAttributeValue=abc");
			assertEquals("Spring Template : Testing : modeltest", page.getTitleText());
		}
		catch(IOException ioe) {
			fail(ioe.getMessage());
		}
	}
}