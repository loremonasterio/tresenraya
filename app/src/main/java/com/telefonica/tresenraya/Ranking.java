package com.telefonica.tresenraya;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Ranking extends AppCompatActivity {

    private ArrayList<String> jugadores = new ArrayList<String>();
    private ArrayList<String> movimientosX = new ArrayList<String>();
    private ArrayList<String> movimientosO = new ArrayList<String>();
    private ListView listaRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listaRanking = (ListView) this.findViewById(R.id.listaRanking);
    }

    @Override
    public void onResume(){
        super.onResume();
        recuperarPartidas();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    public void recuperarPartidas() {
        //iniciar tarea en segundo plano
        ComunicacionTask2 com = new ComunicacionTask2();
        //le pasa como parámetro la dirección
        //de la página
        com.execute("http://lorenamonasterio.esy.es/recuperarpartidas.php");
    }

    private class ComunicacionTask2 extends AsyncTask<String, Void, String> {

        //    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(String... params) {

            String cadenaJson="";
            try{
                //monta la url con la dirección y parámetro
                //de envío
                URL url=new URL(params[0]);
                URLConnection con=url.openConnection();
                //recuperacion de la respuesta JSON
                String s;
                InputStream is=con.getInputStream();
                //utilizamos UTF-8 para que interprete
                //correctamente las ñ y acentos
                BufferedReader bf=new BufferedReader(
                        new InputStreamReader(is, Charset.forName("UTF-8")));
                while((s=bf.readLine())!=null){
                    cadenaJson+=s;
                }

            }
            catch(IOException ex){
                ex.printStackTrace();
            }
            return cadenaJson;
        }

        @Override
        protected void onPostExecute(String result) {
            String[] datos=null;
            try{
                //creamos un array JSON a partir de la cadena recibida
                JSONArray jarray=new JSONArray(""+result);
                //creamos el array de String con el tamaño
                //del array JSON
                datos=new String[jarray.length()];
                for(int i=0;i<jarray.length();i++){
                    JSONObject job=jarray.getJSONObject(i);
                    jugadores.add(job.getString("jugador"));
                    movimientosX.add(job.getString("movimientosX"));
                    movimientosO.add(job.getString("movimientosO"));
                }
                ArrayAdapter<String> adapter= new ArrayAdapter<String>(Ranking.this, android.R.layout.simple_list_item_1,jugadores);
                listaRanking.setAdapter(adapter);
                listaRanking.setOnItemClickListener(
                        new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent,
                                                    View view, int position, long id) {
                                Toast.makeText(Ranking.this,
                                        "Movimientos del jugador: "+movimientosX.get(position)+"\nMovimientos de la máquina: "+movimientosO.get(position),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //tvPagina.setText(libros);
            }
            catch(JSONException ex){
                ex.printStackTrace();
            }
        }
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
            case R.id.menu_ranking:
                Intent intent3 = new Intent(this, Ranking.class);
                this.startActivity(intent3);
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

}
