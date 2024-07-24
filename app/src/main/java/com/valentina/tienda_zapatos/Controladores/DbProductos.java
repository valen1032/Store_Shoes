package com.valentina.tienda_zapatos.Controladores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.valentina.tienda_zapatos.Entidades.Producto;

import java.util.ArrayList;

public class DbProductos extends DbHelper {
    DbHelper dbHelper;
    Context context;

    private String TABLE_PRODUCTOS = "t_productos";

    public DbProductos(Context context) {
        super(context);
        dbHelper = new DbHelper(context);
    }

    public int eliminarProducto(Producto producto) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] argumentos = {String.valueOf(producto.getId())};
        return db.delete(TABLE_PRODUCTOS, "id =?", argumentos);

    }

    public long nuevoProducto(Producto producto) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues valoresParainsertar = new ContentValues();
        valoresParainsertar.put("nombre", producto.getNombre());
        valoresParainsertar.put("descripcion", producto.getDescripcion());
        valoresParainsertar.put("precio", producto.getPrecio());
        valoresParainsertar.put("marca", producto.getMarca());
        return db.insert(TABLE_PRODUCTOS, null, valoresParainsertar);

    }

    public int guardarCambios(Producto productoEdit) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues valoreParaActualizar = new ContentValues();
        valoreParaActualizar.put("nombre", productoEdit.getNombre());
        valoreParaActualizar.put("descriopcion", productoEdit.getDescripcion());
        valoreParaActualizar.put("precio", productoEdit.getPrecio());
        valoreParaActualizar.put("marca", productoEdit.getMarca());

        String campoParaActualizar = "id=?";

        String[] argumentosParaActualizar = {String.valueOf(productoEdit.getId())};
        return db.update(TABLE_PRODUCTOS, valoreParaActualizar, campoParaActualizar, argumentosParaActualizar);
    }


    public ArrayList<Producto> obtenerProducto() {
        ArrayList<Producto> productos = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columnasAConsultar = {"nombre", "descripcion", "precio", "marca"};


        Cursor cursorProductos = db.rawQuery(" SELECT * FROM " + TABLE_PRODUCTOS, columnasAConsultar, null);

        if (cursorProductos == null) {
            return productos;
        }

        if ( !cursorProductos.moveToFirst()) return productos;
            do {
                int idProducto = cursorProductos.getInt(0);
                String nombreObtenidoDB = cursorProductos.getString(1);
                String descripcionObtenidoDB = cursorProductos.getString(2);
                String precioObtenidoDB = cursorProductos.getString(3);
                String marcaObtenidoDB = cursorProductos.getString(4);
                Producto productoObtenidoDB = new Producto(idProducto, nombreObtenidoDB, descripcionObtenidoDB, precioObtenidoDB, marcaObtenidoDB);

                productos.add(productoObtenidoDB);
            } while (cursorProductos.moveToNext());
            cursorProductos.close();

            return productos;

        }
    }

