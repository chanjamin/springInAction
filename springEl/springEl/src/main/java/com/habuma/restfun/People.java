package com.habuma.restfun;

public class People {
    public int age;
    public sex gender;

    public People(int age, sex gender) {
        this.age = age;
        this.gender = gender;
    }

    public enum sex{
        male,
        female
    }
}
