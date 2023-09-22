package main.commeproject.config;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import main.commeproject.proxies.CommentPushNotificationProxy;
import main.commeproject.services.AspectLogging;


@Configuration
@ComponentScan (basePackages = {"main.commeproject.proxies","main.commeproject.repositories","main.commeproject.services"})
@EnableAspectJAutoProxy
public class ProjectConfig {

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)   
 public CommentPushNotificationProxy commPushNotifProxy()
  {
    return new CommentPushNotificationProxy();
  }
  
  @Bean
 public AspectLogging aspect()
  {
    return new AspectLogging();
  }
}
