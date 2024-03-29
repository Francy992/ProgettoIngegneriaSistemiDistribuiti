package com.example.francy.progettoingegneriasistemidistribuiti.AspectClass;

import android.util.Log;

import com.example.francy.progettoingegneriasistemidistribuiti.DebugName;
import com.example.francy.progettoingegneriasistemidistribuiti.StopWatch;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by Francy on 12/09/2019.
 */


@Aspect
public class FirstAspect {
    private static final String POINTCUT_METHOD =
            "execution(@com.example.francy.progettoingegneriasistemidistribuiti.AnnotationTrace * *(..))";

    private static final String POINTCUT_CONSTRUCTOR =
            "execution(@com.example.francy.progettoingegneriasistemidistribuiti.AnnotationTrace *.new(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithDebugTrace() {}

    @Pointcut(POINTCUT_CONSTRUCTOR)
    public void constructorAnnotatedDebugTrace() {}

    @Around("methodAnnotatedWithDebugTrace() || constructorAnnotatedDebugTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();

        Log.d(className, buildLogMessage(methodName, stopWatch.getTotalTimeMillis(), stopWatch.cont));
        stopWatch.cont++;
        return result;
    }

    /**
     * Create a log message.
     *
     * @param methodName A string with the method name.
     * @param methodDuration Duration of the method in milliseconds.
     * @return A string representing message.
     */
    private static String buildLogMessage(String methodName, long methodDuration, int cont) {
        StringBuilder message = new StringBuilder();
        message.append(DebugName.FIRST + " Call number " + cont + ", Method name: ");
        message.append(methodName);
        message.append(" --> ");
        message.append("[");
        message.append(methodDuration);
        message.append("ms");
        message.append("]");

        return message.toString();
    }

}
