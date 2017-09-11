package klook.xin.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by mogo on 2017/9/11 0011.
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* klook.xin.controller..*.*(..))")
    public void logPointcut(){}

    @Before("logPointcut()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("[开始时间] : " + (System.currentTimeMillis()));
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getRemoteAddr();
        log.info("[请求IP] : " + ip);
        log.info("[请求方法名称] : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("[请求参数] : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "logPointcut()")
    public void doAfterReturning(Object ret) {
        log.info("[返回对象] : " + ret);
        log.info("[结束时间] : " + (System.currentTimeMillis()));
    }

    @AfterThrowing(throwing="ex", pointcut="logPointcut()")
    public void doAfterThrowing(Throwable ex) {
        log.error("[异常] : " + ex);
    }
}
