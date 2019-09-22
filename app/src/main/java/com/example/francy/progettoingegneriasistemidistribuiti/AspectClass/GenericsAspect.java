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

    //Join Point
    private static final String MAINACTIVITY = "call(* com.example.francy.progettoingegneriasistemidistribuiti.MainActivity.checkPermission(..))";

    //Pointcut
    @Pointcut(MAINACTIVITY)
    public void checkMainActivity(){}

    //Advice
    @Around("checkMainActivity()")
    public Object implementationcheckMainActivity(@NonNull ProceedingJoinPoint jp) throws Throwable {
        Object result = jp.proceed();
        Log.d(DebugName.cont++ + ") " + DebugName.MAINACTIVITY, jp.toString());
        return result;
    }

    private static final String ONREQUESTPERMISSIONCALLBACL = "execution(* onRequestPermissionsResult(..))";
    @Pointcut(ONREQUESTPERMISSIONCALLBACL)
    public void onRequestPermissionCallback(){}
    @Around("onRequestPermissionCallback()")
    public Object implementationOnRequestPermissionCallback(@NonNull ProceedingJoinPoint jp) throws Throwable {
        Object result = jp.proceed();
        Log.d(DebugName.cont++ + ") " + DebugName.ONREQUESTPERMISSIONCALLBACK, jp.toString());
        return result;
    }

    private static final String CHECKPERMISSION = "call(* checkSelfPermission(..))";
    @Pointcut(CHECKPERMISSION)
    public void checkPermission(){}
    @Around("checkPermission()")
    public Object implementationCheckPermission(@NonNull ProceedingJoinPoint jp) throws Throwable {
        Object result = jp.proceed();
        Log.d(DebugName.cont++ + ") " + DebugName.GENERIC, jp.toString());
        return result;
    }

    private static final String requestPermissions = "call(public static void requestPermissions(..))";
    @Pointcut(requestPermissions)
    public void requestPermissionsAspect(){ }
    @Around("requestPermissionsAspect()")
    public Object implementationRequestPermissionsAspect(@NonNull ProceedingJoinPoint jp) throws Throwable {
        Object result = jp.proceed();
        Log.d(DebugName.cont++ + DebugName.REQUESTPERMISSIONS, jp.toString());
        return result;
    }




}
