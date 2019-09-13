package com.example.francy.progettoingegneriasistemidistribuiti.AspectClass;

import android.util.Log;

import com.example.francy.progettoingegneriasistemidistribuiti.DebugName;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Francy on 12/09/2019.
 */

@Aspect
public class SecondAspect {

    //@Pointcut("execution(int Prova(..))")//QUESTO è FUNZIONANTE
    //@Pointcut("execution(* Prova(..))")//QUESTO è FUNZIONANTE
    //@Pointcut("execution(* Prova(int, String))")//FUNZIONANTE
    @Pointcut("execution(* *(int, String))") //FUNZIOPNANTE

    // /@Pointcut("execution(* Prova(*))")//NON è FUNZIONANTE
    ///@Pointcut("execution(* *(..)")//NON è FUNZIONANTE

    //@Pointcut("execution(@com.example.francy.progettoingegneriasistemidistribuiti.MainActivity int Prova(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object onClickAdvice(ProceedingJoinPoint jp) throws Throwable  {
        //int ciao = 1;
        Log.d(DebugName.SECOND,
                "Entering class: " + jp.getSignature().getDeclaringTypeName() +
                        " - before method: " + jp.getSignature().getName());

        Log.d(DebugName.SECOND, "onClickAdvice... ");
        Object result = jp.proceed();
        return result;
    }

    //@Pointcut("execution(* checkSelfPermission(..))")
    @Pointcut("execution(* checkSelfPermission(..))")
    public void checkSelfPermission() {

    }

    @Before("checkSelfPermission()")
    public Object checkSelfPermissionAdvice(ProceedingJoinPoint jp) throws Throwable{
        Log.d(DebugName.SECOND, "checkSelfPermissionAdvice...");
        Object result = jp.proceed();
        return result;
    }

    @Pointcut("execution(static void requestPermissions(..))")
    public void onRequestPermissions() {

    }

    @Around("onRequestPermissions()")
    public void onRequestPermissionsAdvice(ProceedingJoinPoint jp) {
        Log.d(DebugName.SECOND, "onRequestPermissionsAdvice...");
    }
}
