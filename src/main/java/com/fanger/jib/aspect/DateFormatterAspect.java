package com.fanger.jib.aspect;

import com.fanger.jib.annotation.DateFormatter;
import com.fanger.jib.exception.AnnotationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class DateFormatterAspect {

    private static Logger log = LoggerFactory.getLogger(DateFormatterAspect.class);

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.fanger.jib.annotation.DateFormatter)")
    public void dateFormatterPointCut() { }

    /**
     * 环绕通知
     * 当然也可以使用 @Before (前置通知)  @After (后置通知)
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("dateFormatterPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DateFormatter ds = method.getAnnotation(DateFormatter.class);
        if(ds == null){
            throw new AnnotationException("Annotation Exception");
        }else {
            log.info("set datasource is " + new SimpleDateFormat(ds.value()).format(new Date()));
        }
        return point.proceed();
    }

}
