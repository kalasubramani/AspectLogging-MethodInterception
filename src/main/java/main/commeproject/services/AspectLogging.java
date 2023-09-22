package main.commeproject.services;

import java.util.Arrays;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import main.commeproject.model.UserComment;

@Aspect
public class AspectLogging {
  
  private Logger logger= Logger.getLogger(AspectLogging.class.getName());

  //@Around("execution(* main.commeproject.services.*.*(..))")
  @Around("@annotation(ToLog)")
  public Object log(ProceedingJoinPoint joinPoint) throws Throwable{

    //to get the method name and params of the intercepted methods
    String methodName = joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();

    logger.info(" ** About to execute Aspected method ** " + methodName + "  ** HAving Method Params :  " + Arrays.asList(args));
    
    //params altered in aspect
    UserComment comm = new UserComment();
    
    comm.setAuthor("^^^^^^^^^Author : Aspect ^^^^^^^^");
    comm.setText ("ASPECT REPLACED COMMENT ^^^^^^^Comment text from Aspect^^^^^^^"); 
    Object[] newArgs ={comm};

    Object returnValue =  joinPoint.proceed(newArgs);
     logger.info(" //// Completed executing Aspected method //// This is the value returned :   " + returnValue);
  
    return returnValue;
    }
}
