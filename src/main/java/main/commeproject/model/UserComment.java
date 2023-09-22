package main.commeproject.model;

public class UserComment {
  private String author;
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }
  private String text;
}
