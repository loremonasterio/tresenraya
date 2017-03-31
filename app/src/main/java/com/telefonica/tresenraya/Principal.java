package com.telefonica.tresenraya;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }



    public void empezarPartida(View v){
        SharedPreferences sp = this.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        EditText nombre = (EditText) this.findViewById(R.id.nombreJugador);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Nombre", nombre.getText().toString());
        editor.commit();
        Intent intent = new Intent(this, Jugar.class);
        this.startActivity(intent);
    }

    public void ranking(View v){
        Intent intent = new Intent(this, Ranking.class);
        this.startActivity(intent);
    }


}
