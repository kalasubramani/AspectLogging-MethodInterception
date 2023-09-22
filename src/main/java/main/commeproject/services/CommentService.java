package main.commeproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import main.commeproject.model.UserComment;
import main.commeproject.proxies.ICommentNotificationProxy;
import main.commeproject.repositories.ICommentRepository;

@Component
@Lazy
public class CommentService {

  private ICommentRepository iCommentRepository;
 
  private ICommentNotificationProxy icommentNotificationProxy;

  
  public CommentService(
                        ICommentRepository commRepository, 
                       @Qualifier("PUSH") ICommentNotificationProxy commNotificationProxy)
                        {
                            this.iCommentRepository = commRepository;
                            this.icommentNotificationProxy =commNotificationProxy;
                        
                            System.out.println("Inside constructor -- > CommentService instance created!");
                          }
        
 
public void publishComment(UserComment comment)
{
  iCommentRepository.storeComment(comment);
  icommentNotificationProxy.sendComment(comment);
}

}
