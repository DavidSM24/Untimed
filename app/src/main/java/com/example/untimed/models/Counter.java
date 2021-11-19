package com.example.untimed.models;

public class Counter {

    protected String finalTime;
    protected int seconds;
    protected int minutes;
    protected int hours;
    protected boolean running;

    public Counter(){
        this.seconds=0;
        this.minutes=0;
        this.hours=0;

        this.finalTime="00 : 00 : 00";
    }

    public String getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(String finalTime) {
        this.finalTime = finalTime;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "finalTime='" + finalTime + '\'' +
                ", seconds=" + seconds +
                ", minutes=" + minutes +
                ", hours=" + hours +
                ", running=" + running +
                '}';
    }
}
