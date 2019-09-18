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
    private static final String MAINACTIVITY =
            "call(* android.app.Activity..*(..))";

    private static final String ONREQUESTPERMISSIONCALLBACL =
            "execution(public * com.example.francy.progettoingegneriasistemidistribuiti.MainActivity.*(..))";

    private static final String CHECKPERMISSION =
           "call(* android.support..*(..))";


    @Pointcut(MAINACTIVITY)
    public void checkMainActivity(){

    }

    @Around("checkMainActivity()")
    public Object implementationcheckMainActivity(@NonNull ProceedingJoinPoint jp) throws Throwable {
        Object result = jp.proceed();
        Log.d(DebugName.MAINACTIVITY, jp.toString());
        return result;
    }

    @Pointcut(ONREQUESTPERMISSIONCALLBACL)
    public void onRequestPermissionCallback(){

    }

    @Around("onRequestPermissionCallback()")
    public Object implementationOnRequestPermissionCallback(@NonNull ProceedingJoinPoint jp) throws Throwable {
        Object result = jp.proceed();
        Log.d(DebugName.ONREQUESTPERMISSIONCALLBACK, jp.toString());
        return result;
    }

    @Pointcut(CHECKPERMISSION)
    public void checkPermission(){

    }

    @Around("checkPermission()")
    public Object implementationCheckPermission(@NonNull ProceedingJoinPoint jp) throws Throwable {
        Object result = jp.proceed();
        Log.d(DebugName.GENERIC, jp.toString());
        return result;
    }
}
