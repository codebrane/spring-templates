package com.codebrane.spring.unit;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.context.support.XmlWebApplicationContext;
import com.codebrane.spring.beans.DummyBean;

public class BeanTest extends SpringTest {
	@Test
	public void test() {
		XmlWebApplicationContext ctx = new XmlWebApplicationContext();
    ctx.setConfigLocations(springConfigFiles);
    ctx.setServletContext(servletContext);
    ctx.refresh();
		DummyBean dummyBean = (DummyBean)ctx.getBean("dummyBean");
		assertNotNull(dummyBean);
		assertEquals("This is a test injected property", dummyBean.getDummyInjectedProperty());
		assertEquals("This is a test injected property test!", dummyBean.getDummyInternalProperty());
		dummyBean.setDummyInjectedProperty("Changed");
		dummyBean.init();
		assertEquals("Changed", dummyBean.getDummyInjectedProperty());
		assertEquals("Changed test!", dummyBean.getDummyInternalProperty());
	}
}