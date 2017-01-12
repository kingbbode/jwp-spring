package next.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by YG-MAC on 2017. 1. 12..
 */
@Aspect
@Component
public class PerformanceAspect {

    private static final Logger log = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("within(next..*)")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable {
        StopWatch watch = new StopWatch();
        watch.start();
        Object returnValue = point.proceed();
        watch.stop();
        log.debug("class : {}, execution time : {}", point.toShortString(),watch.getTotalTimeMillis());
        return returnValue;
    }
}
