package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start= System.currentTimeMillis();
        System.out.println("START: "+ joinPoint.toString()); // 어떤메서드 콜하는지 파악 가능
        try{
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs= finish- start;
            System.out.println("END: "+ joinPoint.toString() + " " + timeMs + "ms");

        }

    }

}
