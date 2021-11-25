package com.example.untimed.models;

public class Counter {

    protected String finalTime;
    protected int seconds;
    protected int minutes;
    protected int hours;
    protected boolean started;
    protected boolean stoped;

    public Counter(){
        this.seconds=0;
        this.minutes=0;
        this.hours=0;

        this.finalTime="00 : 00 : 00";
        this.stoped=false;
        this.started=false;
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

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public boolean isStoped() {
        return stoped;
    }

    public void setStoped(boolean stoped) {
        this.stoped = stoped;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "finalTime='" + finalTime + '\'' +
                ", seconds=" + seconds +
                ", minutes=" + minutes +
                ", hours=" + hours +
                ", running=" + started +
                ", stoped=" + stoped +
                '}';
    }
}
