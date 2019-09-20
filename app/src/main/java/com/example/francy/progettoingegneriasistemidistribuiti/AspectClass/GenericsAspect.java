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

    private static final String MAINACTIVITY = "call(* com.example.francy.progettoingegneriasistemidistribuiti.MainActivity..*(..))";
    @Pointcut(MAINACTIVITY)
    public void checkMainActivity(){}
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

    private static final String CHECKPERMISSION = "call(* android.support..*(..))";
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

    private static final String DISPATCHREQUESTPERMISSIONSRESULT1 = "call(android.app.ContextImpl.*(..))";
    @Pointcut(DISPATCHREQUESTPERMISSIONSRESULT1)
    public void dispatchRequestPermissionsResultAspect1(){ }
    @Around("dispatchRequestPermissionsResultAspect1()")
    public Object implementationdispatchRequestPermissionsResult1(@NonNull ProceedingJoinPoint jp) throws Throwable {
        Object result = jp.proceed();
        Log.d(DebugName.cont++ + ") Francionic: requestPermissions1", jp.toString());
        return result;
    }

    private static final String DISPATCHREQUESTPERMISSIONSRESULT2 = "execution(android.app.ContextImpl.*(..))";
    @Pointcut(DISPATCHREQUESTPERMISSIONSRESULT2)
    public void dispatchRequestPermissionsResultAspect2(){ }
    @Around("dispatchRequestPermissionsResultAspect2()")
    public Object implementationdispatchRequestPermissionsResult2(@NonNull ProceedingJoinPoint jp) throws Throwable {
        Object result = jp.proceed();
        Log.d(DebugName.cont++ + ") Francionic: requestPermissions1", jp.toString());
        return result;
    }
}
