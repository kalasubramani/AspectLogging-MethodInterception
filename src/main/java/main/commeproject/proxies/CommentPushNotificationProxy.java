package main.commeproject.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import main.commeproject.model.UserComment;

@Component
@Qualifier("PUSH")
//@Primary
public class CommentPushNotificationProxy implements ICommentNotificationProxy{

@Override
public void sendComment(UserComment comm)
{
  System.out.println("Sending push notification for Comment : " + comm.getText());
}
  
}
