package com.valentina.tienda_zapatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.valentina.tienda_zapatos.Controladores.DbProductos;
import com.valentina.tienda_zapatos.Entidades.Producto;

public class EditarProductoActivity extends AppCompatActivity {

    EditText edtNombre,edtDescripcion,edtPrecio,edtMarca;
    Button btnSave, btnCancel;
    Producto producto;
    DbProductos dbProductos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_producto);

        Bundle extras = getIntent().getExtras();
        if (extras == null){
            finish();
            return;
        }

        dbProductos = new DbProductos(EditarProductoActivity.this);

        int id = extras.getInt("id");
        String nombre = extras.getString("nombre");
        String descripcion = extras.getString("descripcion");
        String precio = extras.getString("precio");
        String marca = extras.getString("marca");

        producto = new Producto(nombre,descripcion,precio,marca,id);

        edtNombre = (EditText) findViewById(R.id.edi_Nombre);
        edtDescripcion =(EditText) findViewById(R.id.edi_Descipcion);
        edtPrecio =(EditText) findViewById(R.id.edi_Precio);
        edtMarca =(EditText) findViewById(R.id.edi_Marca);
        btnCancel = (Button) findViewById(R.id.btn_AgregarProduct);
        btnSave = (Button) findViewById(R.id.btn_CancelarProduct);

        edtNombre.setText(producto.getNombre());
        edtDescripcion.setText(producto.getDescripcion());
        edtPrecio.setText(producto.getPrecio());
        edtMarca.setText(producto.getMarca());

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNombre.setError(null);
                edtDescripcion.setError(null);
                edtPrecio.setError(null);
                edtMarca.setError(null);

                String nombre = edtNombre.getText().toString();
                String descripcion = edtDescripcion.getText().toString();
                String precio = edtPrecio.getText().toString();
                String marca = edtMarca.getText().toString();

                if (nombre.isEmpty()){
                    edtNombre.setError("Escribe el nombre");
                    edtNombre.requestFocus();
                    return;
                }

                if (descripcion.isEmpty()){
                    edtDescripcion.setError("Escribe una descripcion");
                    edtDescripcion.requestFocus();
                    return;
                }
                if (precio.isEmpty()){
                    edtPrecio.setError("Escribe el precio");
                    edtPrecio.requestFocus();
                    return;
                }
                if (marca.isEmpty()){
                    edtMarca.setError("Escribe la marca");
                    edtMarca.requestFocus();
                    return;
                }
                Producto productoCambios = new Producto(nombre,descripcion,precio,marca,producto.getId());
                int filasmodificadas = dbProductos.guardarCambios(productoCambios);
                if (filasmodificadas != 1){
                    Toast.makeText(EditarProductoActivity.this, "Error guardando cambios. Intente de nuevo.", Toast.LENGTH_SHORT).show();
                }else {
                    finish();
                }
            }
        });


    }
}