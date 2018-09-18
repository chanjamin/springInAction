package com.habuma.restfun;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

//@RunWith(SpringJUnit4ClassRunner.class)
//@Configuration
//@ContextConfiguration(classes = MagicExistsTest.class)
//@PropertySource(value = "classpath:app.properties")
public class MagicExistsTest {

    @Bean(name = "people")
    public People getI() {
        return new People(15, People.sex.male);
    }

    @Bean
    public People people2(@Value("#{systemProperties['age']}") int age
            , @Value("#{systemProperties['gender']}") People.sex Sex) {
        return new People(age, Sex);
    }

    @Value("  #{T(System).currentTimeMillis()}")
    private long sysTime;

    @Value("#{1234}")
    private Integer I;

    @Value("#{people.age}")
    private int age;

    @Value("#{people2.gender}")
    public People.sex Sex;

    @Value("#{systemProperties[test]}")
    private String test;

//  @Value("#{systemProperties.log4j.defaultInitOverride}")
//  private boolean loaded;

    //  @Value("#{systemEnvironment.user.home}")
//  private String home;
//
    @Value("#{123.12/34}")
    private int cal;

    @Test
    public void test() {
        System.out.println(sysTime);
        System.out.println(I.intValue());
        System.out.println(age);
        System.out.println(Sex);
        System.out.println(test);
//    System.out.println(loaded);
//    System.out.println(home);
        System.out.println(cal);
        Class<People.sex> declaringClass = People.sex.female.getDeclaringClass();
        People.sex sex = People.sex.valueOf("male");
        int ordinal = People.sex.male.ordinal();

    }

    @Test
    public void test8() {
        System.out.println((Stream.generate(()->"echo").count()));
        Stream<String> stream = Stream.of("a b vc");
        stream.filter(w->w!=null);
        Stream<Boolean> booleanStream = stream.map(s -> s.matches(""));
        stream.map(String::toUpperCase);
        //方法引用理解:1,lambda是动作传入方法,s->sout(s).2,把参数省略,写成class:method;
        " a".toUpperCase();
        String s = new String("1234");
//        s::toUpperCase;
        Arrays.asList("a","b","c").forEach(System.out::println);

        
    }
}
