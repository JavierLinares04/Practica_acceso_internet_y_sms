package com.javierlinares.acceso_a_sistema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean conexion;
    EditText ET_pagina_web;
    String pagina_web;
    Switch switch_on;
    WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET_pagina_web = (EditText)findViewById(R.id.EDT_Paginas_Web);
        web = (WebView)findViewById(R.id.webView);
        switch_on = (Switch)findViewById(R.id.S_App);

        conexion=false;
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



    //FUNCIONES DE BOTONES PREDEFINIDOS
    public void funcion_as(View view) {
        pagina_web = "www.as.com";
        ET_pagina_web.setText(pagina_web);
        Log.i("Web", "Se ha añadido la pagina web");
        funcion_cargar_web();
        Log.i("Web", "Carga de la pagina web");
    }

    public void funcion_personalizada(View view) {
        //FALTA HACERLA
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
            
        }
    }
}