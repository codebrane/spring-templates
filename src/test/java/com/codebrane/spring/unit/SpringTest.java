package com.codebrane.spring.unit;

import org.springframework.mock.web.MockServletContext;
import org.junit.BeforeClass;

public abstract class SpringTest {
  protected static MockServletContext servletContext = null;
	protected static String[] springConfigFiles = null;

  @BeforeClass
  public static void initSpringTest() {
    servletContext = new MockServletContext(Paths.path("servlet.context.home"));
	  springConfigFiles = new String[] {Paths.path("applicationContext.xml")};
  }
}
