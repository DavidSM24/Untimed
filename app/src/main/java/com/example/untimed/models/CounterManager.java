package com.example.untimed.models;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import androidx.core.app.NotificationCompat;

import com.example.untimed.MainActivity;

import java.io.Serializable;

public class CounterManager extends Counter implements Runnable, Serializable {

    public Thread t;
    private Activity main;

    public CounterManager(Activity main){
        super();
        this.main=main;
    }

    /**
     * En el método run se ejecutará el bucle de conteo principal.
     *
     */
    @Override
    public void run() {

        t= Thread.currentThread();

        while(!t.isInterrupted()) {

            try {

                main.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        finalTime=converter();
                        MainActivity.lab_count.setText(finalTime);
                    }
                });

                Thread.sleep(1000);

                seconds+=1;

                if(seconds==60){
                    minutes++;
                    seconds=0;
                }
                if (minutes == 60) {
                    hours++;
                    minutes = 0;
                }


                pause();

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                System.out.println("nice exception ^.^");
                System.out.println(Thread.currentThread().isInterrupted());
                t.interrupt();
            }
        }
    }

    /**
     * Reanuda el contador
     *
     */
    public synchronized void resume(){

        stoped=false;

        if(started){
            notifyAll();
        }
    }

    /**
     * Pausa el conteo
     *
     */
    public synchronized void pause() throws InterruptedException {

        while(stoped){
            wait();
        }
    }


    /**
     * Forma la fecha y la convierte a String para setearla en la View.
     *
     */
    public String converter(){

        String result="";

        if(hours<10){
            result+="0"+hours;
        }
        else{
            result+=hours;
        }

        result+=" : ";

        if(minutes<10){
            result+="0"+minutes;
        }
        else{
            result+=minutes;
        }

        result+=" : ";

        if(seconds<10){
            result+="0"+seconds;
        }
        else{
            result+=seconds;
        }

        return result;
    }
}
