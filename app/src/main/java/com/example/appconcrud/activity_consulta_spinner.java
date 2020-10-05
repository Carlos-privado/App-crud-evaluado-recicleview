package com.example.appconcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;

import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;

import java.util.ArrayList;



public class activity_consulta_spinner extends AppCompatActivity {
    private Spinner sp_options;
    private TextView tv_cod, tv_descripcion, tv_precio;
    private FloatingActionsMenu menu;
   private FloatingActionsMenu item1, item2, item3;




    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto datos = new Dto();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_spinner);



        sp_options = (Spinner) findViewById(R.id.sp_options);
        tv_cod = (TextView) findViewById(R.id.tv_cod);
        tv_descripcion = (TextView) findViewById(R.id.tv_descripcion);
        tv_precio = (TextView) findViewById(R.id.tv_precio);





        conexion.consultaListaArticulos();


        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item, conexion.obtenerListaArticulos());
        sp_options.setAdapter(adaptador);


        sp_options.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position,
                                       long I) {

                if (position != 0) {
                    tv_cod.setText("Codigo: " + conexion.consultaListaArticulos().get(position - 1).getCodigo());

                    tv_descripcion.setText("Descripción: " + conexion.consultaListaArticulos().get(position - 1).getDescripcion());
                    tv_precio.setText("Precio: " + String.valueOf(conexion.consultaListaArticulos().get(position - 1).getPrecio()));
                } else {
                    tv_cod.setText("Código: ");
                    tv_descripcion.setText("Descripción: ");
                    tv_precio.setText("Precio: ");

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
    }


}