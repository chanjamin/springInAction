package com.soundsystem;


public class BlankDisc {
  @Override
  public String toString() {
    return "BlankDisc{" +
            "title='" + title + '\'' +
            ", artist='" + artist + '\'' +
            '}';
  }

  private final String title;
  private final String artist;

  public BlankDisc(String title, String artist) {
    this.title = title;
    this.artist = artist;
  }
  
  public String getTitle() {
    return title;
  }
  
  public String getArtist() {
    return artist;
  }
  
}
