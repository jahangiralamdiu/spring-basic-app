package jh.springbasicapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by Jahangir on 23/02/2015.
 */
@Component
@Aspect
public class TracingAspect {

    boolean enteringCalled = false;

    Logger logger = LoggerFactory.getLogger(TracingAspect.class);

    public boolean isEnteringCalled()
    {
        return enteringCalled;
    }

    @Before("execution(* register(..))")
    public void entering(JoinPoint jointPoint)
    {
        enteringCalled = true;
        logger.trace("Entering "+jointPoint.getStaticPart().getSignature().toString());

    }


}
