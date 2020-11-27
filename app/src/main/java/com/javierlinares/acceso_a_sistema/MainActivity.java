package com.javierlinares.acceso_a_sistema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Boolean conexion, s_activo, v_numero;
    Button B_Bluethoon, B_Wifi;
    EditText ET_pagina_web;
    String pagina_web, web_guardar, numero;
    Switch switch_on, s_almacen;
    TextView m_enviado;
    WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET_pagina_web = (EditText)findViewById(R.id.EDT_Paginas_Web);
        web = (WebView)findViewById(R.id.webView);
        switch_on = (Switch)findViewById(R.id.S_App);
        s_almacen = (Switch)findViewById(R.id.S_Almacen);
        B_Bluethoon = (Button)findViewById(R.id.B_Bluethoon);
        B_Wifi = (Button)findViewById(R.id.B_Wifi);
        numero = ((EditText)findViewById(R.id.EDT_Telefono)).getText().toString();
        m_enviado = (TextView)findViewById(R.id.TV_Mensaje);

        v_numero=false;
        conexion=false;
        s_activo=false;
        web_guardar = "";

        Toast.makeText(this, "Sin conexion", Toast.LENGTH_SHORT).show();
    }

    private void funcion_cargar_web() {
        pagina_web = ((EditText)findViewById(R.id.EDT_Paginas_Web)).getText().toString();
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("http://"+ pagina_web);
    }



    //FUNCION PARA AÑADIR UNA PAGINA WEB
    public void funcion_ir_pagina_web(View view) {
        if(conexion==true){
            funcion_cargar_web();
        }

    }

                                 //APARTADO 1

    //FUNCIONES DE BOTONES PREDEFINIDOS
    public void funcion_as(View view) {
        pagina_web = "www.as.com";
        ET_pagina_web.setText(pagina_web);
        Log.i("Web", "Se ha añadido la pagina web");

        funcion_cargar_web();
        Log.i("Web", "Carga de la pagina web");
    }

    public void funcion_personalizada(View view) {
        if(s_activo==true){
            web_guardar = ET_pagina_web.getText().toString();

            if (web_guardar.length()>0){
                pagina_web = web_guardar;
                ET_pagina_web.setText(pagina_web);
                Log.i("Web", "Se ha añadido la pagina web");

                funcion_cargar_web();
                Log.i("Web", "Carga de la pagina web");
            }
            else {
                Toast.makeText(this, "No hay nada guardado", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            if (web_guardar.length()>0){
                pagina_web = web_guardar;
                ET_pagina_web.setText(pagina_web);
                Log.i("Web", "Se ha añadido la pagina web");

                funcion_cargar_web();
                Log.i("Web", "Carga de la pagina web");
            }
            else {
                Toast.makeText(this, "No hay nada guardado", Toast.LENGTH_SHORT).show();
            }
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
           // NO FUNCIONA
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
           // PREGUNTAR QUE HAY QUE HACER
        }
    }


    public void funcion_almacen(View view) {
        if(view.getId()==R.id.S_Almacen) {
            if (s_almacen.isChecked()) {
                s_activo = true;
            } else {
                s_activo = false;
            }
        }
    }


   
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


        if (isWifiConn == true) {
            B_Wifi.setBackgroundColor(Color.GREEN);
            conexion=true;
            Toast.makeText(this, "Estas conectado al wifi", Toast.LENGTH_SHORT).show();
        }
        else if (isMobileConn == true) {
            B_Wifi.setBackgroundColor(Color.GREEN);
            conexion=true;
            Toast.makeText(this, "Estas conectado a los datos moviles", Toast.LENGTH_SHORT).show();

        }
        else {
            B_Wifi.setBackgroundColor(Color.RED);
            Toast.makeText(this, "No tienes conexion", Toast.LENGTH_SHORT).show();
        }
    }




                                //APARTADO 2


     public void funcion_preparar(View view) {
        //NO FUNCIONA
         numero = ((EditText)findViewById(R.id.EDT_Telefono)).getText().toString();
         pagina_web = ((EditText)findViewById(R.id.EDT_Paginas_Web)).getText().toString();
         funcion_verificar_numero(numero);
         if(v_numero==true){
             Uri u_numero = Uri.parse(numero);
             composeMmsMessage(pagina_web, u_numero);
         }



     }



     public void funcion_enviar(View view) {
         numero = ((EditText)findViewById(R.id.EDT_Telefono)).getText().toString();
         pagina_web = ((EditText)findViewById(R.id.EDT_Paginas_Web)).getText().toString();

         funcion_verificar_numero(numero);
         if(v_numero==true) {
             try {

                 int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
                 if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                     //Toast.makeText(this, "No tiene permiso", Toast.LENGTH_SHORT).show();
                     ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 225);
                 } else {
                     // Toast.makeText(this, "Ya tiene permiso", Toast.LENGTH_SHORT).show();
                 }

                 SmsManager mensaje = SmsManager.getDefault();
                 mensaje.sendTextMessage(numero, null, pagina_web, null, null);
                 Toast.makeText(this, "Mensaje enviado", Toast.LENGTH_SHORT).show();
                 funcion_escribir_mensaje(pagina_web);

             } catch (Exception e) {
                 Toast.makeText(this, "Mensaje no enviado", Toast.LENGTH_SHORT).show();
             }
         }
     }


      public void funcion_verificar_numero(String numero){

        if ( (numero.charAt(0)== '6' || numero.charAt(0)== '8') &&  numero.length()==9){
            v_numero=true;

        }
        else {
            v_numero=false;
            Toast.makeText(this, "Numero Incorrecto", Toast.LENGTH_SHORT).show();
        }
    }


    public void funcion_escribir_mensaje(String mensaje){
        m_enviado.setText("Mensaje enviado: "+ mensaje);
    }

    public void composeMmsMessage(String message, Uri attachment) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, attachment);
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
            funcion_escribir_mensaje(message);
        }
    }




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