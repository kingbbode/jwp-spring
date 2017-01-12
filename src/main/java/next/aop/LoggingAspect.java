package next.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by YG-MAC on 2017. 1. 12..
 */
@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("within(next..*)")
    public void logging(JoinPoint point){
        log.debug("class : {}", point.toShortString());
        Object[] objects = point.getArgs();
        if(objects.length == 0){
            log.debug("arg null");
        }
        Arrays.stream(point.getArgs())
                .forEach(arg -> log.debug(arg + ""));
    }
}
