package com.habuma.restfun;

import org.springframework.beans.factory.annotation.Value;

public class BlankDisc {
    String title;
    String artist;

    public BlankDisc(@Value("#{systemProperties['title']}") String title,
                     @Value("#{systemProperties['aritst']}")String artist) {
        this.title = title;
        this.artist = artist;
    }
}
