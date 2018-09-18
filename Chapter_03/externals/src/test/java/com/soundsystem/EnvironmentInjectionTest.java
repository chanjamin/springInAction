package com.soundsystem;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

public class EnvironmentInjectionTest {

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(classes=EnvironmentConfig.class)
  public static class InjectFromProperties {
  
    @Autowired
    private BlankDisc blankDisc;
    
    @Test
    public void assertBlankDiscProperties() {
      assertEquals("The Beatles", blankDisc.getArtist());
      assertEquals("Sgt. Peppers Lonely Hearts Club Band", blankDisc.getTitle());
    }
    
  }
  
  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(classes=EnvironmentConfigWithDefaults.class)
  public static class InjectFromPropertiesWithDefaultValues {
  
    @Autowired
    private BlankDisc blankDisc;
    
    @Test
    public void assertBlankDiscProperties() {
      assertEquals("U2", blankDisc.getArtist());
      assertEquals("Rattle and Hum", blankDisc.getTitle());
    }
    
  }
  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(classes=EnvironmentConfigWithGivenClass.class)
  public static class InjectFromPropertiesWithClass {

    @Autowired
    @Qualifier("123")
    private Integer i;

    @Autowired
    private BlankDisc blankDisc;

    @Test
    public void assertBlankDiscProperties() {
      assertEquals(i.longValue(),100l);
      assertNotNull(blankDisc);
    }

  }

  public static class InjectFromPropertiesWithRequiredProperties {
  
    @Test(expected=BeanCreationException.class)
    public void assertBlankDiscProperties() {
      new AnnotationConfigApplicationContext(EnvironmentConfigWithRequiredProperties.class);
    }
    
  }

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration("classpath:placeholder-config.xml")
  public static class InjectFromProperties_XMLConfig {
  
    @Autowired
    private BlankDisc blankDisc;
    @Autowired
    private Environment env;
    
    @Test
    public void assertBlankDiscProperties() {
      assertEquals("The Beatles", blankDisc.getArtist());
      assertEquals("Sgt. Peppers Lonely Hearts Club Band", blankDisc.getTitle());
      for (String s:
           env.getDefaultProfiles()) {
        System.out.println(s);
      }
    }
    
  }

}