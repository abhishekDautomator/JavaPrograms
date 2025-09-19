/*
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.your.package..*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method execution started: {}", joinPoint.getSignature());
    }

    @After("execution(* com.your.package..*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Method execution completed: {}", joinPoint.getSignature());
    }
}

*/
