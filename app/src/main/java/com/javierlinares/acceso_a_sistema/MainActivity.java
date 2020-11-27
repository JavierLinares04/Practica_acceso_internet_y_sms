package com.javierlinares.acceso_a_sistema;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Boolean conexion;
    Button B_Bluethoon, B_Wifi;
    EditText ET_pagina_web;
    String pagina_web, web_guardar;
    Switch switch_on;
    WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET_pagina_web = (EditText)findViewById(R.id.EDT_Paginas_Web);
        web = (WebView)findViewById(R.id.webView);
        switch_on = (Switch)findViewById(R.id.S_App);
        B_Bluethoon = (Button)findViewById(R.id.B_Bluethoon);
        B_Wifi = (Button)findViewById(R.id.B_Wifi);

        conexion=false;

        Toast.makeText(this, "Sin conexion", Toast.LENGTH_SHORT).show();
    }

    private void funcion_cargar_web() {
        pagina_web = ((EditText)findViewById(R.id.EDT_Paginas_Web)).getText().toString();
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("http://"+ pagina_web);
    }

                                    //APARTADO 1

    //FUNCION PARA AÑADIR UNA PAGINA WEB
    public void funcion_ir_pagina_web(View view) {
        if(conexion==true){
            funcion_cargar_web();
        }

    }



    //FUNCIONES DE BOTONES PREDEFINIDOS
    public void funcion_as(View view) {
        pagina_web = "www.as.com";
        ET_pagina_web.setText(pagina_web);
        Log.i("Web", "Se ha añadido la pagina web");

        funcion_cargar_web();
        Log.i("Web", "Carga de la pagina web");
    }

    public void funcion_personalizada(View view) {
        if (web_guardar.length()>0){
            pagina_web = web_guardar;
            Log.i("Web", "Se ha añadido la pagina web");

            funcion_cargar_web();
            Log.i("Web", "Carga de la pagina web");
        }
    }


    public void funcion_marca(View view) {
        pagina_web = "www.marca.com";
        ET_pagina_web.setText(pagina_web);
        Log.i("Web", "Se ha añadido la pagina web");

        funcion_cargar_web();
        Log.i("Web", "Carga de la pagina web");
    }

    public void funcion_sport(View view) {
        pagina_web = "www.sport.com";
        ET_pagina_web.setText(pagina_web);
        Log.i("Web", "Se ha añadido la pagina web");

        funcion_cargar_web();
        Log.i("Web", "Carga de la pagina web");
    }

    public void funcion_google(View view) {
        pagina_web = "www.google.com";
        ET_pagina_web.setText(pagina_web);
        Log.i("Web", "Se ha añadido la pagina web");

        funcion_cargar_web();
        Log.i("Web", "Carga de la pagina web");
    }


    //SWITCH
    public void funcion_Enapp(View view) {
        if(switch_on.isChecked()){
            Toast.makeText(this, "En App", Toast.LENGTH_SHORT).show();
            funcion_cargar_web();
        }
        else {
            //NO FUNCIONA
            HJGJHG
            pagina_web = ((EditText)findViewById(R.id.EDT_Paginas_Web)).getText().toString();
            Uri webpage = Uri.parse("http://"+ pagina_web);
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            Toast.makeText(this, "En Chrome", Toast.LENGTH_SHORT).show();
        }

    }


    public void funcion_marcador(View view) {
        if (conexion==true){
          ADFASDFS
        }
    }


    //NO FUNCIONA
    fgdf
    public void funcion_wifi(View view) {
        ConnectivityManager connMgr =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean isWifiConn = false;
        boolean isMobileConn = false;
        for (Network network : connMgr.getAllNetworks()) {
            NetworkInfo networkInfo = connMgr.getNetworkInfo(network);
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                isWifiConn |= networkInfo.isConnected();
            }
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                isMobileConn |= networkInfo.isConnected();
            }
        }


        if (isMobileConn == true) {
            B_Wifi.setBackgroundColor(Color.RED);
            Toast.makeText(this, "Estas conectado a los datos moviles", Toast.LENGTH_SHORT).show();

        }
        else if (isWifiConn == true) {
            B_Wifi.setBackgroundColor(Color.GREEN);
            conexion=true;
            Toast.makeText(this, "Estas conectado al wifi", Toast.LENGTH_SHORT).show();
        }
        else {
            B_Wifi.setBackgroundColor(Color.RED);
            Toast.makeText(this, "No tienes conexion", Toast.LENGTH_SHORT).show();
        }
    }

    public void funcion_almacen(View view) {
        if (switch_on.isChecked()){
            if (ET_pagina_web.getText().toString().isEmpty()==true){
                Toast.makeText(this, "Rellena el EditText", Toast.LENGTH_SHORT).show();
            }
            else{
                web_guardar = ET_pagina_web.getText().toString();
            }

        }

    }


                                //APARTADO 2






                                //APARTADO 3


    public void funcion_bluethoon(View view) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null) {
            B_Bluethoon.setBackgroundColor(Color.RED);
            Toast.makeText(this, "No tienes Bluethoon", Toast.LENGTH_SHORT).show();

        }
        else {
            B_Bluethoon.setBackgroundColor(Color.GREEN);
            Toast.makeText(this, "Tienes Bluethoon", Toast.LENGTH_SHORT).show();
        }
    }


}