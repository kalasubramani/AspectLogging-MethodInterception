package main.commeproject.proxies;
import org.springframework.stereotype.Component;
import main.commeproject.model.UserComment;

@Component
public class EmailCommentNotificationProxy implements ICommentNotificationProxy {
 
  @Override
  public void sendComment(UserComment comment)
  {
      System.out.println(" Sending comment notifications to Email Server ---> " + comment.getText() + " ## Written by :  " + comment.getAuthor());
  }
}
