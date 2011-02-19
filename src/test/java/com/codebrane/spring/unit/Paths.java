package com.codebrane.spring.unit;

import java.util.HashMap;
import java.io.File;

/**
 * Conveneience class for working out test file paths
 */
public class Paths {
  private static HashMap<String, String> paths = null;

  static {
		String root = new File(".").getAbsolutePath() + "/src/main/webapp/WEB-INF/config/spring";
    paths = new HashMap<String, String>();
    paths.put("servlet.context.home", "file:///" + root);
    paths.put("applicationContext.xml", "file:///" + root + "/applicationContext.xml");
  }

  public static String path(String fileName) {
    return paths.get(fileName);
  }
}
