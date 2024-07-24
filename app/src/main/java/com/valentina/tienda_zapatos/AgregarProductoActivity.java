package com.valentina.tienda_zapatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.valentina.tienda_zapatos.Controladores.DbProductos;
import com.valentina.tienda_zapatos.Entidades.Producto;

public class AgregarProductoActivity extends AppCompatActivity {

    Button btGuardar, btCancelar;
    EditText etNombre, etDescripcion, etPrecio, etMarca;
    DbProductos dbProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etDescripcion = (EditText) findViewById(R.id.etdescipcion);
        etPrecio = (EditText) findViewById(R.id.etPrecio);
        etMarca = (EditText) findViewById(R.id.etMarca);
        btCancelar = (Button) findViewById(R.id.btn_CancelarProduct);
        btGuardar = (Button) findViewById(R.id.btn_AgregarProduct);

        dbProductos = new DbProductos(AgregarProductoActivity.this);

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNombre.setError(null);
                etDescripcion.setError(null);
                etPrecio.setError(null);
                etMarca.setError(null);
                String  nombre = etNombre.getText().toString();
                String  descripcion = etDescripcion.getText().toString();
                String  precio = etPrecio.getText().toString();
                String  marca = etMarca.getText().toString();
                if ("".equals(nombre)) {
                    etNombre.setError("Escribe el nombre del producto");
                    etNombre.requestFocus();
                    return;
                }
                if ("".equals(descripcion)) {
                   etDescripcion.setError("Escribe descripcion del producto");
                    etDescripcion.requestFocus();
                    return;
                }
                if ("".equals(precio)) {
                    etPrecio.setError("Escribe el precio del producto");
                    etPrecio.requestFocus();
                    return;
                }
                if ("".equals(marca)) {
                    etMarca.setError("Escribe la marca del producto");
                    etMarca.requestFocus();
                    return;
                }
                Producto nuevoProducto = new Producto( nombre,descripcion,precio,marca);
                long id = dbProductos.nuevoProducto(nuevoProducto);
                if (id== -1){
                    Toast.makeText(AgregarProductoActivity.this, "Error al guardar. Intenta de nuevo", Toast.LENGTH_SHORT).show();
                }else{
                    finish();
                }
            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}