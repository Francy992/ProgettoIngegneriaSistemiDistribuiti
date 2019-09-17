package com.example.francy.progettoingegneriasistemidistribuiti.AspectClass;

import android.util.Log;

import com.example.francy.progettoingegneriasistemidistribuiti.DebugName;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Francy on 13/09/2019.
 */

@Aspect
public class ThirdAspect {
    //***************************FUNZIONANTE SE DECOMMENTATO.
    /*private static final String ALLMETHOD = "execution(public * com.example.francy.progettoingegneriasistemidistribuiti.MainActivity.*(..))"; //Funzionante per MainActivity
    //private static final String ALLMETHOD = "execution(public * java.lang.Math.*(..))";
    //private static final String ALLMETHOD = "execution(* *(..))";
    @Pointcut(ALLMETHOD)
    public void AllMethod(){    }

    @Around("AllMethod()")
    public Object onClickAdvice(ProceedingJoinPoint jp) throws Throwable {
        Log.d(DebugName.THIRD, jp.toString());
        Object result = jp.proceed();
        return result;
    }*/

}
