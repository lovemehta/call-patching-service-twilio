package com.nutripal.cps.config;


import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
@PropertySource("classpath:application-${environment}.properties")
public class Config {

  Map<String, String> map = new HashMap<String, String>();

  public String get(String key) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(Config.class);
    ConfigurableEnvironment env = context.getEnvironment();
    if (!map.containsKey(key) || map.get(key) == null) {
      map.put(key, env.getProperty(key));
    }
    String propertyValue = map.get(key);
    context.close();
    return propertyValue;
  }
}

/*
 * mvn clean package -DargLine="-Dproperty.environment=dev"
 */
