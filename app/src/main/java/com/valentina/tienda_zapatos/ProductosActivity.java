package com.valentina.tienda_zapatos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.valentina.tienda_zapatos.Adaptadores.AdapterProducto;
import com.valentina.tienda_zapatos.Controladores.DbProductos;
import com.valentina.tienda_zapatos.Entidades.Producto;

import java.util.ArrayList;

public class ProductosActivity extends AppCompatActivity {
    DbProductos dbProductos;
    AdapterProducto adapterProducto;
    RecyclerView recyclerView;
    ArrayList<Producto> ListaProducto;
    FloatingActionButton add;

    Activity actividad;
    iComunicaFragments  interfaceComunicaFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);


        dbProductos = new DbProductos(ProductosActivity.this);
        recyclerView = findViewById(R.id.recyclerView);
        add = findViewById(R.id.btn_add);
        ListaProducto = new ArrayList<>();
        /*adapterProducto = new AdapterProducto(ListaProducto);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterProducto);

        refrescarListaProductos();*/

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),recyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                Producto productoSeleccion = ListaProducto.get(position);
                Intent intent = new Intent(ProductosActivity.this,EditarProductoActivity.class);
                intent.putExtra("id", productoSeleccion.getId());
                intent.putExtra("nombre", productoSeleccion.getNombre());
                intent.putExtra("descripcion", productoSeleccion.getDescripcion());
                intent.putExtra("precio", productoSeleccion.getPrecio());
                intent.putExtra("marca", productoSeleccion.getMarca());
                startActivity(intent);

            }

            @Override
            public void onLongClick(View view, int position) {
                final Producto productoEliminacion = ListaProducto.get(position);
                AlertDialog dialog = new AlertDialog
                        .Builder(ProductosActivity.this)
                        .setPositiveButton("Si,eliminar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dbProductos.eliminarProducto(productoEliminacion);
                                refrescarListaProductos();

                            }
                        })
                        .setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setTitle("Confirmar")
                        .setMessage("¿Eliminar el producto " + productoEliminacion.getNombre() + "?")
                        .create();
                dialog.show();

            }
        }));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Simplemente cambiamos de actividad
                Intent intent = new Intent(ProductosActivity.this, AgregarProductoActivity.class);
                startActivity(intent);
            }
        });








    }

    @Override
    protected void onResume() {
        super.onResume();
        refrescarListaDeMascotas();
    }

    private void refrescarListaDeMascotas() {
        if (adapterProducto == null) return;
        ListaProducto = dbProductos.obtenerProducto();
        adapterProducto.setListaProductos(ListaProducto);
        adapterProducto.notifyDataSetChanged();
    }

    private void refrescarListaProductos() {
        if (adapterProducto == null) return;
        ListaProducto = dbProductos.obtenerProducto();
        adapterProducto.setListaProductos(ListaProducto);
        adapterProducto.notifyDataSetChanged(); }
    }

