package main.commeproject.services;

import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import main.commeproject.model.UserComment;

@Service
public class AspectCommentService {

  private Logger logger = Logger.getLogger(AspectCommentService.class.getName());

  public void publishCommentAspect(UserComment userComment)
  {
    logger.info("Publishing the comment logged --->>> " + userComment.getText() + " From *** " +userComment.getAuthor() );
  }
  
  @ToLog
  public void DeleteComment(UserComment comment)
  {
    logger.info("xxxxxxxxxxxxxxxxxxxx Deleting Comment :  "+comment.getText()+"  xxxxxxxxxxx");

  }

  public void EditingComment(UserComment comment)
  {
     logger.info("xxxxxxxxxxxxxxxxxxxx Editing Comment :  "+comment.getText()+"  xxxxxxxxxxx");

  }
}
