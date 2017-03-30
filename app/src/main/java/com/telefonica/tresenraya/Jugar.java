package com.telefonica.tresenraya;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.*;
import java.util.Timer;
import java.util.TimerTask;

import static com.telefonica.tresenraya.R.id.parent;

public class Jugar extends AppCompatActivity {

    private String nombre;
    private boolean sonido;
    private boolean maquina;
    private int contadorX=0;
    private int contadorO=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences sp = this.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        TextView nombreJugador = (TextView) this.findViewById(R.id.etiquetaNombre);
        nombre = sp.getString("Nombre","");
        sonido = sp.getBoolean("Sonido",false);
        maquina = sp.getBoolean("Maquina",false);
        nombreJugador.setText("A jugar "+nombre+"!!!");
        if(maquina){
            empiezaMaquina();
        }
    }


    public void salir(){
        SharedPreferences sp = this.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
        Intent intent = new Intent(this, Principal.class);
        this.startActivity(intent);
    }

    public void ponerCruz(View v) throws InterruptedException {
        ImageView img = (ImageView) findViewById(v.getId());
        img.setImageResource(R.drawable.cruz);
        img.setClickable(false);
        if(sonido){
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cruz);
            mp.start();
        }
        comprobarMovimientos();
        contadorX++;
        ponerCirculo(img.getTag().toString());
    }

    public void ponerCirculo(String tag){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.circulo);
        switch (tag){
            case "celda1":
                ImageView oponente1Celda1 = (ImageView) findViewById(R.id.celda3);
                if(oponente1Celda1.isClickable()){
                    oponente1Celda1.setImageResource(R.drawable.circulo);
                    oponente1Celda1.setClickable(false);
                    if(sonido){
                        mp.start();
                    }
                    contadorO++;
                    comprobarMovimientos();
                }else{
                    ImageView oponente2Celda1 = (ImageView) findViewById(R.id.celda9);
                    if(oponente2Celda1.isClickable()){
                        oponente2Celda1.setImageResource(R.drawable.circulo);
                        oponente2Celda1.setClickable(false);
                        if(sonido){
                            mp.start();
                        }
                        contadorO++;
                        comprobarMovimientos();
                    }else{
                        ImageView oponente3Celda1 = (ImageView) findViewById(R.id.celda7);
                        if(oponente3Celda1.isClickable()){
                            oponente3Celda1.setImageResource(R.drawable.circulo);
                            oponente3Celda1.setClickable(false);
                            if(sonido){
                                mp.start();
                            }
                            contadorO++;
                            comprobarMovimientos();
                        }else{
                            ImageView oponente4Celda1 = (ImageView) findViewById(R.id.celda5);
                            if(oponente4Celda1.isClickable()){
                                oponente4Celda1.setImageResource(R.drawable.circulo);
                                oponente4Celda1.setClickable(false);
                                if(sonido){
                                    mp.start();
                                }
                                contadorO++;
                                comprobarMovimientos();
                            }else{
                                ImageView oponente5Celda1 = (ImageView) findViewById(R.id.celda2);
                                if(oponente5Celda1.isClickable()){
                                    oponente5Celda1.setImageResource(R.drawable.circulo);
                                    oponente5Celda1.setClickable(false);
                                    if(sonido){
                                        mp.start();
                                    }
                                    contadorO++;
                                    comprobarMovimientos();
                                }else{
                                    ImageView oponente6Celda1 = (ImageView) findViewById(R.id.celda4);
                                    if(oponente6Celda1.isClickable()){
                                        oponente6Celda1.setImageResource(R.drawable.circulo);
                                        oponente6Celda1.setClickable(false);
                                        if(sonido){
                                            mp.start();
                                        }
                                        contadorO++;
                                        comprobarMovimientos();
                                    }else{
                                        ImageView oponente7Celda1 = (ImageView) findViewById(R.id.celda6);
                                        if(oponente7Celda1.isClickable()){
                                            oponente7Celda1.setImageResource(R.drawable.circulo);
                                            oponente7Celda1.setClickable(false);
                                            if(sonido){
                                                mp.start();
                                            }
                                            contadorO++;
                                            comprobarMovimientos();
                                        }else{
                                            ImageView oponente8Celda1 = (ImageView) findViewById(R.id.celda8);
                                            if(oponente8Celda1.isClickable()){
                                                oponente8Celda1.setImageResource(R.drawable.circulo);
                                                oponente8Celda1.setClickable(false);
                                                if(sonido){
                                                    mp.start();
                                                }
                                                contadorO++;
                                                comprobarMovimientos();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "celda2":
                ImageView oponente1Celda2 = (ImageView) findViewById(R.id.celda5);
                if(oponente1Celda2.isClickable()){
                    oponente1Celda2.setImageResource(R.drawable.circulo);
                    oponente1Celda2.setClickable(false);
                    if(sonido){
                        mp.start();
                    }
                    contadorO++;
                    comprobarMovimientos();
                }else{
                    ImageView oponente2Celda2 = (ImageView) findViewById(R.id.celda3);
                    if(oponente2Celda2.isClickable()){
                        oponente2Celda2.setImageResource(R.drawable.circulo);
                        oponente2Celda2.setClickable(false);
                        if(sonido){
                            mp.start();
                        }
                        contadorO++;
                        comprobarMovimientos();
                    }else{
                        ImageView oponente3Celda2 = (ImageView) findViewById(R.id.celda9);
                        if(oponente3Celda2.isClickable()){
                            oponente3Celda2.setImageResource(R.drawable.circulo);
                            oponente3Celda2.setClickable(false);
                            if(sonido){
                                mp.start();
                            }
                            contadorO++;
                            comprobarMovimientos();
                        }else{
                            ImageView oponente4Celda2 = (ImageView) findViewById(R.id.celda7);
                            if(oponente4Celda2.isClickable()){
                                oponente4Celda2.setImageResource(R.drawable.circulo);
                                oponente4Celda2.setClickable(false);
                                if(sonido){
                                    mp.start();
                                }
                                contadorO++;
                                comprobarMovimientos();
                            }else{
                                ImageView oponente5Celda2 = (ImageView) findViewById(R.id.celda1);
                                if(oponente5Celda2.isClickable()){
                                    oponente5Celda2.setImageResource(R.drawable.circulo);
                                    oponente5Celda2.setClickable(false);
                                    if(sonido){
                                        mp.start();
                                    }
                                    contadorO++;
                                    comprobarMovimientos();
                                }else{
                                    ImageView oponente6Celda2 = (ImageView) findViewById(R.id.celda4);
                                    if(oponente6Celda2.isClickable()){
                                        oponente6Celda2.setImageResource(R.drawable.circulo);
                                        oponente6Celda2.setClickable(false);
                                        if(sonido){
                                            mp.start();
                                        }
                                        contadorO++;
                                        comprobarMovimientos();
                                    }else{
                                        ImageView oponente7Celda2 = (ImageView) findViewById(R.id.celda8);
                                        if(oponente7Celda2.isClickable()){
                                            oponente7Celda2.setImageResource(R.drawable.circulo);
                                            oponente7Celda2.setClickable(false);
                                            if(sonido){
                                                mp.start();
                                            }
                                            contadorO++;
                                            comprobarMovimientos();
                                        }else{
                                            ImageView oponente8Celda2 = (ImageView) findViewById(R.id.celda6);
                                            if(oponente8Celda2.isClickable()){
                                                oponente8Celda2.setImageResource(R.drawable.circulo);
                                                oponente8Celda2.setClickable(false);
                                                if(sonido){
                                                    mp.start();
                                                }
                                                contadorO++;
                                                comprobarMovimientos();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "celda3":
                ImageView oponente1Celda3 = (ImageView) findViewById(R.id.celda5);
                if(oponente1Celda3.isClickable()){
                    oponente1Celda3.setImageResource(R.drawable.circulo);
                    oponente1Celda3.setClickable(false);
                    if(sonido){
                        mp.start();
                    }
                    contadorO++;
                    comprobarMovimientos();
                }else{
                    ImageView oponente2Celda3 = (ImageView) findViewById(R.id.celda1);
                    if(oponente2Celda3.isClickable()){
                        oponente2Celda3.setImageResource(R.drawable.circulo);
                        oponente2Celda3.setClickable(false);
                        if(sonido){
                            mp.start();
                        }
                        contadorO++;
                        comprobarMovimientos();
                    }else{
                        ImageView oponente3Celda3 = (ImageView) findViewById(R.id.celda6);
                        if(oponente3Celda3.isClickable()){
                            oponente3Celda3.setImageResource(R.drawable.circulo);
                            oponente3Celda3.setClickable(false);
                            if(sonido){
                                mp.start();
                            }
                            contadorO++;
                            comprobarMovimientos();
                        }else{
                            ImageView oponente4Celda3 = (ImageView) findViewById(R.id.celda8);
                            if(oponente4Celda3.isClickable()){
                                oponente4Celda3.setImageResource(R.drawable.circulo);
                                oponente4Celda3.setClickable(false);
                                if(sonido){
                                    mp.start();
                                }
                                contadorO++;
                                comprobarMovimientos();
                            }else{
                                ImageView oponente5Celda3 = (ImageView) findViewById(R.id.celda9);
                                if(oponente5Celda3.isClickable()){
                                    oponente5Celda3.setImageResource(R.drawable.circulo);
                                    oponente5Celda3.setClickable(false);
                                    if(sonido){
                                        mp.start();
                                    }
                                    contadorO++;
                                    comprobarMovimientos();
                                }else{
                                    ImageView oponente6Celda3 = (ImageView) findViewById(R.id.celda4);
                                    if(oponente6Celda3.isClickable()){
                                        oponente6Celda3.setImageResource(R.drawable.circulo);
                                        oponente6Celda3.setClickable(false);
                                        if(sonido){
                                            mp.start();
                                        }
                                        contadorO++;
                                        comprobarMovimientos();
                                    }else{
                                        ImageView oponente7Celda3 = (ImageView) findViewById(R.id.celda2);
                                        if(oponente7Celda3.isClickable()){
                                            oponente7Celda3.setImageResource(R.drawable.circulo);
                                            oponente7Celda3.setClickable(false);
                                            if(sonido){
                                                mp.start();
                                            }
                                            contadorO++;
                                            comprobarMovimientos();
                                        }else{
                                            ImageView oponente8Celda3 = (ImageView) findViewById(R.id.celda7);
                                            if(oponente8Celda3.isClickable()){
                                                oponente8Celda3.setImageResource(R.drawable.circulo);
                                                oponente8Celda3.setClickable(false);
                                                if(sonido){
                                                    mp.start();
                                                }
                                                contadorO++;
                                                comprobarMovimientos();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "celda4":
                ImageView oponente1Celda4 = (ImageView) findViewById(R.id.celda5);
                if(oponente1Celda4.isClickable()){
                    oponente1Celda4.setImageResource(R.drawable.circulo);
                    oponente1Celda4.setClickable(false);
                    if(sonido){
                        mp.start();
                    }
                    contadorO++;
                    comprobarMovimientos();
                }else{
                    ImageView oponente2Celda4 = (ImageView) findViewById(R.id.celda7);
                    if(oponente2Celda4.isClickable()){
                        oponente2Celda4.setImageResource(R.drawable.circulo);
                        oponente2Celda4.setClickable(false);
                        if(sonido){
                            mp.start();
                        }
                        contadorO++;
                        comprobarMovimientos();
                    }else{
                        ImageView oponente3Celda4 = (ImageView) findViewById(R.id.celda1);
                        if(oponente3Celda4.isClickable()){
                            oponente3Celda4.setImageResource(R.drawable.circulo);
                            oponente3Celda4.setClickable(false);
                            if(sonido){
                                mp.start();
                            }
                            contadorO++;
                            comprobarMovimientos();
                        }else{
                            ImageView oponente4Celda4 = (ImageView) findViewById(R.id.celda8);
                            if(oponente4Celda4.isClickable()){
                                oponente4Celda4.setImageResource(R.drawable.circulo);
                                oponente4Celda4.setClickable(false);
                                if(sonido){
                                    mp.start();
                                }
                                contadorO++;
                                comprobarMovimientos();
                            }else{
                                ImageView oponente5Celda4 = (ImageView) findViewById(R.id.celda2);
                                if(oponente5Celda4.isClickable()){
                                    oponente5Celda4.setImageResource(R.drawable.circulo);
                                    oponente5Celda4.setClickable(false);
                                    if(sonido){
                                        mp.start();
                                    }
                                    contadorO++;
                                    comprobarMovimientos();
                                }else{
                                    ImageView oponente6Celda4 = (ImageView) findViewById(R.id.celda6);
                                    if(oponente6Celda4.isClickable()){
                                        oponente6Celda4.setImageResource(R.drawable.circulo);
                                        oponente6Celda4.setClickable(false);
                                        if(sonido){
                                            mp.start();
                                        }
                                        contadorO++;
                                        comprobarMovimientos();
                                    }else{
                                        ImageView oponente7Celda4 = (ImageView) findViewById(R.id.celda9);
                                        if(oponente7Celda4.isClickable()){
                                            oponente7Celda4.setImageResource(R.drawable.circulo);
                                            oponente7Celda4.setClickable(false);
                                            if(sonido){
                                                mp.start();
                                            }
                                            contadorO++;
                                            comprobarMovimientos();
                                        }else{
                                            ImageView oponente8Celda4 = (ImageView) findViewById(R.id.celda3);
                                            if(oponente8Celda4.isClickable()){
                                                oponente8Celda4.setImageResource(R.drawable.circulo);
                                                oponente8Celda4.setClickable(false);
                                                if(sonido){
                                                    mp.start();
                                                }
                                                contadorO++;
                                                comprobarMovimientos();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "celda5":
                ImageView oponente1Celda5 = (ImageView) findViewById(R.id.celda1);
                if(oponente1Celda5.isClickable()){
                    oponente1Celda5.setImageResource(R.drawable.circulo);
                    oponente1Celda5.setClickable(false);
                    if(sonido){
                        mp.start();
                    }
                    contadorO++;
                    comprobarMovimientos();
                }else{
                    ImageView oponente2Celda5 = (ImageView) findViewById(R.id.celda9);
                    if(oponente2Celda5.isClickable()){
                        oponente2Celda5.setImageResource(R.drawable.circulo);
                        oponente2Celda5.setClickable(false);
                        if(sonido){
                            mp.start();
                        }
                        contadorO++;
                        comprobarMovimientos();
                    }else{
                        ImageView oponente3Celda5 = (ImageView) findViewById(R.id.celda3);
                        if(oponente3Celda5.isClickable()){
                            oponente3Celda5.setImageResource(R.drawable.circulo);
                            oponente3Celda5.setClickable(false);
                            if(sonido){
                                mp.start();
                            }
                            contadorO++;
                            comprobarMovimientos();
                        }else{
                            ImageView oponente4Celda5 = (ImageView) findViewById(R.id.celda7);
                            if(oponente4Celda5.isClickable()){
                                oponente4Celda5.setImageResource(R.drawable.circulo);
                                oponente4Celda5.setClickable(false);
                                if(sonido){
                                    mp.start();
                                }
                                contadorO++;
                                comprobarMovimientos();
                            }else{
                                ImageView oponente5Celda5 = (ImageView) findViewById(R.id.celda4);
                                if(oponente5Celda5.isClickable()){
                                    oponente5Celda5.setImageResource(R.drawable.circulo);
                                    oponente5Celda5.setClickable(false);
                                    if(sonido){
                                        mp.start();
                                    }
                                    contadorO++;
                                    comprobarMovimientos();
                                }else{
                                    ImageView oponente6Celda5 = (ImageView) findViewById(R.id.celda6);
                                    if(oponente6Celda5.isClickable()){
                                        oponente6Celda5.setImageResource(R.drawable.circulo);
                                        oponente6Celda5.setClickable(false);
                                        if(sonido){
                                            mp.start();
                                        }
                                        contadorO++;
                                        comprobarMovimientos();
                                    }else{
                                        ImageView oponente7Celda5 = (ImageView) findViewById(R.id.celda2);
                                        if(oponente7Celda5.isClickable()){
                                            oponente7Celda5.setImageResource(R.drawable.circulo);
                                            oponente7Celda5.setClickable(false);
                                            if(sonido){
                                                mp.start();
                                            }
                                            contadorO++;
                                            comprobarMovimientos();
                                        }else{
                                            ImageView oponente8Celda5 = (ImageView) findViewById(R.id.celda8);
                                            if(oponente8Celda5.isClickable()){
                                                oponente8Celda5.setImageResource(R.drawable.circulo);
                                                oponente8Celda5.setClickable(false);
                                                if(sonido){
                                                    mp.start();
                                                }
                                                contadorO++;
                                                comprobarMovimientos();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "celda6":
                ImageView oponente1Celda6 = (ImageView) findViewById(R.id.celda5);
                if(oponente1Celda6.isClickable()){
                    oponente1Celda6.setImageResource(R.drawable.circulo);
                    oponente1Celda6.setClickable(false);
                    if(sonido){
                        mp.start();
                    }
                    contadorO++;
                    comprobarMovimientos();
                }else{
                    ImageView oponente2Celda6 = (ImageView) findViewById(R.id.celda3);
                    if(oponente2Celda6.isClickable()){
                        oponente2Celda6.setImageResource(R.drawable.circulo);
                        oponente2Celda6.setClickable(false);
                        if(sonido){
                            mp.start();
                        }
                        contadorO++;
                        comprobarMovimientos();
                    }else{
                        ImageView oponente3Celda6 = (ImageView) findViewById(R.id.celda9);
                        if(oponente3Celda6.isClickable()){
                            oponente3Celda6.setImageResource(R.drawable.circulo);
                            oponente3Celda6.setClickable(false);
                            if(sonido){
                                mp.start();
                            }
                            contadorO++;
                            comprobarMovimientos();
                        }else{
                            ImageView oponente4Celda6 = (ImageView) findViewById(R.id.celda2);
                            if(oponente4Celda6.isClickable()){
                                oponente4Celda6.setImageResource(R.drawable.circulo);
                                oponente4Celda6.setClickable(false);
                                if(sonido){
                                    mp.start();
                                }
                                contadorO++;
                                comprobarMovimientos();
                            }else{
                                ImageView oponente5Celda6 = (ImageView) findViewById(R.id.celda4);
                                if(oponente5Celda6.isClickable()){
                                    oponente5Celda6.setImageResource(R.drawable.circulo);
                                    oponente5Celda6.setClickable(false);
                                    if(sonido){
                                        mp.start();
                                    }
                                    contadorO++;
                                    comprobarMovimientos();
                                }else{
                                    ImageView oponente6Celda6 = (ImageView) findViewById(R.id.celda1);
                                    if(oponente6Celda6.isClickable()){
                                        oponente6Celda6.setImageResource(R.drawable.circulo);
                                        oponente6Celda6.setClickable(false);
                                        if(sonido){
                                            mp.start();
                                        }
                                        contadorO++;
                                        comprobarMovimientos();
                                    }else{
                                        ImageView oponente7Celda6 = (ImageView) findViewById(R.id.celda8);
                                        if(oponente7Celda6.isClickable()){
                                            oponente7Celda6.setImageResource(R.drawable.circulo);
                                            oponente7Celda6.setClickable(false);
                                            if(sonido){
                                                mp.start();
                                            }
                                            contadorO++;
                                            comprobarMovimientos();
                                        }else{
                                            ImageView oponente8Celda6 = (ImageView) findViewById(R.id.celda7);
                                            if(oponente8Celda6.isClickable()){
                                                oponente8Celda6.setImageResource(R.drawable.circulo);
                                                oponente8Celda6.setClickable(false);
                                                if(sonido){
                                                    mp.start();
                                                }
                                                contadorO++;
                                                comprobarMovimientos();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "celda7":
                ImageView oponente1Celda7 = (ImageView) findViewById(R.id.celda5);
                if(oponente1Celda7.isClickable()){
                    oponente1Celda7.setImageResource(R.drawable.circulo);
                    oponente1Celda7.setClickable(false);
                    if(sonido){
                        mp.start();
                    }
                    contadorO++;
                    comprobarMovimientos();
                }else{
                    ImageView oponente2Celda7 = (ImageView) findViewById(R.id.celda1);
                    if(oponente2Celda7.isClickable()){
                        oponente2Celda7.setImageResource(R.drawable.circulo);
                        oponente2Celda7.setClickable(false);
                        if(sonido){
                            mp.start();
                        }
                        contadorO++;
                        comprobarMovimientos();
                    }else{
                        ImageView oponente3Celda7 = (ImageView) findViewById(R.id.celda8);
                        if(oponente3Celda7.isClickable()){
                            oponente3Celda7.setImageResource(R.drawable.circulo);
                            oponente3Celda7.setClickable(false);
                            if(sonido){
                                mp.start();
                            }
                            contadorO++;
                            comprobarMovimientos();
                        }else{
                            ImageView oponente4Celda7 = (ImageView) findViewById(R.id.celda9);
                            if(oponente4Celda7.isClickable()){
                                oponente4Celda7.setImageResource(R.drawable.circulo);
                                oponente4Celda7.setClickable(false);
                                if(sonido){
                                    mp.start();
                                }
                                contadorO++;
                                comprobarMovimientos();
                            }else{
                                ImageView oponente5Celda7 = (ImageView) findViewById(R.id.celda3);
                                if(oponente5Celda7.isClickable()){
                                    oponente5Celda7.setImageResource(R.drawable.circulo);
                                    oponente5Celda7.setClickable(false);
                                    if(sonido){
                                        mp.start();
                                    }
                                    contadorO++;
                                    comprobarMovimientos();
                                }else{
                                    ImageView oponente6Celda7 = (ImageView) findViewById(R.id.celda6);
                                    if(oponente6Celda7.isClickable()){
                                        oponente6Celda7.setImageResource(R.drawable.circulo);
                                        oponente6Celda7.setClickable(false);
                                        if(sonido){
                                            mp.start();
                                        }
                                        contadorO++;
                                        comprobarMovimientos();
                                    }else{
                                        ImageView oponente7Celda7 = (ImageView) findViewById(R.id.celda4);
                                        if(oponente7Celda7.isClickable()){
                                            oponente7Celda7.setImageResource(R.drawable.circulo);
                                            oponente7Celda7.setClickable(false);
                                            if(sonido){
                                                mp.start();
                                            }
                                            contadorO++;
                                            comprobarMovimientos();
                                        }else{
                                            ImageView oponente8Celda7 = (ImageView) findViewById(R.id.celda2);
                                            if(oponente8Celda7.isClickable()){
                                                oponente8Celda7.setImageResource(R.drawable.circulo);
                                                oponente8Celda7.setClickable(false);
                                                if(sonido){
                                                    mp.start();
                                                }
                                                contadorO++;
                                                comprobarMovimientos();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "celda8":
                ImageView oponente1Celda8 = (ImageView) findViewById(R.id.celda5);
                if(oponente1Celda8.isClickable()){
                    oponente1Celda8.setImageResource(R.drawable.circulo);
                    oponente1Celda8.setClickable(false);
                    if(sonido){
                        mp.start();
                    }
                    contadorO++;
                    comprobarMovimientos();
                }else{
                    ImageView oponente2Celda8 = (ImageView) findViewById(R.id.celda9);
                    if(oponente2Celda8.isClickable()){
                        oponente2Celda8.setImageResource(R.drawable.circulo);
                        oponente2Celda8.setClickable(false);
                        if(sonido){
                            mp.start();
                        }
                        contadorO++;
                        comprobarMovimientos();
                    }else{
                        ImageView oponente3Celda8 = (ImageView) findViewById(R.id.celda7);
                        if(oponente3Celda8.isClickable()){
                            oponente3Celda8.setImageResource(R.drawable.circulo);
                            oponente3Celda8.setClickable(false);
                            if(sonido){
                                mp.start();
                            }
                            contadorO++;
                            comprobarMovimientos();
                        }else{
                            ImageView oponente4Celda8 = (ImageView) findViewById(R.id.celda1);
                            if(oponente4Celda8.isClickable()){
                                oponente4Celda8.setImageResource(R.drawable.circulo);
                                oponente4Celda8.setClickable(false);
                                if(sonido){
                                    mp.start();
                                }
                                contadorO++;
                                comprobarMovimientos();
                            }else{
                                ImageView oponente5Celda8 = (ImageView) findViewById(R.id.celda6);
                                if(oponente5Celda8.isClickable()){
                                    oponente5Celda8.setImageResource(R.drawable.circulo);
                                    oponente5Celda8.setClickable(false);
                                    if(sonido){
                                        mp.start();
                                    }
                                    contadorO++;
                                    comprobarMovimientos();
                                }else{
                                    ImageView oponente6Celda8 = (ImageView) findViewById(R.id.celda4);
                                    if(oponente6Celda8.isClickable()){
                                        oponente6Celda8.setImageResource(R.drawable.circulo);
                                        oponente6Celda8.setClickable(false);
                                        if(sonido){
                                            mp.start();
                                        }
                                        contadorO++;
                                        comprobarMovimientos();
                                    }else{
                                        ImageView oponente7Celda8 = (ImageView) findViewById(R.id.celda3);
                                        if(oponente7Celda8.isClickable()){
                                            oponente7Celda8.setImageResource(R.drawable.circulo);
                                            oponente7Celda8.setClickable(false);
                                            if(sonido){
                                                mp.start();
                                            }
                                            contadorO++;
                                            comprobarMovimientos();
                                        }else{
                                            ImageView oponente8Celda8 = (ImageView) findViewById(R.id.celda2);
                                            if(oponente8Celda8.isClickable()){
                                                oponente8Celda8.setImageResource(R.drawable.circulo);
                                                oponente8Celda8.setClickable(false);
                                                if(sonido){
                                                    mp.start();
                                                }
                                                contadorO++;
                                                comprobarMovimientos();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "celda9":
                ImageView oponente1Celda9 = (ImageView) findViewById(R.id.celda5);
                if(oponente1Celda9.isClickable()){
                    oponente1Celda9.setImageResource(R.drawable.circulo);
                    oponente1Celda9.setClickable(false);
                    if(sonido){
                        mp.start();
                    }
                    contadorO++;
                    comprobarMovimientos();
                }else{
                    ImageView oponente2Celda9 = (ImageView) findViewById(R.id.celda7);
                    if(oponente2Celda9.isClickable()){
                        oponente2Celda9.setImageResource(R.drawable.circulo);
                        oponente2Celda9.setClickable(false);
                        if(sonido){
                            mp.start();
                        }
                        contadorO++;
                        comprobarMovimientos();
                    }else{
                        ImageView oponente3Celda9 = (ImageView) findViewById(R.id.celda3);
                        if(oponente3Celda9.isClickable()){
                            oponente3Celda9.setImageResource(R.drawable.circulo);
                            oponente3Celda9.setClickable(false);
                            if(sonido){
                                mp.start();
                            }
                            contadorO++;
                            comprobarMovimientos();
                        }else{
                            ImageView oponente4Celda9 = (ImageView) findViewById(R.id.celda1);
                            if(oponente4Celda9.isClickable()){
                                oponente4Celda9.setImageResource(R.drawable.circulo);
                                oponente4Celda9.setClickable(false);
                                if(sonido){
                                    mp.start();
                                }
                                contadorO++;
                                comprobarMovimientos();
                            }else{
                                ImageView oponente5Celda9 = (ImageView) findViewById(R.id.celda8);
                                if(oponente5Celda9.isClickable()){
                                    oponente5Celda9.setImageResource(R.drawable.circulo);
                                    oponente5Celda9.setClickable(false);
                                    if(sonido){
                                        mp.start();
                                    }
                                    contadorO++;
                                    comprobarMovimientos();
                                }else{
                                    ImageView oponente6Celda9 = (ImageView) findViewById(R.id.celda2);
                                    if(oponente6Celda9.isClickable()){
                                        oponente6Celda9.setImageResource(R.drawable.circulo);
                                        oponente6Celda9.setClickable(false);
                                        if(sonido){
                                            mp.start();
                                        }
                                        contadorO++;
                                        comprobarMovimientos();
                                    }else{
                                        ImageView oponente7Celda9 = (ImageView) findViewById(R.id.celda4);
                                        if(oponente7Celda9.isClickable()){
                                            oponente7Celda9.setImageResource(R.drawable.circulo);
                                            oponente7Celda9.setClickable(false);
                                            if(sonido){
                                                mp.start();
                                            }
                                            contadorO++;
                                            comprobarMovimientos();
                                        }else{
                                            ImageView oponente8Celda9 = (ImageView) findViewById(R.id.celda6);
                                            if(oponente8Celda9.isClickable()){
                                                oponente8Celda9.setImageResource(R.drawable.circulo);
                                                oponente8Celda9.setClickable(false);
                                                if(sonido){
                                                    mp.start();
                                                }
                                                contadorO++;
                                                comprobarMovimientos();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }
    }

    public void empiezaMaquina(){
        int numeroAleatorio = (int)Math.round(Math.random()*9);
        String celdaAlatoria = "celda"+numeroAleatorio;
        ViewGroup v = (ViewGroup) findViewById(R.id.activity_jugar);
        ImageView celda = (ImageView) v.findViewWithTag(celdaAlatoria);
        celda.setImageResource(R.drawable.circulo);
        celda.setClickable(false);
        if(sonido){
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.circulo);
            mp.start();
        }
    }

    public void comprobarMovimientos(){
        ImageView celda1 = (ImageView) findViewById(R.id.celda1);
        ImageView celda2 = (ImageView) findViewById(R.id.celda2);
        ImageView celda3 = (ImageView) findViewById(R.id.celda3);
        ImageView celda4 = (ImageView) findViewById(R.id.celda4);
        ImageView celda5 = (ImageView) findViewById(R.id.celda5);
        ImageView celda6 = (ImageView) findViewById(R.id.celda6);
        ImageView celda7 = (ImageView) findViewById(R.id.celda7);
        ImageView celda8 = (ImageView) findViewById(R.id.celda8);
        ImageView celda9 = (ImageView) findViewById(R.id.celda9);
        AlertDialog alertDialog = new AlertDialog.Builder(Jugar.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Se acabo!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        salir();
                    }
                });
        if(celda1.getDrawable().getConstantState().equals(celda2.getDrawable().getConstantState())  && celda2.getDrawable().getConstantState().equals(celda3.getDrawable().getConstantState()) && !celda1.isClickable() && !celda2.isClickable() && !celda3.isClickable()){
            alertDialog.show();
        }
        if(celda4.getDrawable().getConstantState().equals(celda5.getDrawable().getConstantState()) && celda5.getDrawable().getConstantState().equals(celda6.getDrawable().getConstantState()) && !celda4.isClickable() && !celda5.isClickable() && !celda6.isClickable()){
            alertDialog.show();
        }
        if(celda7.getDrawable().getConstantState().equals(celda8.getDrawable().getConstantState()) && celda8.getDrawable().getConstantState().equals(celda9.getDrawable().getConstantState()) && !celda7.isClickable() && !celda8.isClickable() && !celda9.isClickable()){
            alertDialog.show();
        }
        if(celda1.getDrawable().getConstantState().equals(celda4.getDrawable().getConstantState()) && celda4.getDrawable().getConstantState().equals(celda7.getDrawable().getConstantState()) && !celda1.isClickable() && !celda4.isClickable() && !celda7.isClickable()){
            alertDialog.show();
        }
        if(celda2.getDrawable().getConstantState().equals(celda5.getDrawable().getConstantState()) && celda5.getDrawable().getConstantState().equals(celda8.getDrawable().getConstantState()) && !celda2.isClickable() && !celda5.isClickable() && !celda8.isClickable()){
            alertDialog.show();
        }
        if(celda3.getDrawable().getConstantState().equals(celda6.getDrawable().getConstantState()) && celda6.getDrawable().getConstantState().equals(celda9.getDrawable().getConstantState()) && !celda3.isClickable() && !celda6.isClickable() && !celda9.isClickable()){
            alertDialog.show();
        }
        if(celda1.getDrawable().getConstantState().equals(celda5.getDrawable().getConstantState()) && celda5.getDrawable().getConstantState().equals(celda9.getDrawable().getConstantState()) && !celda1.isClickable() && !celda5.isClickable() && !celda9.isClickable()){
            alertDialog.show();
        }
        if(celda3.getDrawable().getConstantState().equals(celda5.getDrawable().getConstantState()) && celda5.getDrawable().getConstantState().equals(celda7.getDrawable().getConstantState()) && !celda3.isClickable() && !celda5.isClickable() && !celda7.isClickable()){
            alertDialog.show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_salir:
                // EITHER CALL THE METHOD HERE OR DO THE FUNCTION DIRECTLY
                salir();

                return true;
            case R.id.menu_configuracion:
                Intent intent = new Intent(this, Configuracion.class);
                this.startActivity(intent);
                return true;
            case R.id.menu_jugar:
                Intent intent2 = new Intent(this, Jugar.class);
                this.startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
