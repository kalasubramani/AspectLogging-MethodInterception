package main.commeproject.repositories;

import org.springframework.stereotype.Component;
import main.commeproject.model.UserComment;

@Component
public class DBCommentRepository implements ICommentRepository{

  @Override
  public void storeComment(UserComment comment)
  {
    System.out.println("Storing Comment ----> " + comment.getText() + "  ***  Written by : " + comment.getAuthor());
  }
  
}
