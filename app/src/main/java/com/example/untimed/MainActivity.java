package com.example.untimed;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.untimed.models.Counter;
import com.example.untimed.models.CounterManager;
import com.google.android.material.chip.Chip;

import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {

    private CounterManager counter;
    Thread t;

    private TextView lab_count;
    private Chip btn_start;
    private Chip btn_stop;
    private Chip btn_restart;

    /**
     * Instaciación del Activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
        getSupportActionBar().setTitle(null);

        lab_count=findViewById(R.id.lab_count);
        btn_start=findViewById(R.id.btn_start);
        btn_stop=findViewById(R.id.btn_stop);
        btn_restart=findViewById(R.id.btn_restart);

        btn_stop.setEnabled(false);
        btn_restart.setEnabled(false);

        counter=new CounterManager();
        counter.setFinalTime("00 : 00: 00");
        lab_count.setText(counter.getFinalTime());

    }

    /**
     * Empieza o Reanuda el contador
     *
     * @param view vista que ejecutará el método
     */
    public void start(View view){

        btn_start.setEnabled(false);
        btn_start.setText("Contando...");
        btn_stop.setEnabled(true);
        btn_restart.setEnabled(true);
        Toast.makeText(this,"Se ha pulsado start...",Toast.LENGTH_SHORT).show();
    }

    /**
     * Pausa el contador
     *
     * @param view vista que ejecutará el método
     */
    public void stop(View view){
        btn_start.setEnabled(true);
        btn_start.setText("Reanudar");
        btn_stop.setEnabled(false);
        btn_restart.setEnabled(true);
        Toast.makeText(this,"Se ha pulsado stop...",Toast.LENGTH_SHORT).show();
    }

    /**
     * Detiene el contador y lo reinicia. No empieza el conteo automáticamente.
     *
     * @param view vista que ejecutará el método
     */
    public void restart(View view){
        btn_start.setEnabled(true);
        btn_start.setText("Iniciar");
        btn_stop.setEnabled(false);
        btn_restart.setEnabled(false);
        Toast.makeText(this,"Se ha pulsado restart...",Toast.LENGTH_SHORT).show();
    }
}