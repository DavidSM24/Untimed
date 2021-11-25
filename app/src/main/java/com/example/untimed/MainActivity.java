package com.example.untimed;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.untimed.models.CounterManager;
import com.google.android.material.chip.Chip;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    Activity main;
    Thread t;
    private CounterManager counter;
    public static TextView lab_count;
    private Chip btn_start;
    private Chip btn_stop;
    private Chip btn_restart;

    /**
     * Instaciación del Activity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
        getSupportActionBar().setTitle(null);

        lab_count = findViewById(R.id.lab_count);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);
        btn_restart = findViewById(R.id.btn_restart);

        btn_stop.setEnabled(false);
        btn_restart.setEnabled(false);

        main = (Activity) this;
        counter = new CounterManager(main);
        counter.setFinalTime("00 : 00 : 00");
        lab_count.setText(counter.getFinalTime());
    }


    /**
     * Empieza o Reanuda el contador
     *
     * @param view vista que ejecutará el método
     */
    public void start(View view) {

        if(!counter.isStarted()){

            main = (Activity) this;
            btn_start.setEnabled(false);
            btn_start.setText("Contando...");
            btn_stop.setEnabled(true);
            btn_restart.setEnabled(true);

            counter = new CounterManager(main);
            counter.setFinalTime("00 : 00: 00");

            counter.setStarted(true);
            t = new Thread(counter);
            t.start();
        }
        else{

            btn_start.setEnabled(false);
            btn_start.setText("Contando...");
            btn_stop.setEnabled(true);
            btn_restart.setEnabled(true);

            counter.resume();
        }

        Toast.makeText(this, "Se ha pulsado start...", Toast.LENGTH_SHORT).show();

    }

    /**
     * Pausa el contador
     *
     * @param view vista que ejecutará el método
     */
    public void stop(View view) throws InterruptedException {

        btn_start.setEnabled(true);
        btn_start.setText("Reanudar");
        btn_stop.setEnabled(false);
        btn_restart.setEnabled(true);

        counter.setStoped(true);

        Toast.makeText(this, "Se ha pulsado stop...", Toast.LENGTH_SHORT).show();
    }

    /**
     * Detiene el contador y lo reinicia. No empieza el conteo automáticamente.
     *
     * @param view vista que ejecutará el método
     */

    public void restart(View view) {

        btn_start.setEnabled(true);
        btn_start.setText("Iniciar");
        btn_stop.setEnabled(false);
        btn_restart.setEnabled(false);

        counter.t.interrupt();
        counter.setStarted(false);
        lab_count.setText("00 : 00 : 00");

        Toast.makeText(this, "Se ha pulsado restart...", Toast.LENGTH_SHORT).show();

    }
}