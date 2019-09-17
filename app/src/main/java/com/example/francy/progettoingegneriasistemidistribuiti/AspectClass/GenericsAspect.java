package com.example.francy.progettoingegneriasistemidistribuiti.AspectClass;

import android.support.annotation.NonNull;
import android.util.DebugUtils;
import android.util.Log;

import com.example.francy.progettoingegneriasistemidistribuiti.DebugName;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class GenericsAspect {
    private static final String CHECKSELFPERMISSION =
            //"execution(public * *(..))";
            "call(* android.app..*(..))";

    private static final String CHECKPERMISSION =
           "call(* android.support..*(..))";
    @Pointcut(CHECKSELFPERMISSION)
    public void checkSelfPermission(){

    }

    @Around("checkSelfPermission()")
    public Object implementationCheckSelfPermission(@NonNull ProceedingJoinPoint jp) throws Throwable {
        Object result = jp.proceed();
        Log.d(DebugName.GENERIC, "1) implementationCheckSelfPermission-->" + jp.toString());
        return result;
    }

    @Pointcut(CHECKPERMISSION)
    public void checkPermission(){

    }

    @Around("checkPermission()")
    public Object implementationCheckPermission(@NonNull ProceedingJoinPoint jp) throws Throwable {
        Object result = jp.proceed();
        Log.d(DebugName.GENERIC, "2) implementationCheckPermission-->" + jp.toString());
        return result;
    }
}
