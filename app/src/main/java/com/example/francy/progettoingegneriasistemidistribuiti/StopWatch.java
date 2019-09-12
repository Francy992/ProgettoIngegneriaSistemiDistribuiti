package com.example.francy.progettoingegneriasistemidistribuiti;

import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by Francy on 12/09/2019.
 */

public class StopWatch {
    /**
     * Class representing a StopWatch for measuring time.
     */
    private long startTime;
    private long endTime;
    private long elapsedTime;
    public static int cont = 0;

    public StopWatch() {
        //empty
        Log.d("Francionic --> ", "Creato Stopwatch");
    }

    private void reset() {
        startTime = 0;
        endTime = 0;
        elapsedTime = 0;
    }

    public void start() {
        reset();
        startTime = System.nanoTime();
    }

    public void stop() {
        if (startTime != 0) {
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
        } else {
            reset();
        }
    }

    public long getTotalTimeMillis() {
        return (elapsedTime != 0) ? TimeUnit.NANOSECONDS.toMillis(endTime - startTime) : 0;
    }
}
