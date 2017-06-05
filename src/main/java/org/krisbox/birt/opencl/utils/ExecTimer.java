package org.krisbox.birt.opencl.utils;

public class ExecTimer {
    private long startTime;
    private long endTime;

    public ExecTimer() {
    }

    public void startTimer() {
        startTime = 0;
        endTime   = 0;

        startTime = System.nanoTime();
    }

    public void endTimer() {
        endTime = System.nanoTime();
    }

    public void printExecTime() {
        System.out.println((getExecTime()/1000) + " seconds");
    }

    public long getExecTime() {
        return (endTime - startTime)/1000000;
    }

    public void clearTimer() {
        startTime = 0;
        endTime   = 0;
    }
}
