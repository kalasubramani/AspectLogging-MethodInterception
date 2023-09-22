package main.commeproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import main.commeproject.config.ProjectConfig;
import main.commeproject.model.UserComment;
import main.commeproject.proxies.CommentPushNotificationProxy;
import main.commeproject.proxies.CommentPushNotificationProxy;
import main.commeproject.services.AspectCommentService;
import main.commeproject.services.CommentService;
import java.util.logging.Logger;


public class Main {
  
  private static Logger logger = Logger.getLogger(Main.class.getName());

  public static void main(String[] r)
  {

    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    UserComment comment = new UserComment();

    comment.setAuthor("Puli Kutty");
    comment.setText("I am waiting to love you Ammi !!");
    logger.info("From Main -- ORIGINAL comment text sent for Publishing  ---- " + comment.getAuthor() + " :: " + comment.getText());
    
    // System.out.println("In Main - before getBean() " );
    // var commService =context.getBean(CommentService.class);
    //  System.out.println("In Main - AFTER getBean() " );

     var proxy = context.getBean("commPushNotifProxy" ,CommentPushNotificationProxy.class);
     var proxyNext   = context.getBean("commPushNotifProxy",CommentPushNotificationProxy.class);
     boolean b  = proxy==proxyNext;
     System.out.println("Bean comparison result --> " + b);

     //Aspects
     var aspectService = context.getBean(AspectCommentService.class);

    //  comment.setAuthor("Meenu");
    //  comment.setText("Ammi....I cooked the poriyal. It's ready ..........!!");

    // aspectService.publishCommentAspect(comment);
     logger.info("^^^^^^^^^^^^^^^^From Main. About to execute DelteComment method ####  "  );
     aspectService.DeleteComment(comment);
    logger.info("##############3 From Main. Excuted Delete Comment method ####  "  );

  //  var commService1 =context.getBean(CommentService.class);

  //  boolean b = commService==commService1;

  //  System.out.println("Bean comparison result --> " + b);

  //   commService.publishComment(comment);
    
  //   DBCommentRepository commRepository = new DBCommentRepository();
  //   EmailCommentNotificationProxy commNotificationProxy = new EmailCommentNotificationProxy();
  //   CommentService commService = new CommentService(commRepository,commNotificationProxy);

  //   UserComment comment = new UserComment();
  //   comment.setAuthor("Dyni");
  //   comment.setText("Got to study more Karadi !!");

  //   commService.publishComment(comment);
   }
}
