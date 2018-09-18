package com.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:com/soundsystem/app.properties")
public class EnvironmentConfigWithGivenClass {

  @Autowired
  Environment env;
  


  @Bean(name = "123")
  public Integer getCount(){
    return env.getProperty("db.count",Integer.class,30);
  }

  @Bean
  public BlankDisc getB(){
    return new BlankDisc("title","artist");
  }
  
}
