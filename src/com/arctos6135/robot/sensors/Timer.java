package com.arctos6135.robot.sensors;

public class Timer implements Sensor {
    double LastTime;

    Timer() {
        this.LastTime = System.currentTimeMillis();
    }
    
    public double getReading() {
        double curTime = System.currentTimeMillis();
        return curTime-this.LastTime;
    }

    public void Reset() {
        this.LastTime = System.currentTimeMillis();
    }
}
