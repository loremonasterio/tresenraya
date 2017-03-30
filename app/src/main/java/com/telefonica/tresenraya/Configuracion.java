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
import android.widget.CheckBox;

public class Configuracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences sp = this.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        CheckBox sonido = (CheckBox)findViewById(R.id.checkSonido);
        CheckBox maquina = (CheckBox)findViewById(R.id.checkMaquina);
        if(sp.getBoolean("Sonido",false)){
            sonido.setChecked(true);
        }
        if(sp.getBoolean("Maquina",false)){
            maquina.setChecked(true);
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

    public void salir(){
        SharedPreferences sp = this.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
        Intent intent = new Intent(this, Principal.class);
        this.startActivity(intent);
    }

    public void sonido(View v){
        CheckBox sonido = (CheckBox)findViewById(R.id.checkSonido);
        SharedPreferences sp = this.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if(sonido.isChecked()){
            editor.putBoolean("Sonido",true);
            editor.commit();
        }else{
            editor.putBoolean("Sonido",false);
            editor.commit();
        }
    }

    public void empiezaMaquina(View v){
        CheckBox maquina = (CheckBox)findViewById(R.id.checkMaquina);
        SharedPreferences sp = this.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if(maquina.isChecked()){
            editor.putBoolean("Maquina",true);
            editor.commit();
        }else{
            editor.putBoolean("Maquina",false);
            editor.commit();
        }
    }

}
