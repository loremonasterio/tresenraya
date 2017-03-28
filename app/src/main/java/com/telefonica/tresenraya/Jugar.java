package com.telefonica.tresenraya;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.*;

public class Jugar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        SharedPreferences sp = this.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        TextView nombreJugador = (TextView) this.findViewById(R.id.etiquetaNombre);
        String nombre = sp.getString("Nombre","");
        nombreJugador.setText("A jugar "+nombre+"!!!");
    }

    public void salir(){
        SharedPreferences sp = this.getSharedPreferences("temperaturas", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
        Intent intent = new Intent(this, Principal.class);
        this.startActivity(intent);
    }

    public void ponerCruz(View v){
        ImageView img = (ImageView) findViewById(v.getId());
        img.setImageResource(R.drawable.cruz);
        img.setClickable(false);
        ponerCirculo(img.getTag().toString());
    }

    public void ponerCirculo(String tag){
        switch (tag){
            case "celda1":
                ImageView img = (ImageView) findViewById(R.id.celda3);
                if(img.isClickable()){
                    img.setImageResource(R.drawable.circulo);
                    img.setClickable(false);
                }else{
                    ImageView img2 = (ImageView) findViewById(R.id.celda9);
                    if(img2.isClickable()){
                        img2.setImageResource(R.drawable.circulo);
                        img2.setClickable(false);
                    }
                }
                break;
            case "celda2":
                ImageView img3 = (ImageView) findViewById(R.id.celda3);
                if(img3.isClickable()){
                    img3.setImageResource(R.drawable.circulo);
                    img3.setClickable(false);
                }else{
                    ImageView img4 = (ImageView) findViewById(R.id.celda5);
                    if(img4.isClickable()){
                        img4.setImageResource(R.drawable.circulo);
                        img4.setClickable(false);
                    }
                }
                break;
            case "celda3":
                ImageView img5 = (ImageView) findViewById(R.id.celda2);
                if(img5.isClickable()){
                    img5.setImageResource(R.drawable.circulo);
                    img5.setClickable(false);
                }else{
                    ImageView img6 = (ImageView) findViewById(R.id.celda6);
                    if(img6.isClickable()){
                        img6.setImageResource(R.drawable.circulo);
                        img6.setClickable(false);
                    }
                }
                break;
            case "celda4":
                ImageView img7 = (ImageView) findViewById(R.id.celda5);
                if(img7.isClickable()){
                    img7.setImageResource(R.drawable.circulo);
                    img7.setClickable(false);
                }else{
                    ImageView img8 = (ImageView) findViewById(R.id.celda7);
                    if(img8.isClickable()){
                        img8.setImageResource(R.drawable.circulo);
                        img8.setClickable(false);
                    }
                }
                break;
            case "celda5":
                ImageView img9 = (ImageView) findViewById(R.id.celda6);
                if(img9.isClickable()){
                    img9.setImageResource(R.drawable.circulo);
                    img9.setClickable(false);
                }else{
                    ImageView img10 = (ImageView) findViewById(R.id.celda8);
                    if(img10.isClickable()){
                        img10.setImageResource(R.drawable.circulo);
                        img10.setClickable(false);
                    }
                }
                break;
            case "celda6":
                ImageView img11 = (ImageView) findViewById(R.id.celda5);
                if(img11.isClickable()){
                    img11.setImageResource(R.drawable.circulo);
                    img11.setClickable(false);
                }else{
                    ImageView img12 = (ImageView) findViewById(R.id.celda9);
                    if(img12.isClickable()){
                        img12.setImageResource(R.drawable.circulo);
                        img12.setClickable(false);
                    }
                }
                break;
            case "celda7":
                ImageView img13 = (ImageView) findViewById(R.id.celda8);
                if(img13.isClickable()){
                    img13.setImageResource(R.drawable.circulo);
                    img13.setClickable(false);
                }else{
                    ImageView img14 = (ImageView) findViewById(R.id.celda4);
                    if(img14.isClickable()){
                        img14.setImageResource(R.drawable.circulo);
                        img14.setClickable(false);
                    }
                }
                break;
            case "celda8":
                ImageView img15 = (ImageView) findViewById(R.id.celda9);
                if(img15.isClickable()){
                    img15.setImageResource(R.drawable.circulo);
                    img15.setClickable(false);
                }else{
                    ImageView img16 = (ImageView) findViewById(R.id.celda5);
                    if(img16.isClickable()){
                        img16.setImageResource(R.drawable.circulo);
                        img16.setClickable(false);
                    }
                }
                break;
            case "celda9":
                ImageView img17 = (ImageView) findViewById(R.id.celda8);
                if(img17.isClickable()){
                    img17.setImageResource(R.drawable.circulo);
                    img17.setClickable(false);
                }else{
                    ImageView img18 = (ImageView) findViewById(R.id.celda6);
                    if(img18.isClickable()){
                        img18.setImageResource(R.drawable.circulo);
                        img18.setClickable(false);
                    }
                }
                break;
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

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
