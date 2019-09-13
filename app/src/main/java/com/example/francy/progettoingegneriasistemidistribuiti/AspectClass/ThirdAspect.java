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
    //private static final String ALLMETHOD = "execution(public * com.example.francy.progettoingegneriasistemidistribuiti.MainActivity.*(..))"; //Funzionante per MainActivity
    private static final String ALLMETHOD = "execution(public * java.lang.Math.*(..))";
    @Pointcut(ALLMETHOD)
    public void AllMethod(){    }

    @Before("AllMethod()")
    public void onClickAdvice() {
        //int ciao = 1;
        /*Log.d(DebugName.THIRD,
                "Entering class: " + jp.getSignature().getDeclaringTypeName() +
                        " - before method: " + jp.getSignature().getName());*/

        Log.d(DebugName.THIRD, "onClickAdvice... ");
        //Object result = jp.proceed();

    }

}
