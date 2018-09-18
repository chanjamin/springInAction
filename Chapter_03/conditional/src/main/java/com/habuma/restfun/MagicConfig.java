package com.habuma.restfun;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class MagicConfig {

  @Bean
  @Conditional(MagicExistsCondition.class)
  public MagicBean magicBean() {
    return new MagicBean();
  }

  @Bean
  @Primary
  public MagicBean magicBean2(){
    return new MagicBean();
  }
}